package de.aperepublic.server.controller;

import de.aperepublic.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/nutzer/details")
public class UserDetailsController {

    @PostMapping("/")
    public Map<String, Object> bedieneAnmeldung(@RequestBody String username) {
        return Map.of("anfrageStatus", 0, "username", username, "email", "schwarzwaelder@kirchstorte.de");
    }

    @PostMapping("/position")
    public Map<String, Object> bedieneNutzerPosition(@RequestBody String user, @RequestBody String symbol) {
        return Map.of("anfrageStatus", 0, "symbol", symbol, "menge", 10, "preis", 135.84);
    }

}
