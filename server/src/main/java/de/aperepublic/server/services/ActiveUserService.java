package de.aperepublic.server.services;

import de.aperepublic.server.models.SessionToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ActiveUserService {

    private final List<SessionToken> sessionTokens;

    public ActiveUserService() {
        sessionTokens = new ArrayList<>();
    }

    public UUID createToken(String username) {
        SessionToken sessionToken = new SessionToken(UUID.randomUUID(), username);
        sessionTokens.add(sessionToken);
        return sessionToken.getTokenId();
    }

    public boolean containsToken(UUID tokenId) {
        return sessionTokens.stream().anyMatch(token -> token.getTokenId().equals(tokenId));
    }

    public boolean containsUserByEmail(String email) {
        return sessionTokens.stream().anyMatch(token -> token.getEmail().contentEquals(email));
    }


}
