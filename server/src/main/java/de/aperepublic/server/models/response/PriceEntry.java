package de.aperepublic.server.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceEntry(@JsonProperty("p") double price, @JsonProperty("t") String timestamp) {
}
