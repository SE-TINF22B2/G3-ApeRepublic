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
public class NutzerController {

    @Autowired
    private UserService userService;

    @PostMapping("/daten")
    public Map<String, Object> bedieneAnmeldung(@RequestBody String username) {
        return Map.of("anfrageStatus", 0, "username", username, "email", "schwarzwaelder@kirchstorte.de");
    }

    @PostMapping("/anmelden")
    public Map<String, Object> bedieneAnmeldung(@RequestBody String username, @RequestBody String password) {
        return Map.of("anfrageStatus", 0, "anmeldeStatus", true);
    }

    @PostMapping("/registrieren")
    public Map<String, Object> bedieneAnmeldung(@RequestBody String username, @RequestBody String email, @RequestBody String password) {
        return Map.of("anfrageStatus", 0, "registrierStatus", true);
    }

    @PostMapping("/position")
    public Map<String, Object> bedieneNutzerPosition(@RequestBody String user, @RequestBody String symbol) {
        return Map.of("anfrageStatus", 0, "symbol", symbol, "menge", 10, "preis", 135.84);
    }

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