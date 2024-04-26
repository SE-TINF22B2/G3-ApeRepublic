package de.aperepublic.server.services;

import de.aperepublic.server.models.User;
import de.aperepublic.server.models.UserDetails;
import de.aperepublic.server.models.requests.UserLoginRequest;
import de.aperepublic.server.models.requests.UserLogoutRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

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
        Mockito.lenient().when(mockUserRepositoryService.existsUserByUsername(any(String.class)))
                .thenAnswer(invocation -> ((String) invocation.getArgument(0)).contentEquals(registeredUser.username));
        Mockito.lenient().when(mockUserRepositoryService.existsUserByEmail(any(String.class)))
                .thenAnswer(invocation -> ((String) invocation.getArgument(0)).contentEquals(registeredUser.email));
        //login
        Mockito.lenient().when(mockUserRepositoryService.findUserByEmail(any(String.class)))
                .thenAnswer(invocation -> {
                    String email = invocation.getArgument(0);
                    if(email.contentEquals(registeredUser.email)) {
                        return Optional.of(registeredUser);
                    } else {
                        return Optional.empty();
                    }
                });
        Mockito.lenient().when(mockUserRepositoryService.findUserDetailsByEmail(any(String.class)))
                .thenAnswer(invocation -> {
                    String email = invocation.getArgument(0);
                    if(email.contentEquals(registeredUser.email)) {
                        return Optional.of(UserDetails.build(registeredUser));
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
        assertTrue(messageBody.has("sessionTokenId"));
        assertTrue(activeUserService.containsToken(UUID.fromString(messageBody.getString("sessionTokenId"))));
    }

    @Test
    public void testLoggingInNewUser() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(unregisteredUser.username, unregisteredUser.email, unregisteredUser.password, unregisteredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("error"));
    }

    @Test
    public void testLoggingInRegisteredUser() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(registeredUser.username, registeredUser.email, registeredUser.password, registeredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("success"));
    }

    @Test
    public void testGettingUserDetailsOnLoggingInRegisteredUser() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(registeredUser.username, registeredUser.email, registeredUser.password, registeredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("success"));
        JSONObject messageBody = resBody.getJSONObject("success");
        assertTrue(messageBody.has("userDetails"));
        assertEquals("enexhd@gmail.com", messageBody.getJSONObject("userDetails").getString("email"));
    }

    @Test
    public void testLoggingOutWithCorrectToken() {
        // Login to get SessionTokenId
        UserLoginRequest userLoginRequest = new UserLoginRequest(registeredUser.username, registeredUser.email, registeredUser.password, registeredUser.password);

        ResponseEntity<String> loginRes = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, loginRes.getStatusCode());
        JSONObject loginResBody = new JSONObject(loginRes.getBody());
        assertTrue(loginResBody.has("success"));

        String sessionTokenId = loginResBody.getJSONObject("success").getString("sessionTokenId");

        // Logout with SessionTokenId
        UserLogoutRequest userLogoutRequest = new UserLogoutRequest(sessionTokenId);

        ResponseEntity<String> logoutRes = userAuthService.processLogoutUser(userLogoutRequest);

        assertEquals(HttpStatus.OK, logoutRes.getStatusCode());
        JSONObject logoutResBody = new JSONObject(logoutRes.getBody());
        assertTrue(logoutResBody.has("success"));
    }

    @Test
    public void testLoggingOutWithWrongToken() {
        UserLogoutRequest userLogoutRequest = new UserLogoutRequest("0");

        ResponseEntity<String> res = userAuthService.processLogoutUser(userLogoutRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        assertTrue(resBody.has("error"));
    }

}
