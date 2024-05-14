package de.aperepublic.server.models;

import de.aperepublic.server.models.response.PriceEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FinnhubWebSocketTest {

    public FinnhubWebSocket webSocket = new FinnhubWebSocket(URI.create("ws.finnhub.io?token=cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g"));

    @BeforeEach
    void setUp() {
        URI uri = null;
        try {
            uri = new URI("ws.finnhub.io?token=cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        webSocket = new FinnhubWebSocket(uri);
        webSocket.connect();
    }

    @Test
    void testConnectedToFinnhub() throws InterruptedException {
//        webSocket.subscribeToStock("AAPL");
        assertEquals("ws.finnhub.io?token=cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g", webSocket.getRemoteSocketAddress());
    }

    @Test
    void testConvertJsonToEntry() {
        String jsonMessage = "{\"data\":[{\"c\":[\"1\",\"12\"],\"p\":182.625,\"s\":\"AAPL\",\"t\":1715105326285,\"v\":15},{\"c\":[\"1\",\"12\"],\"p\":182.6201,\"s\":\"AAPL\",\"t\":1715105326467,\"v\":20},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":3},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":4},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":2},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":3},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":2},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":1},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":2},{\"c\":[\"1\",\"8\",\"12\"],\"p\":182.63,\"s\":\"AAPL\",\"t\":1715105326699,\"v\":1}],\"type\":\"trade\"}";
        PriceEntry priceEntry = webSocket.convertJsonToEntry(jsonMessage);
        assertNotNull(priceEntry);
        assertEquals(182.625, priceEntry.price());
    }

}