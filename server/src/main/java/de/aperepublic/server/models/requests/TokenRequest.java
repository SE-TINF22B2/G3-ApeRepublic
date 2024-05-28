package de.aperepublic.server.models.requests;

public class TokenRequest {

    public String token;

    public TokenRequest(String sessionTokenId) {
        this.token = sessionTokenId;
    }
}
