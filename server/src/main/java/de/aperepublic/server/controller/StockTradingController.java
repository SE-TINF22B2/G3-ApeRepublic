package de.aperepublic.server.controller;

import de.aperepublic.server.models.AktieInfo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

public class StockTradingController {


    @GetMapping("/aktie/info")
    public Map<String, Object> bedieneAktieInfo() {
        return Map.of("anfrageStatus", 0, "history", List.of(150.4, 148.7, 145.3, 146.1));
    }

}
