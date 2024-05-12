package de.aperepublic.server.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.aperepublic.server.models.response.PriceEntry;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;

@Slf4j
public class FinnhubWebSocket extends WebSocketClient {

    private boolean isSubscribed = false;
    private String latestSymbol;

    public FinnhubWebSocket(URI serverUri) {
        super(serverUri);
    }

    public FinnhubWebSocket(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        log.info("WebSocket opened");
    }

    @Override
    public void onMessage(String message) {
        log.info(message);
        if (message.contains("data")) {
            convertJsonToEntry(message);
            //TODO add Implementation for saving Prices
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("WebSocket closed");
    }

    @Override
    public void onError(Exception ex) {
        log.error(ex.getMessage());
    }

    public void subscribeToStock(String symbol) {
        if (isSubscribed) {
            unsubscribe(latestSymbol);
        }
        send("{\"type\":\"subscribe\", \"symbol\": \"" + symbol + "\"}");
        latestSymbol = symbol;
        isSubscribed = true;
    }

    public void unsubscribe(String symbol) {
        send("{\"type\":\"unsubscribe\", \"symbol\": \"" + symbol + "\"}");
        isSubscribed = false;
    }

    public PriceEntry convertJsonToEntry(String message) {
//        Gson gson = new GsonBuilder().setLenient().create();
        JsonObject jsonObject = new Gson().fromJson(message, JsonObject.class);

        // Get the data array
        JsonArray dataArray = jsonObject.getAsJsonArray("data");

        // Get the first element of the data array
        String priceMessage = dataArray.get(0).toString();
        try {
            ObjectMapper mapper = new ObjectMapper();
            PriceEntry priceEntry = mapper.readValue(priceMessage, PriceEntry.class);
            return priceEntry;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
