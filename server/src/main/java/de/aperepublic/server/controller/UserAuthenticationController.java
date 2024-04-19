package de.aperepublic.server.controller;

import de.aperepublic.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/nutzer")
public class UserAuthenticationController {

    @PostMapping("/register")
    public ResponseEntity<?> registerUser() {//@RequestBody UserRegistrationDTO userDTO) {
        //userService.registerUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login() {//@RequestBody UserLoginDTO userDTO) {
        // Perform authentication logic
        // Return appropriate response or token
        return ResponseEntity.ok("Login successful");
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Perform logout logic
        // Invalidate token or session
        return ResponseEntity.ok("Logout successful");
    }

}