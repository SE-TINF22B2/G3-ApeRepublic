package de.aperepublic.server.controller;

import de.aperepublic.server.services.FinnhubCompanyProfile2Service;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SpringBootTest
class UnternehmenControllerTest {

    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    UnternehmenController unternehmenController;

    @Mock
    FinnhubCompanyProfile2Service finnhubCompanyProfile2Service;

    @BeforeAll
    void setup() {
        unternehmenController = new UnternehmenController(finnhubCompanyProfile2Service);
    }

    @Test
    void checkBedieneUnternehmenVonSymbol() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/companySymbol")
                        .param("symbol", "AAPL")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").value("Apple Inc"));
    }

    @Test
    void checkBedieneUnternehmenVonIsin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/companyIsin")
                        .param("isin", "US0378331005")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").value("Apple Inc"));
    }

    @Test
    void checkBedieneUnternehmenVonIsinButGivenSymbol() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/companySymbol")
                        .param("isin", "AAPL")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}