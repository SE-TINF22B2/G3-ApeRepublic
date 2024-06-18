package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StockRequest {

    @JsonProperty("token")
    public String token;

    @JsonProperty("symbol")
    public String symbol;

}
