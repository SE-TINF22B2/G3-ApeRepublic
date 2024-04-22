package de.aperepublic.server.models;

import java.util.UUID;

public class SessionToken {

    private UUID tokenId;
    private String email;

    public SessionToken(UUID token, String email) {
        this.tokenId = token;
        this.email = email;
    }

    public UUID getTokenId() {
        return tokenId;
    }

    public void setTokenId(UUID tokenId) {
        this.tokenId = tokenId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
