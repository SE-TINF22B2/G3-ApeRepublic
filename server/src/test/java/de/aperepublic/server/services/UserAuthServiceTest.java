package de.aperepublic.server.services;

import de.aperepublic.server.Entity.User;
import de.aperepublic.server.ServerApplication;
import de.aperepublic.server.models.requests.TokenRequest;
import de.aperepublic.server.models.requests.UserLoginRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = ServerApplication.class)
@ExtendWith(MockitoExtension.class)
public class UserAuthServiceTest {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private ActiveUserService activeUserService;

    private static User registeredUser;

    private static User unregisteredUser;

    @BeforeAll
    public static void setupMockUsers() {
        registeredUser = new User();
        registeredUser.username = "enexhd";
        registeredUser.email = ("enexhd@gmail.com");
        registeredUser.firstname = ("Marc");
        registeredUser.lastname = ("Schillinger");
        registeredUser.password = ("123");
        registeredUser.birthday = new Date(2001, 9, 11);

        unregisteredUser = new User();
        unregisteredUser.username = "haupti";
        unregisteredUser.email = ("POLIZFI@gmail.com");
        unregisteredUser.firstname = ("Hauptanzeigen");
        unregisteredUser.lastname = ("Meister");
        unregisteredUser.password = ("123");
        unregisteredUser.birthday = new Date(2001, 9, 11);
    }

    @BeforeEach
    public void setupUserRepositoryService() {
//        //register
//        Mockito.lenient().when(mockUserRepository.existsByUsername(any(String.class)))
//                .thenAnswer(invocation -> {
//                    return ((String) invocation.getArgument(0)).contentEquals(registeredUser.username);
//                });
//        Mockito.lenient().when(mockUserRepository.existsByEmail(any(String.class)))
//                .thenAnswer(invocation -> ((String) invocation.getArgument(0)).contentEquals(registeredUser.email));
//        //login
//        Mockito.lenient().when(mockUserRepository.findByEmail(any(String.class)))
//                .thenAnswer(invocation -> {
//                    String email = invocation.getArgument(0);
//                    if(email.contentEquals(registeredUser.email)) {
//                        return Optional.of(registeredUser);
//                    } else {
//                        return Optional.empty();
//                    }
//                });
//        Mockito.lenient().when(mockUserRepository.findByEmail(any(String.class)))
//                .thenAnswer(invocation -> {
//                    String email = invocation.getArgument(0);
//                    if(email.contentEquals(registeredUser.email)) {
//                        return Optional.of(UserDetails.build(registeredUser));
//                    } else {
//                        return Optional.empty();
//                    }
//                });
    }

    @Test
    public void testRegisteringNewUser() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(unregisteredUser.username, unregisteredUser.email, unregisteredUser.password, unregisteredUser.firstname, unregisteredUser.lastname, unregisteredUser.birthday.toString());

        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "success");
    }

    @Test
    public void testRegisteringRegisteredUser() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(registeredUser.username, registeredUser.email, registeredUser.password, registeredUser.firstname, registeredUser.lastname, registeredUser.birthday.toString());

        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "error");
    }

    @Test
    public void testIfTokenIsStoredAfterRegister() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(unregisteredUser.username, unregisteredUser.email, unregisteredUser.password, unregisteredUser.firstname, unregisteredUser.lastname, unregisteredUser.birthday.toString());
        ResponseEntity<String> res = userAuthService.processRegisterUser(userRegisterRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "success");
        assertTrue(resBody.has("sessionTokenId"));
        assertTrue(activeUserService.containsToken(UUID.fromString(resBody.getString("sessionTokenId"))));
    }

    @Test
    public void testLoggingInUnregisteredUser() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(unregisteredUser.email, unregisteredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "error");
    }

    @Test
    public void testLoggingInRegisteredUser() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(registeredUser.email, registeredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "success");
    }

    @Test
    public void testGettingUserDetailsOnLoggingInRegisteredUser() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(registeredUser.email, registeredUser.password);

        ResponseEntity<String> res = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "success");
        assertTrue(resBody.has("userDetails"));
        assertEquals("enexhd@gmail.com", resBody.getJSONObject("userDetails").getString("email"));
    }

    @Test
    public void testLoggingOutWithCorrectToken() {
        // Login to get SessionTokenId
        UserLoginRequest userLoginRequest = new UserLoginRequest(registeredUser.email, registeredUser.password);

        ResponseEntity<String> loginRes = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, loginRes.getStatusCode());
        JSONObject loginResBody = new JSONObject(loginRes.getBody());
        expectStatus(loginResBody, "success");

        String sessionTokenId = loginResBody.getString("sessionTokenId");

        // Logout with SessionTokenId
        TokenRequest userLogoutRequest = new TokenRequest(sessionTokenId);

        ResponseEntity<String> logoutRes = userAuthService.processLogoutUser(userLogoutRequest);

        assertEquals(HttpStatus.OK, logoutRes.getStatusCode());
        JSONObject logoutResBody = new JSONObject(logoutRes.getBody());
        expectStatus(logoutResBody, "success");
    }

    @Test
    public void testLoggingOutWithWrongToken() {
        TokenRequest userLogoutRequest = new TokenRequest("0");

        ResponseEntity<String> res = userAuthService.processLogoutUser(userLogoutRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "error");
    }

    @Test
    public void testValidateCorrectToken() {
        // Login to get SessionTokenId
        UserLoginRequest userLoginRequest = new UserLoginRequest(registeredUser.email, registeredUser.password);

        ResponseEntity<String> loginRes = userAuthService.processLoginUser(userLoginRequest);

        assertEquals(HttpStatus.OK, loginRes.getStatusCode());
        JSONObject loginResBody = new JSONObject(loginRes.getBody());
        expectStatus(loginResBody, "success");

        String sessionTokenId = loginResBody.getString("sessionTokenId");

        System.out.println("TokenTokenTokenTokenTokenTokenTokenTokenTokenTokenTokenTokenTokenTokenTokenToken:" + sessionTokenId);
        // Logout with SessionTokenId
        TokenRequest tokenRequest = new TokenRequest(sessionTokenId);

        ResponseEntity<String> logoutRes = userAuthService.processValidateToken(tokenRequest);

        assertEquals(HttpStatus.OK, logoutRes.getStatusCode());
        JSONObject logoutResBody = new JSONObject(logoutRes.getBody());
        expectStatus(logoutResBody, "success");
    }

    @Test
    public void testValidateWrongToken() {
        TokenRequest tokenRequest = new TokenRequest("0");

        ResponseEntity<String> res = userAuthService.processValidateToken(tokenRequest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        JSONObject resBody = new JSONObject(res.getBody());
        expectStatus(resBody, "error");
    }

    private void expectStatus(JSONObject resBody, String exprect) {
        assertTrue(resBody.has("status"));
        assertTrue(resBody.getString("status").contentEquals(exprect));
    }

}
