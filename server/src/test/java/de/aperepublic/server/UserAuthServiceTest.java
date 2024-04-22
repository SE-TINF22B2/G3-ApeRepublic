package de.aperepublic.server;

import de.aperepublic.server.models.User;
import de.aperepublic.server.models.requests.UserLogRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.repositories.UserRepository;
import de.aperepublic.server.services.ActiveUserService;
import de.aperepublic.server.services.UserAuthService;
import de.aperepublic.server.services.UserRepositoryService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class UserAuthServiceTest {

    @Mock
    private UserRepositoryService mockUserRepositoryService;

    @InjectMocks
    private UserAuthService userAuthService;

    @Spy
    private ActiveUserService activeUserService;

    private static User registeredUser;

    private static User unregisteredUser;

    @BeforeAll
    public static void setupMockUsers() {
        registeredUser = new User.UserBuilder(0L)
                .setUsername("enexhd")
                .setEmail("enexhd@gmail.com")
                .setFirstname("Marc")
                .setLastname("Schillinger")
                .setPassword("123")
                .setBirthday("2002-08-07")
                .build();
        unregisteredUser = new User.UserBuilder(1L)
                .setUsername("haupti")
                .setEmail("POLIZFI@gmail.com")
                .setFirstname("Hauptanzeigen")
                .setLastname("Meister")
                .setPassword("321")
                .setBirthday("2000-12-12")
                .build();
    }

    @BeforeEach
    public void setupUserRepositoryService() {
        //register
        Mockito.lenient().when(mockUserRepositoryService.existsByUsername(any(String.class)))
                .thenAnswer(invocation -> ((String) invocation.getArgument(0)).contentEquals(registeredUser.username));
        Mockito.lenient().when(mockUserRepositoryService.existsByEmail(any(String.class)))
                .thenAnswer(invocation -> ((String) invocation.getArgument(0)).contentEquals(registeredUser.email));
        //login
        Mockito.lenient().when(mockUserRepositoryService.findByEmail(any(String.class)))
                .thenAnswer(invocation -> {
                    String email = invocation.getArgument(0);
                    if(email.contentEquals(registeredUser.email)) {
                        return registeredUser;
                    } else {
                        return Optional.empty();
                    }
                });
    }

    @Test
    public void testRegisteringNewUser() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(unregisteredUser.username, unregisteredUser.email, unregisteredUser.password, unregisteredUser.firstname, unregisteredUser.lastname, unregisteredUser.birthday);

        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("success"));
    }

    @Test
    public void testRegisteringRegisteredUser() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(registeredUser.username, registeredUser.email, registeredUser.password, registeredUser.firstname, registeredUser.lastname, registeredUser.birthday);

        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("error"));
    }

    @Test
    public void testIfTokenIsStoredAfterRegister() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(unregisteredUser.username, unregisteredUser.email, unregisteredUser.password, unregisteredUser.firstname, unregisteredUser.lastname, unregisteredUser.birthday);
        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("success"));
        JSONObject messageBody = resBody.getJSONObject("success");
        assertTrue(messageBody.has("sessionToken"));
        assertTrue(activeUserService.containsToken(UUID.fromString(messageBody.getString("sessionToken"))));
    }

    @Test
    public void testLoggingInNewUser() {
        UserLogRequest userLogRequest = new UserLogRequest(unregisteredUser.username, unregisteredUser.email, unregisteredUser.password, unregisteredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLogRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("error"));
    }

    @Test
    public void testLoggingInRegisteredUser() {
        UserLogRequest userLogRequest = new UserLogRequest(registeredUser.username, registeredUser.email, registeredUser.password, registeredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLogRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("success"));
    }

}
