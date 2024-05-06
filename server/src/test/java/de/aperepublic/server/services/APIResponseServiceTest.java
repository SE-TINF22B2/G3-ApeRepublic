package de.aperepublic.server.services;

import de.aperepublic.server.models.response.ResponseStatus;
import de.aperepublic.server.models.response.APIResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class APIResponseServiceTest {

    @Test
    public void testIfToStringThrowsException() {
        APIResponse res = new APIResponse(ResponseStatus.ERROR);
        assertDoesNotThrow( () -> {
            res.toString();
        });
    }

}
