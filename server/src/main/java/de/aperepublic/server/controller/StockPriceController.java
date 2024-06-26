package de.aperepublic.server.controller;

import de.aperepublic.server.models.requests.StockPriceRequest;
import de.aperepublic.server.services.FinnhubStockPriceService;
import de.aperepublic.server.services.StockPriceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
public class StockPriceController {

    @Autowired
    StockPriceService stockPriceService;

    FinnhubStockPriceService finnhubStockPriceService;

    @PostMapping("/stock/price/realtime")
    public ResponseEntity<String> serveRealtimeStockPriceRequest(@RequestBody StockPriceRequest stockPriceRequest) {
        return stockPriceService.processRealtimeStockPriceRequest(stockPriceRequest);
    }

    @PostMapping("/stock/price/progression")
    public ResponseEntity<String> serverProgressionStockPriceRequest(@RequestBody StockPriceRequest stockPriceRequest) {
        return stockPriceService.processProgressionStockPriceRequest(stockPriceRequest);
    }

    @GetMapping("/stock/openWebSocket")
    public ResponseEntity<String> openWebSockets(@RequestParam String symbol) throws InterruptedException {
        return stockPriceService.openWebSockets(symbol);
    }

//    @PostMapping("/aktie/handeln") //bin mir nicht sicher ob hier ein get kommt
//    public Map<String, Object> bedieneAktiePreisEchtzeit(@RequestBody String aktion, @RequestBody String symbol, @RequestParam double menge) {
//        if (aktion.contentEquals("kaufen")) {
//            return Map.of("anfrageStatus", 0, "kaufStatus", true, "symbol", symbol, "menge", menge, "price", 173.52);
//        } else if (aktion.contentEquals("verkaufen")) {
//            return Map.of("anfrageStatus", 0, "verkaufStatus", true, "symbol", symbol, "menge", menge, "price", 173.52);
//        } else {
//            return Map.of("anfrageStatus", 1);
//        }
//    }
//
//    @GetMapping("/aktie/openWebSockets")
//    public void openWebSockets() throws InterruptedException {
//        List<String> temp = new ArrayList<>();
//        temp.add("AAPL");
//        finnhubStockPriceService.openWebSockets(temp);
//    }

}
