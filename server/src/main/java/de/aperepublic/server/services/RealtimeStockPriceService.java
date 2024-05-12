package de.aperepublic.server.services;

import de.aperepublic.server.models.requests.RealtimeStockPriceRequest;
import de.aperepublic.server.models.response.APIResponse;
import de.aperepublic.server.models.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RealtimeStockPriceService {

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private PriceHistoryTracker priceHistoryTracker;

    public ResponseEntity<String> processRealtimeStockPriceRequest(RealtimeStockPriceRequest realtimeStockPriceRequest) {
        if(!activeUserService.validate(realtimeStockPriceRequest.token)) {
            return ResponseEntity.ok(APIResponse.instance(ResponseStatus.INVALID_TOKEN).toString());
        }
        // TODO: Has ISIN
//        if(!realtimeStockPriceService.has(realtimeStockPriceRequest.isin)) {
//            return ResponseEntity.ok(APIResponse.instance(ResponseStatus.INVALID_ISIN).toString());
//        }
        // TODO: Get Value and Return
        int price = 0; //priceHistoryTracker.getCurrentPrice(realtimeStockPriceRequest.isin);
        return ResponseEntity.ok(APIResponse.instance(ResponseStatus.SUCCESSFUL_PRICE_REQUEST).addAttribute("price", String.valueOf(price)).addAttribute("isin", realtimeStockPriceRequest.isin).toString());
    }

}
