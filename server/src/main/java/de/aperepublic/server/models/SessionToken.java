package de.aperepublic.server.models;

import java.util.Date;
import java.util.UUID;

public class SessionToken {

    private UUID tokenId;
    private Date expireDate;

    public SessionToken(UUID token, Date expireDate) {
        this.tokenId = token;
        this.expireDate = expireDate;
    }

    public UUID getTokenId() {
        return tokenId;
    }

    public void setTokenId(UUID tokenId) {
        this.tokenId = tokenId;
    }

    public Date getCreated() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
