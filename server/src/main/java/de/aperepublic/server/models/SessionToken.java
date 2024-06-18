package de.aperepublic.server.models;

import java.util.UUID;

public class SessionToken {

    private UUID sessionTokenId;
    private String email;

    public SessionToken(UUID token, String email) {
        this.sessionTokenId = token;
        this.email = email;
    }

    public UUID getSessionTokenId() {
        return sessionTokenId;
    }

    public void setSessionTokenId(UUID sessionTokenId) {
        this.sessionTokenId = sessionTokenId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
