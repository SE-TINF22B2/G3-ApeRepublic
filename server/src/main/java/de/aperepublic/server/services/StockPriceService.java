package de.aperepublic.server.services;

import de.aperepublic.server.models.requests.StockPriceRequest;
import de.aperepublic.server.models.response.APIResponse;
import de.aperepublic.server.models.response.PriceEntry;
import de.aperepublic.server.models.response.ResponseStatus;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPriceService {

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private PriceHistoryTracker priceHistoryTracker;

    public ResponseEntity<String> processCurrentStockPriceRequest(StockPriceRequest stockPriceRequest) {
        if(!activeUserService.validate(stockPriceRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        if(!priceHistoryTracker.hasEntry(stockPriceRequest.symbol)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_SYMBOL).toString());
        }
        PriceEntry priceEntry = priceHistoryTracker.getLatestPriceOf(stockPriceRequest.symbol);
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_PRICE_REQUEST).addAttribute("prices", new JSONArray(priceEntry).toString()).addAttribute("symbol", stockPriceRequest.symbol).toString());
    }

    public ResponseEntity<String> processProgressionStockPriceRequest(StockPriceRequest stockPriceRequest) {
        if(!activeUserService.validate(stockPriceRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        if(!priceHistoryTracker.hasEntry(stockPriceRequest.symbol)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_SYMBOL).toString());
        }
        List<PriceEntry> priceEntries = priceHistoryTracker.getAllEntriesOf(stockPriceRequest.symbol);
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_PRICE_REQUEST).addAttribute("prices", new JSONArray(priceEntries).toString()).addAttribute("symbol", stockPriceRequest.symbol).toString());
    }

}
