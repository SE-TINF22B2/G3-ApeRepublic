package de.aperepublic.server.services;

import de.aperepublic.server.models.response.PriceEntry;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class PriceHistoryTracker {

    public final int MAX_ENTRIES = 50;
    public Map<String, List<PriceEntry>> stocksMap = new HashMap<>();

    public void addEntry(String symbol, double price, String timestamp) {
        if (!stocksMap.containsKey(symbol)) {
            stocksMap.put(symbol, new ArrayList<>());
        }
        stocksMap.get(symbol).add(new PriceEntry(price, timestamp));
        sortListOf(symbol);
        trimListOf(symbol);
    }

    public void addEntry(String symbol, PriceEntry entry) {
        if (!stocksMap.containsKey(symbol)) {
            stocksMap.put(symbol, new ArrayList<>());
        }
        stocksMap.get(symbol).add(entry);
        sortListOf(symbol);
        trimListOf(symbol);
    }

    public boolean hasEntry(String symbol) {
        return stocksMap.containsKey(symbol);
    }

    public List<PriceEntry> getAllEntriesOf(String symbol) {
        return stocksMap.get(symbol);
    }

    public PriceEntry getLatestPriceEntryOf(String symbol) {
        if (stocksMap.get(symbol) == null) {
            return new PriceEntry(0, "11111111");
        } else {
            return stocksMap.get(symbol).get(0);
        }
    }
    public double getLatestPriceOf(String symbol) {
        if (stocksMap.get(symbol) == null) {
            return 0.0;
        } else {
            return stocksMap.get(symbol).get(0).price();
        }
    }


    private void sortListOf(String symbol) {
        stocksMap.get(symbol).sort(new Comparator<PriceEntry>() {
            @Override
            public int compare(PriceEntry o1, PriceEntry o2) {
                LocalDateTime o1Time = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(o1.timestamp())), TimeZone
                        .getDefault().toZoneId());
                LocalDateTime o2Time = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(o2.timestamp())), TimeZone
                        .getDefault().toZoneId());
                if (o1Time.isBefore(o2Time)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    private void trimListOf(String symbol) {
        List<PriceEntry> entries = stocksMap.get(symbol);
        if (entries.size() > MAX_ENTRIES) {
            stocksMap.put(symbol, entries.subList(0, MAX_ENTRIES));
        }
    }


}
