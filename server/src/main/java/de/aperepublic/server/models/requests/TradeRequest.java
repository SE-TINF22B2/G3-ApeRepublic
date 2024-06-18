package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class TradeRequest {

    @JsonProperty("token")
    public String token;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("amount")
    public BigDecimal amount;

}
