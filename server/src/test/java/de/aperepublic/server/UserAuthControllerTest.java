package de.aperepublic.server;

import org.junit.jupiter.api.Disabled;
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
public class UserAuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @Disabled
//    public void testUserRegisterWithMissingBirthday() throws Exception {
//        String requestBody = "{\"username\": \"testuser\", \"email\": \"test@example.com\", \"password\": \"password123\", \"firstname\":\"Dieter\", \"lastname\":\"Insta\"}";
//        mockMvc.perform(post("/api/user/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"error\":{\"message\":\"One or more parameter are missing!\"}}"));
//    }
//
//    @Test
//    @Disabled
//    public void testUnregisteredUserRegistration() throws Exception {
//        String requestBody = "{\"username\": \"testuser\", \"email\": \"test@example.com\", \"password\": \"password123\", \"firstname\":\"Dieter\", \"lastname\":\"Insta\", \"birthday\":\"2002-08-07\"}";
//        mockMvc.perform(post("/api/user/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"success\":{\"sessionToken\":5,\"message\":\"Registration successful!\"}}"));
//    }
//
//    @Test
//    @Disabled
//    public void testUserRegisteredGettingRegistered() throws Exception {
//        String requestBody = "{\"token\": \"abc123\", \"username\": \"testuser\", \"password\": \"password123\", \"email\": \"test@example.com\"}";
//        mockMvc.perform(post("/api/user/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(content().string("User already registered!"));
//    }
//
//    @Test
//    @Disabled
//    public void testUserNotRegisteredLoggingIn() throws Exception {
//        String requestBody = "{\"token\": \"abc123\", \"username\": \"testuser\", \"password\": \"password123\", \"email\": \"test@example.com\"}";
//        mockMvc.perform(post("/api/user/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(content().string("User registered successfully!"));
//    }
//
//    @Test
//    @Disabled
//    public void testUserRegisteredLoggingIn() throws Exception {
//        String requestBody = "{\"token\": \"abc123\", \"username\": \"testuser\", \"password\": \"password123\", \"email\": \"test@example.com\"}";
//        mockMvc.perform(post("/api/user/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(content().string("User registered successfully!"));
//    }

}
