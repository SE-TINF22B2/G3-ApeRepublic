package de.aperepublic.server.controller;

import de.aperepublic.server.models.response.PriceEntry;
import de.aperepublic.server.services.FinnhubStockPriceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class StockPriceController {

    FinnhubStockPriceService finnhubStockPriceService;

    @GetMapping("/aktie/preis/historisch")
    public List<PriceEntry> bedieneAktienPreisHistorisch(@RequestParam String symbol) { //lieber RequestParam
        return finnhubStockPriceService.getPriceHistory(symbol);
    }

    @GetMapping("/aktie/preis/echtzeit")
    public Map<String, Object> bedieneAktiePreisEchtzeit(@RequestParam String symbol) {
        return Map.of("anfrageStatus", 0, "history", List.of(150.4, 148.7, 145.3, 146.1));
    }

    @PostMapping("/aktie/handeln") //bin mir nicht sicher ob hier ein get kommt
    public Map<String, Object> bedieneAktiePreisEchtzeit(@RequestBody String aktion, @RequestBody String symbol, @RequestParam double menge) {
        if (aktion.contentEquals("kaufen")) {
            return Map.of("anfrageStatus", 0, "kaufStatus", true, "symbol", symbol, "menge", menge, "price", 173.52);
        } else if (aktion.contentEquals("verkaufen")) {
            return Map.of("anfrageStatus", 0, "verkaufStatus", true, "symbol", symbol, "menge", menge, "price", 173.52);
        } else {
            return Map.of("anfrageStatus", 1);
        }
    }

    @GetMapping("/aktie/openWebSockets")
    public void openWebSockets() throws InterruptedException {
        List<String> temp = new ArrayList<>();
        temp.add("AAPL");
        finnhubStockPriceService.openWebSockets(temp);
    }

}
