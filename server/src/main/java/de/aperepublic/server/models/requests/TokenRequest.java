package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class TokenRequest {

    @JsonProperty("token")
    public String token;

    public TokenRequest(String sessionTokenId) {
        this.token = sessionTokenId;
    }
}
