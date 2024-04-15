package de.aperepublic.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AktienController {

    @PostMapping("/aktie/info")
    public Map<String, Object> bedieneAktieInfo() {
        return Map.of("anfrageStatus", 0, "symbol", "aapl", "name", "Apple");
    }

    @PostMapping("/aktie/preis/historisch")
    public Map<String, Object> bedieneAktienPreisHistorisch(@RequestBody String iteration) {
        return Map.of("anfrageStatus", 0, "history", List.of(150.4, 148.7, 145.3, 146.1));
    }

    @PostMapping("/aktie/preis/echtzeit")
    public Map<String, Object> bedieneAktiePreisEchtzeit(@RequestBody String symbol) {
        return Map.of("anfrageStatus", 0, "symbol", symbol, "price", 173.52);
    }

    @PostMapping("/aktie/handeln")
    public Map<String, Object> bedieneAktiePreisEchtzeit(@RequestBody String aktion, @RequestBody String symbol, @RequestParam double menge) {
        if(aktion.contentEquals("kaufen")) {
            return Map.of("anfrageStatus", 0, "kaufStatus", true, "symbol", symbol, "menge", menge, "price", 173.52);
        } else if(aktion.contentEquals("verkaufen")) {
            return Map.of("anfrageStatus", 0, "verkaufStatus", true, "symbol", symbol, "menge", menge, "price", 173.52);
        } else {
            return Map.of("anfrageStatus", 1);
        }
    }

}
