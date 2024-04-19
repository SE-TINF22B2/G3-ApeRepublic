package de.aperepublic.server.services;

import de.aperepublic.server.models.SessionToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ActiveUserService {

    private List<SessionToken> sessionTokens;
    private long lifetime;

    public ActiveUserService(@Value("${sessionToken.lifetime}") long lifetime) {
        sessionTokens = List.of();
        this.lifetime = lifetime;
    }

    public UUID createToken() {
        SessionToken sessionToken = new SessionToken(UUID.randomUUID(), createdDate());
        sessionTokens.add(sessionToken);
        return sessionToken.getTokenId();
    }

    public boolean containsToken(UUID tokenId) {
        return 1 <= sessionTokens.stream().filter(token -> token.getTokenId().equals(tokenId)).count();
    }

    public void refreshSessionTokenExpireDate(String token) {

    }

    public void refreshSessionTokens() {
        sessionTokens = sessionTokens.stream().filter(token -> token.getCreated().getTime() < System.currentTimeMillis() - lifetime).toList();
    }

    public void setLifetime(long lifetime) {
        this.lifetime = lifetime;
        refreshSessionTokens();
    }

    public long getLifetime() {
        return lifetime;
    }

    private Date createdDate() {
        return new Date(System.currentTimeMillis());
    }

}
