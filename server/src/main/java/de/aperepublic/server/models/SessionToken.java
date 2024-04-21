package de.aperepublic.server.models;

import java.util.Date;
import java.util.UUID;

public class SessionToken {

    private UUID tokenId;
    private String username;

    public SessionToken(UUID token, String username) {
        this.tokenId = token;
        this.username = username;
    }

    public UUID getTokenId() {
        return tokenId;
    }

    public void setTokenId(UUID tokenId) {
        this.tokenId = tokenId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
