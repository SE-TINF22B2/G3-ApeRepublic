package de.aperepublic.server.models;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WebSocketClientConnection {

    void connectTo(String uri, String symbol) {

        URI uriConverted;
        try {
            uriConverted = new URI(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        WebSocketClient client = new WebSocketClient(uriConverted) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                System.out.println("ZE BLUTU DEVISE CONNECTEDA SECCESFULI");
                send("{\"type\":\"subscribe\", \"symbol\": \"" + symbol + "\"}");
            }

            @Override
            public void onMessage(String message) {
                System.out.println("GOT: " + message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("Connection to WebSocket closed");
            }

            @Override
            public void onError(Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        };
        client.connect();
    }
}
