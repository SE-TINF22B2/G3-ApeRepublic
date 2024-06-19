package de.aperepublic.server.config;
import de.aperepublic.server.services.PriceHistoryTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPrices {

    private final String STOCK = "AAPL";

    @Autowired
    public PriceHistoryTracker priceHistoryTracker;

    @Scheduled(fixedRate = 2000)
    public void performTask() {
        if(!priceHistoryTracker.hasEntry(STOCK)) {
            priceHistoryTracker.addEntry(STOCK, 184.29, String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            double price = priceHistoryTracker.getLatestPriceOf(STOCK) + (2 * (Math.random() - 0.5));
            priceHistoryTracker.addEntry(STOCK, price, String.valueOf(System.currentTimeMillis() / 1000));
        }

    }
}
