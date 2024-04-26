package de.aperepublic.server;

import de.aperepublic.server.models.response.ResponseStatus;
import de.aperepublic.server.models.response.UserAuthResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthResponseServiceTest {

    @Test
    public void testIfBuildThrowsException() {
        UserAuthResponse res = new UserAuthResponse(ResponseStatus.ERROR);
        assertDoesNotThrow( () -> {
            res.build();
        });
    }

}
