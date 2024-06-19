package de.aperepublic.server.config;
import de.aperepublic.server.services.PriceHistoryTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ScheduledPrices {

    private final String STOCK = "AAPL";

    @Autowired
    public PriceHistoryTracker priceHistoryTracker;

    @Scheduled(fixedRate = 2000)
    public void performTask() {
        if(!priceHistoryTracker.hasEntry(STOCK)) {
            priceHistoryTracker.addEntry(STOCK, 184.29, String.valueOf(System.currentTimeMillis() / 1000));
            System.out.println(184.29);
        } else {
            BigDecimal bd = new BigDecimal(priceHistoryTracker.getLatestPriceOf(STOCK) + (2 * (Math.random() - 0.4)));
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            double price = bd.doubleValue();
            priceHistoryTracker.addEntry(STOCK, price, String.valueOf(System.currentTimeMillis() / 1000));
            System.out.println(price);
        }

    }
}
