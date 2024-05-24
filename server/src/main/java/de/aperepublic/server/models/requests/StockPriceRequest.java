package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockPriceRequest {

    @JsonProperty("token")
    public String token;

    @JsonProperty("isin")
    public String isin;

    @JsonProperty("period") // "n" = now, "d" = day, "w" = week, "m" = month, "y" = year
    public String period;

}
