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

    public ActiveUserService() {
        sessionTokens = List.of();
    }

    public UUID createToken(String username) {
        SessionToken sessionToken = new SessionToken(UUID.randomUUID(), username);
        sessionTokens.add(sessionToken);
        return sessionToken.getTokenId();
    }

    public boolean containsToken(UUID tokenId) {
        return 1 <= sessionTokens.stream().filter(token -> token.getTokenId().equals(tokenId)).count();
    }

    public boolean containsUser(String username) {
        return 1 <= sessionTokens.stream().filter(token -> token.getUsername().contentEquals(username)).count();
    }


}
