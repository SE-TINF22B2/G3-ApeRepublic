package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockPriceRequest {

    @JsonProperty("token")
    public String token;

    @JsonProperty("symbol")
    public String symbol;

}
