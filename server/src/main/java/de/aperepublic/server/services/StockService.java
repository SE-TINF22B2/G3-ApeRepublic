package de.aperepublic.server.services;

import de.aperepublic.server.Entity.Position;
import de.aperepublic.server.Entity.Trade;
import de.aperepublic.server.Entity.User;
import de.aperepublic.server.models.requests.StockRequest;
import de.aperepublic.server.models.requests.TokenRequest;
import de.aperepublic.server.models.requests.TradeRequest;
import de.aperepublic.server.models.response.APIResponse;
import de.aperepublic.server.models.response.ResponseStatus;
import de.aperepublic.server.repositories.PositionRepository;
import de.aperepublic.server.repositories.TradeRepository;
import de.aperepublic.server.repositories.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private FinnhubStockPriceService finnhubStockPriceService;

    public ResponseEntity<String> processPositionRequest(StockRequest stockRequest) {
        // Check Token
        if (!activeUserService.validate(stockRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        // Get User, return error if not found
        Optional<User> optRequestUser = userRepository.findByEmail(activeUserService.getEmailByToken(stockRequest.token).get());
        if (optRequestUser.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
        }
        User user = optRequestUser.get();
        // Get Position
        Optional<Position> optPosition = positionRepository.findAll().stream().filter(p -> p.symbol.contentEquals(stockRequest.symbol)).filter(p -> p.idUser == user.userID).findFirst();
        // Return Position
        if(optPosition.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.VALID_REQUEST).addAttribute("position", new Position(0, stockRequest.symbol, BigDecimal.valueOf(0), BigDecimal.valueOf(0)).toJSON()).toString());
        }
        return ResponseEntity.ok(new APIResponse(ResponseStatus.VALID_REQUEST).addAttribute("position", optPosition.get().toJSON()).toString());
    }

    public ResponseEntity<String> processPortfolioRequest(TokenRequest tokenRequest) {
        // Check Token
        if (!activeUserService.validate(tokenRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        // Get User, return error if not found
        Optional<User> optRequestUser = userRepository.findByEmail(activeUserService.getEmailByToken(tokenRequest.token).get());
        if (optRequestUser.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
        }
        User user = optRequestUser.get();
        // Get Trades
        List<JSONObject> positions = positionRepository.findAll().stream().filter(p -> p.idUser.equals(user.userID)).map(p -> p.toJSON()).toList();
        // Return Trades
        return ResponseEntity.ok(new APIResponse(ResponseStatus.VALID_REQUEST).addList("positions", new JSONArray(positions)).toString());
    }

    public ResponseEntity<String> processTradesRequest(StockRequest stockRequest) {
        // Check Token
        if (!activeUserService.validate(stockRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        // Get User, return error if not found
        Optional<User> optRequestUser = userRepository.findByEmail(activeUserService.getEmailByToken(stockRequest.token).get());
        if (optRequestUser.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
        }
        User user = optRequestUser.get();
        // Get Trades
        System.out.println("SELECT * FROM Trades t WHERE t.idUser = " + user.userID + " AND t.symbol = " + stockRequest.symbol + ";");
        List<JSONObject> trades = tradeRepository.findAllByIdUserAndSymbol(user.userID, stockRequest.symbol).stream().map(t -> t.toJSON()).toList();
        // Return Trades
        return ResponseEntity.ok(new APIResponse(ResponseStatus.VALID_REQUEST).addList("trades", new JSONArray(trades)).toString());
    }

    public ResponseEntity<String> processTradeRequest(TradeRequest tradeRequest) {
        // Check Token
        if (!activeUserService.validate(tradeRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        // Get User, return error if not found
        Optional<User> optRequestUser = userRepository.findByEmail(activeUserService.getEmailByToken(tradeRequest.token).get());
        if (optRequestUser.isEmpty()) {
            // TODO: User not registered & Remove Token
            return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
        }
        User user = optRequestUser.get();
        // Check if Amout is != 0.0, if yes return ok
        if(tradeRequest.amount.signum() == 0) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.VALID_REQUEST).toString());
        }
        // Get Position
        Optional<Position> optPosition = positionRepository.findAll().stream().filter(p -> p.symbol.contentEquals(tradeRequest.symbol)).filter(p -> p.idUser == user.userID).findFirst();
        Position position;
        // If sell, check if User has enough stocks
        if(tradeRequest.amount.signum() < 1) {
            if(optPosition.isEmpty()) {
                // TODO: Not enough stocks
                return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
            }
            if(-1 == tradeRequest.amount.compareTo(optPosition.get().amount)) {
                // TODO: Not enough stocks
                return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
            }
            System.out.println("Position created (sell)");
            position = optPosition.get();
        } else if(optPosition.isEmpty()) {
            System.out.println("Position created (buy)");
            position = new Position(user.userID, tradeRequest.symbol, tradeRequest.amount, BigDecimal.ZERO);
            positionRepository.saveAndFlush(position);
        } else {
            System.out.println("Position loaded");
            position = optPosition.get();
        }

        // Get Current Price
        BigDecimal curPrice = BigDecimal.valueOf(Double.valueOf(finnhubStockPriceService.getLatestPriceEntry(tradeRequest.symbol)));
        // Create Trade
        Trade trade = new Trade(0, curPrice, tradeRequest.amount, tradeRequest.symbol, user.userID);
        tradeRepository.saveAndFlush(trade);
        // Update Position
        position.amount = position.amount.add(tradeRequest.amount);
        positionRepository.update(position);
        // Return Trades
        return ResponseEntity.ok(new APIResponse(ResponseStatus.VALID_REQUEST).addAttribute("trade", trade.toJSON()).toString());
    }
}
