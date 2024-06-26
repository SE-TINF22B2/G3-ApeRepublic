package de.aperepublic.server.controller;

import de.aperepublic.server.models.requests.TokenRequest;
import de.aperepublic.server.models.requests.UserLoginRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user/auth")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/register")
    public ResponseEntity<String> serveRegisterRequest(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userAuthService.processRegisterUser(userRegisterRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<String> serveLoginRequest(@RequestBody UserLoginRequest userLoginRequest) {
        return userAuthService.processLoginUser(userLoginRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> serviceLogoutRequest(@RequestBody TokenRequest tokenRequest) {
        return userAuthService.processLogoutUser(tokenRequest);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> serviceTokenValidationRequest(@RequestBody TokenRequest tokenRequest) {
        return userAuthService.processValidateToken(tokenRequest);
    }

}