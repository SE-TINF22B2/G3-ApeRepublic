package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLogRequest {

    @JsonProperty("username")
    public String username;

    @JsonProperty("email")
    public String email;

    @JsonProperty("password")
    public String password;


    public UserLogRequest(String username, String email, String password, String action) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean isValid() {
        // TODO: Is Valid Logic
        return true;
    }

}
