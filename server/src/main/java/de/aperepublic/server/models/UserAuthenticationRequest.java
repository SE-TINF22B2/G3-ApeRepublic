package de.aperepublic.server.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAuthenticationRequest {

    @JsonProperty("token")
    private String token;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    public UserAuthenticationRequest() {

    }

    public UserAuthenticationRequest(String token, String username, String password, String email) {
        this.token = token;
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
