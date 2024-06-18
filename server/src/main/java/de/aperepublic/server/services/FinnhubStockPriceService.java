package de.aperepublic.server.services;

import de.aperepublic.server.models.FinnhubWebSocket;
import de.aperepublic.server.models.response.PriceEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

//@Service
@RestController
public class FinnhubStockPriceService {
    private static final String WEBSOCKET_URI_STRING = "wss://ws.finnhub.io?token=cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g";
    private static final String WEBSOCKET_URI_STRING2 = "wss://ws.finnhub.io?token=cp1mar9r01qhquus5j5gcp1mar9r01qhquus5j60";
    public PriceHistoryTracker priceHistoryTracker = new PriceHistoryTracker();
    private FinnhubWebSocket ws;

    @GetMapping("/stream/stockPrice")
    private String connectWebSocketDual() throws InterruptedException {
        ws = new FinnhubWebSocket(URI.create(WEBSOCKET_URI_STRING));
        ws.connectBlocking();
        ws.setPriceTracker(priceHistoryTracker);
        ws.subscribeToStock("AAPL");
        ws.subscribeToStock("MSFT");
        return "Opened";
    }

    @GetMapping("/stream/stock")
    private String streamLatestPrice(@RequestParam String symbol) {
        double result = priceHistoryTracker.getLatestPriceOf(symbol).price();
        if (result == 0) {
            // No Price found
            return "0";
        } else {
            return String.valueOf(priceHistoryTracker.getLatestPriceOf(symbol).price());
        }
    }

    public String getLatestPriceEntry(String symbol) {
        PriceEntry entry = priceHistoryTracker.getLatestPriceOf(symbol);
        if (entry.price() == 0) {
            // No Price found
            return "0";
        } else {
            return String.valueOf(entry);
        }
    }

    public List<PriceEntry> getPriceHistory(String symbol) {
        return priceHistoryTracker.getAllEntriesOf(symbol);
    }

    public void openWebSockets(List<String> symbols) throws InterruptedException {
        ws = new FinnhubWebSocket(URI.create(WEBSOCKET_URI_STRING));
        ws.connectBlocking();
        ws.setPriceTracker(priceHistoryTracker);
        symbols.forEach(symbolEntry -> ws.subscribeToStock(symbolEntry));
    }

}
