package de.aperepublic.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import de.aperepublic.server.models.requests.UserRegisterRequest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockPostRequest {

    public static void main(String[] args) throws Exception {
        // URL des Servers, an den der POST-Request gesendet werden soll
        String url = "http://localhost:8080/api/user/auth/register";

        // POST-Request Payload (Daten, die an den Server gesendet werden sollen)
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("codayoda", "codayoda@gmail.com", "123", "coda", "yoda", "2004-04-19");
        String requestBody = new Gson().toJson(userRegisterRequest);

        System.out.println(requestBody);

        // URL-Objekt erstellen
        URL obj = new URL(url);

        // HttpURLConnection-Objekt öffnen
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // POST-Request konfigurieren
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        // Daten an den Request Body senden
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(requestBody);
        wr.flush();
        wr.close();

        // Response-Code abrufen
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Response Body lesen
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Response ausgeben
        System.out.println("Response Body: " + response.toString());
    }
}

