package de.aperepublic.server.controller;

import de.aperepublic.server.models.AktieInfo;
import org.springframework.web.bind.annotation.GetMapping;

public class StockTradingController {


    @GetMapping("/aktie/info")
    public AktieInfo bedieneAktieInfo() {
        return new AktieInfo();
    }

}
