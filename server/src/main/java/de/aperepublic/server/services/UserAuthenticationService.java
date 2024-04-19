package de.aperepublic.server.services;

import de.aperepublic.server.models.UserAuthenticationRequest;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationService {

    public boolean isRegistered(UserAuthenticationRequest userAuthenticationRequest) {
        return false;
    }

}
