package de.aperepublic.server.config;
import de.aperepublic.server.services.PriceHistoryTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledPrices {

    private final ArrayList<StockTemplate> STOCKS = new ArrayList<>(List.of(new StockTemplate("AAPL", 184.29), new StockTemplate("MSFT", 416.96), new StockTemplate("NVDA", 129.90)));

    @Autowired
    public PriceHistoryTracker priceHistoryTracker;

    @Scheduled(fixedRate = 2000)
    public void performTask() {
        for (StockTemplate stock : STOCKS) {
            if(!priceHistoryTracker.hasEntry(stock.name)) {
                priceHistoryTracker.addEntry(stock.name, stock.initValue, String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                BigDecimal bd = new BigDecimal(priceHistoryTracker.getLatestPriceOf(stock.name) + (2 * (Math.random() - 0.4)));
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                double price = bd.doubleValue();
                priceHistoryTracker.addEntry(stock.name, price, String.valueOf(System.currentTimeMillis() / 1000));
            }
        }
    }

    class StockTemplate {
        String name;
        double initValue;
        public StockTemplate(String name, double value) {
            this.name = name;
            this.initValue = value;
        }
    }
}
