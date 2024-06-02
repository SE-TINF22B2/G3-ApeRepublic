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

    public ResponseEntity<String> processRealtimeStockPriceRequest(RealtimeStockPriceRequest realtimeStockPriceRequest) {
        if(!activeUserService.validate(realtimeStockPriceRequest.token)) {
            return ResponseEntity.ok(APIResponse.instance(ResponseStatus.INVALID_TOKEN).toString());
        }
        // TODO: Has ISIN
        // TODO: Get Value and Return
        return ResponseEntity.ok(APIResponse.instance(ResponseStatus.ERROR).toString());
    }

}
