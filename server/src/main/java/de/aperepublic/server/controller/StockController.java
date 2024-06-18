package de.aperepublic.server.controller;

import de.aperepublic.server.models.requests.StockRequest;
import de.aperepublic.server.models.requests.TokenRequest;
import de.aperepublic.server.models.requests.TradeRequest;
import de.aperepublic.server.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/api/stock/position")
    public ResponseEntity<String> servePositionRequest(@RequestBody StockRequest stockRequest) {
        return stockService.processPositionRequest(stockRequest);
    }

    @PostMapping("/api/stock/portfolio")
    public ResponseEntity<String> servePortfolioRequest(@RequestBody TokenRequest tokenRequest) {
        return stockService.processPortfolioRequest(tokenRequest);
    }

    @PostMapping("/api/stock/trades")
    public ResponseEntity<String> serveTradesRequest(@RequestBody StockRequest stockRequest) {
        return stockService.processTradesRequest(stockRequest);
    }

    @PostMapping("/api/stock/trade")
    public ResponseEntity<String> serveTradesRequest(@RequestBody TradeRequest tradeRequest) {
        return stockService.processTradeRequest(tradeRequest);
    }

}
