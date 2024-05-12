package de.aperepublic.server.services;

import de.aperepublic.server.models.CompanyProfile2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinnhubCompanyProfile2ServiceTest {

    private FinnhubCompanyProfile2Service finnhubCompanyProfile2Service;

    @BeforeAll
    void setup() {
        finnhubCompanyProfile2Service = new FinnhubCompanyProfile2Service();
    }

    @Test
    void getCompanyFromIsin() {
        CompanyProfile2 result = finnhubCompanyProfile2Service.getCompanyFromIsin("US0378331005");
        assertEquals("Apple Inc", result.getName());
        assertEquals("https://www.apple.com/", result.getWeburl());
    }

    @Test
    void getCompanyFromSymbol() {
        CompanyProfile2 result = finnhubCompanyProfile2Service.getCompanyFromSymbol("AAPL");
        assertEquals("Apple Inc", result.getName());
        assertEquals("https://www.apple.com/", result.getWeburl());
    }
}