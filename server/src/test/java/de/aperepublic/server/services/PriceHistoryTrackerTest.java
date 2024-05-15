package de.aperepublic.server.services;

import de.aperepublic.server.models.response.PriceEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceHistoryTrackerTest {

    PriceHistoryTracker historyTracker;

    @BeforeEach
    void setup() {
        historyTracker = new PriceHistoryTracker();
        historyTracker.addEntry("AAPL", 133.1, "1715675835");
        historyTracker.addEntry("AAPL", 130.22, "1707903435");
        historyTracker.addEntry("AAPL", 130.7, "1713083835");
    }

    @Test
    void testPriceEntryCreation() {
        assertEquals(3, historyTracker.getAllEntriesOf("AAPL").size());
    }

    @Test
    void testGetLatestPrice() {
        assertEquals(133.1, historyTracker.getLatestPriceOf("AAPL").price());
    }

    @Test
    void testGetWholeListOfEntries() {
        List<PriceEntry> testList = new ArrayList<>();
        testList.add(new PriceEntry(133.1, "1715675835"));
        testList.add(new PriceEntry(130.7, "1713083835"));
        testList.add(new PriceEntry(130.22, "1707903435"));
        assertEquals(testList, historyTracker.getAllEntriesOf("AAPL"));
    }

    @Test
    void testMultipleStocksSaved() {
        historyTracker.addEntry("MSCI", 100, "1707903435");
        historyTracker.addEntry("MSCI", 130, "1707943435");
        assertEquals(130, historyTracker.getLatestPriceOf("MSCI").price());
    }

}