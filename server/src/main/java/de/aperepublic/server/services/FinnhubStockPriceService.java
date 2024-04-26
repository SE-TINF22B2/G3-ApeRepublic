package de.aperepublic.server.services;

import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;

@Service
public class FinnhubStockPriceService {
    private static final String WEBSOCKET_URI = "wss://ws.finnhub.io?token=cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g";

    public void connectWebSocket(String symbol) {
        WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        stompClient.setMessageConverter(new StringMessageConverter());
        stompClient.connect(WEBSOCKET_URI, new StompSessionHandlerAdapter() {
            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                session.send(WEBSOCKET_URI, "{\"type\":\"subscribe\", \"symbol\": \"" + symbol + "\"}");
            }

            @Override
            public Type getPayloadType(StompHeaders headers) {
                return String.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                // Handle incoming message
                String message = (String) payload;
                System.out.println("Received message: " + message);
                // Process the message as needed
            }
        });

    }
    
}
