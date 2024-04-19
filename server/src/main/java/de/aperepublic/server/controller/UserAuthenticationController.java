package de.aperepublic.server.controller;

import de.aperepublic.server.models.UserAuthenticationRequest;
import de.aperepublic.server.services.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/auth")
public class UserAuthenticationController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserAuthenticationRequest userAuthenticationRequest) {
        if(userAuthenticationService.isRegistered(userAuthenticationRequest)) {
            return ResponseEntity.ok("User already registered!");
        }
        // TODO: Register User
        return ResponseEntity.ok("User registered successfully!");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAuthenticationRequest userAuthenticationRequest) {
        if(!userAuthenticationService.isRegistered(userAuthenticationRequest)) {
            return ResponseEntity.ok("User is not registered!");
        }
        // TODO: Login logic -> Token???
        return ResponseEntity.ok("Login successful");
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody UserAuthenticationRequest userAuthenticationRequest) {
        // Perform logout logic
        // Invalidate token or session
        return ResponseEntity.ok("Logout successful");
    }

}