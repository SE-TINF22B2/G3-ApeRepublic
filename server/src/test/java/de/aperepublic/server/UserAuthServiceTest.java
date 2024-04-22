package de.aperepublic.server;

import de.aperepublic.server.models.requests.UserLogRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.repositories.UserRepository;
import de.aperepublic.server.services.UserAuthService;
import de.aperepublic.server.services.UserRepositoryService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class UserAuthServiceTest {

    @Mock
    private UserRepositoryService mockUserRepositoryService;

    @InjectMocks
    private UserAuthService userAuthService;

    @BeforeEach
    public void setupUserRepositoryService() {
        //register
        Mockito.lenient().when(mockUserRepositoryService.existsByUsername(any(String.class)))
                .thenAnswer(invocation -> ((String) invocation.getArgument(0)).contentEquals("enexhd"));
        Mockito.lenient().when(mockUserRepositoryService.existsByEmail(any(String.class)))
                .thenAnswer(invocation -> ((String) invocation.getArgument(0)).contentEquals("enexhd@gmail.com"));
        //login
        Mockito.lenient().when(mockUserRepositoryService.findByEmail(any(String.class)))
                .thenAnswer(invocation -> {
                    String email = invocation.getArgument(0);
                    if(email.contentEquals("enexhd@gmail.com")) {
                        return new User();
                    }
                });
    }

    @Test
    public void testRegisteringNewUser() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("norm", "norm@gmail.com", "123", "Norm", "Miller", "2002-08-08");

        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("success"));
    }

    @Test
    public void testRegisteringRegisteredUser() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("enexhd", "enexhd@gmail.com", "123", "Marc", "Schillinger", "2002-08-07");

        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("error"));
    }

    @Test
    @Disabled
    public void testLoggingInNewUser() {
        UserLogRequest userLogRequest = new UserLogRequest("norm", "norm@gmail.de", "123", "login");

        ResponseEntity<String> res = userAuthService.processLoginUser(userLogRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("error"));
    }

    @Test
    @Disabled
    public void testLoggingInRegisteredUser() {
        UserLogRequest userLogRequest = new UserLogRequest("enexhd", "enexhd@gmail.com", "123", "login");

        ResponseEntity<String> res = userAuthService.processLoginUser(userLogRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("success"));
    }

}
