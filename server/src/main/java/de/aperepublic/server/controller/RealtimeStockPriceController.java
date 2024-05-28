package de.aperepublic.server.controller;

import de.aperepublic.server.models.requests.StockPriceRequest;
import de.aperepublic.server.services.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class RealtimeStockPriceController {

    @Autowired
    private StockPriceService stockPriceService;

    @PostMapping("")
    public ResponseEntity<String> serveStockPriceRequest(@RequestBody StockPriceRequest stockPriceRequest) {
        return stockPriceService.processCurrentStockPriceRequest(stockPriceRequest);
    }

}
