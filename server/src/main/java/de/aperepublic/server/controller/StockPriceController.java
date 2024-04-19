package de.aperepublic.server.controller;

import de.aperepublic.server.models.AktieHistorie;
import de.aperepublic.server.models.AktieInfo;
import de.aperepublic.server.models.AktiePreis;
import de.aperepublic.server.services.FinnhubCompanyProfile2Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StockPriceController {

    FinnhubCompanyProfile2Service companyProfile2Service;

    @GetMapping("/aktie/preis/historisch")
    public Map<String, Object> bedieneAktienPreisHistorisch(@RequestBody String iteration) { //lieber RequestParam
        return Map.of("anfrageStatus", 0, "history", List.of(150.4, 148.7, 145.3, 146.1));
    }

    @GetMapping("aktie/historie")
    public AktieHistorie bedieneHistorie() {
        Map<LocalDateTime, Double> historyMap = new HashMap<>();
        historyMap.put(LocalDateTime.now(), 150.4);
        historyMap.put(LocalDateTime.now().minusSeconds(1), 153.3);
        historyMap.put(LocalDateTime.now().minusSeconds(3), 151.2);
        historyMap.put(LocalDateTime.now().minusMinutes(2), 150.0);
        return new AktieHistorie();
    }

    @GetMapping("/aktie/preis/echtzeit")
    public AktiePreis bedieneAktiePreisEchtzeit(@RequestParam String symbol) {
        return new AktiePreis();
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

}
