package de.aperepublic.server.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinnhubStockPriceServiceTest {

    FinnhubStockPriceService finnhubStockPriceService;

    @BeforeAll
    void setup() {
        finnhubStockPriceService = new FinnhubStockPriceService();
    }

}