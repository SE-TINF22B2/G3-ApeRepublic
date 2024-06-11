package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RealtimeStockPriceRequest {

    @JsonProperty("token")
    public String token;

    @JsonProperty("isin")
    public String isin;

}
