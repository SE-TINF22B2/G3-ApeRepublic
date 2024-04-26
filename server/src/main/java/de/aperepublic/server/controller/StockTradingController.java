package de.aperepublic.server.controller;

public class StockTradingController {


    @GetMapping("/aktie/info")
    public AktieInfo bedieneAktieInfo() {
        return new AktieInfo();
    }

}
