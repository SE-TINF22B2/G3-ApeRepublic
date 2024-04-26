package de.aperepublic.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Configuration
public class WebSocketConfig {

    @Bean
    public WebSocketStompClient stompClient() {
        WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        // Configure any additional options if needed
        return stompClient;
    }

    @Bean
    public StompSessionHandler sessionHandler() {
        return new MyStompSessionHandler();
    }
}

