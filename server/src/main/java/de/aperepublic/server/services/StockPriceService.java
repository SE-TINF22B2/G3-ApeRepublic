package de.aperepublic.server.services;

import de.aperepublic.server.models.FinnhubWebSocket;
import de.aperepublic.server.models.requests.StockPriceRequest;
import de.aperepublic.server.models.response.APIResponse;
import de.aperepublic.server.models.response.PriceEntry;
import de.aperepublic.server.models.response.ResponseStatus;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class StockPriceService {

    private FinnhubWebSocket ws;
    private static final String WEBSOCKET_URI_STRING = "wss://ws.finnhub.io?token=cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g";
    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private PriceHistoryTracker priceHistoryTracker;

    public ResponseEntity<String> processRealtimeStockPriceRequest(StockPriceRequest stockPriceRequest) {
        if (!activeUserService.validate(stockPriceRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        if (!priceHistoryTracker.hasEntry(stockPriceRequest.symbol)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_SYMBOL).toString());
        }
        PriceEntry priceEntry = priceHistoryTracker.getLatestPriceOf(stockPriceRequest.symbol);
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_PRICE_REQUEST).addAttribute("prices", new JSONArray(priceEntry).toString()).addAttribute("symbol", stockPriceRequest.symbol).toString());
    }

    public ResponseEntity<String> processProgressionStockPriceRequest(StockPriceRequest stockPriceRequest) {
        if (!activeUserService.validate(stockPriceRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        if (!priceHistoryTracker.hasEntry(stockPriceRequest.symbol)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_SYMBOL).toString());
        }
        List<PriceEntry> priceEntries = priceHistoryTracker.getAllEntriesOf(stockPriceRequest.symbol);
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_PRICE_REQUEST).addAttribute("prices", new JSONArray(priceEntries).toString()).addAttribute("symbol", stockPriceRequest.symbol).toString());
    }

    public String openWebSockets(String symbol) throws InterruptedException {
        ws = new FinnhubWebSocket(URI.create(WEBSOCKET_URI_STRING));
        ws.connectBlocking();
        ws.setPriceTracker(priceHistoryTracker);
        ws.subscribeToStock(symbol);
        return "Success";
    }

}
