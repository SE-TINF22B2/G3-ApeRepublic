package de.aperepublic.server.services;

import de.aperepublic.server.models.response.PriceEntry;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

public class PriceHistoryTracker {

    private Map<String, List<PriceEntry>> stocksMap = new HashMap<>();

    private void addEntry(String symbol, double price, String timestamp) {
        if (!stocksMap.containsKey(symbol)) {
            stocksMap.put(symbol, new ArrayList<>());
        }
        stocksMap.get(symbol).add(new PriceEntry(price, timestamp));
        sortListOf(symbol);
    }

    private List<PriceEntry> getAllEntriesOf(String symbol) {
        return stocksMap.get(symbol);
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
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }


}
