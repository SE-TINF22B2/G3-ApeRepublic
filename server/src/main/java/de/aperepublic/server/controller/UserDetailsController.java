package de.aperepublic.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user/details")
public class UserDetailsController {

    @PostMapping("/description")
    public Map<String, Object> serveDescription(@RequestBody String username) {
        return Map.of("anfrageStatus", 0, "username", username, "email", "schwarzwaelder@kirchstorte.de");
    }

    @PostMapping("/position")
    public Map<String, Object> servePosition(@RequestBody String user, @RequestBody String symbol) {
        return Map.of("anfrageStatus", 0, "symbol", symbol, "menge", 10, "preis", 135.84);
    }

}
