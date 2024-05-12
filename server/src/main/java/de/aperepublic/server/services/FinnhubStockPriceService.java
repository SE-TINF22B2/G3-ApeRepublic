package de.aperepublic.server.services;

import de.aperepublic.server.models.FinnhubWebSocket;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class FinnhubStockPriceService {
    private static final String WEBSOCKET_URI_STRING = "wss://ws.finnhub.io?token=cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g";
    private PriceHistoryTracker priceHistoryTracker = new PriceHistoryTracker();

    @GetMapping
    private String openWebSocket(@RequestParam String symbol) {
        URI websocket_uri = null;
        try {
            websocket_uri = new URI(WEBSOCKET_URI_STRING);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        FinnhubWebSocket ws = new FinnhubWebSocket(websocket_uri);
        ws.connect();

        return "A"; //TODO
    }
}
