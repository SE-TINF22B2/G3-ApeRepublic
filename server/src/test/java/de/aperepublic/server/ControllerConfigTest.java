package de.aperepublic.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ControllerConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBadRequestOnUserRegisterWithMissingBirthday() throws Exception {
        // TODO: Fix error coming from sending request with not all params -> spring boot
        String requestBody = "{" +
                "\"username\":\"codayoda\"," +
                "\"email\":\"codayoda@gmail.com\"," +
                "\"password\":\"123\"," +
                "\"firstname\":\"coda\"," +
                "\"lastname\":\"yoda\"," +
                //"\"birthday\":\"\"" +
                "}";
        mockMvc.perform(post("/api/user/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUnregisteredUserRegistration() throws Exception {
        // TODO: Find out how to test dynamic response body
        String requestBody = "{" +
                "\"username\":\"codayoda\"," +
                "\"email\":\"codayoda@gmail.com\"," +
                "\"password\":\"123\"," +
                "\"firstname\":\"coda\"," +
                "\"lastname\":\"yoda\"," +
                "\"birthday\":\"2004-04-19\"" +
                "}";
        mockMvc.perform(post("/api/user/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

}
