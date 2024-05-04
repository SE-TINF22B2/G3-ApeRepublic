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

    public UUID createToken(String email) {
        if(containsUserByEmail(email)) {
            removeTokenByEmail(email);
        }
        SessionToken sessionToken = new SessionToken(UUID.randomUUID(), email);
        sessionTokens.add(sessionToken);
        return sessionToken.getSessionTokenId();
    }

    public UUID updateToken(String email) {
        return createToken(email);
    }

    public boolean verify(String stringToken) {
        try {
            UUID token = UUID.fromString(stringToken);
            return containsToken(token);
        } catch(IllegalArgumentException e) {
            return false;
        }
    }

    public boolean removeTokenByEmail(String email) {
        return sessionTokens.removeIf(token -> token.getEmail().contentEquals(email));
    }

    public boolean removeIfTokenMatch(String tokenId) {
        return sessionTokens.removeIf(token -> token.getSessionTokenId().toString().contentEquals(tokenId));
    }

    public boolean containsToken(UUID tokenId) {
        return sessionTokens.stream().anyMatch(token -> token.getSessionTokenId().equals(tokenId));
    }

    public boolean containsUserByEmail(String email) {
        return sessionTokens.stream().anyMatch(token -> token.getEmail().contentEquals(email));
    }


}
