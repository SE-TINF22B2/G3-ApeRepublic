package de.aperepublic.server.services;

import de.aperepublic.server.models.SessionToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        return sessionToken.getTokenId();
    }

    public UUID updateToken(String email) {
        return createToken(email);
    }

    public boolean removeTokenByEmail(String email) {
        return sessionTokens.removeIf(token -> token.getEmail().contentEquals(email));
    }

    public boolean removeIfTokenAndEmailMatch(String tokenId, String email) {
        return sessionTokens.removeIf(token -> token.getTokenId().toString().contentEquals(tokenId) && token.getEmail().contentEquals(email));
    }

    public boolean containsToken(UUID tokenId) {
        return sessionTokens.stream().anyMatch(token -> token.getTokenId().equals(tokenId));
    }

    public boolean containsUserByEmail(String email) {
        return sessionTokens.stream().anyMatch(token -> token.getEmail().contentEquals(email));
    }


}
