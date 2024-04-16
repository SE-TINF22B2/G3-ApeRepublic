package de.aperepublic.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NutzerController {

    @PostMapping("/nutzer/daten")
    public Map<String, Object> bedieneAnmeldung(@RequestBody String username) {
        return Map.of("anfrageStatus", 0, "username", username, "email", "schwarzwaelder@kirchstorte.de");
    }

    @PostMapping("/nutzer/anmelden")
    public Map<String, Object> bedieneAnmeldung(@RequestBody String username, @RequestBody String password) {
        return Map.of("anfrageStatus", 0, "anmeldeStatus", true);
    }

    @PostMapping("/nutzer/registrieren")
    public Map<String, Object> bedieneAnmeldung(@RequestBody String username, @RequestBody String email, @RequestBody String password) {
        return Map.of("anfrageStatus", 0, "registrierStatus", true);
    }

    @PostMapping("/nutzer/position")
    public Map<String, Object> bedieneNutzerPosition(@RequestBody String user, @RequestBody String symbol) {
        return Map.of("anfrageStatus", 0, "symbol", symbol, "menge", 10, "preis", 135.84);
    }

}