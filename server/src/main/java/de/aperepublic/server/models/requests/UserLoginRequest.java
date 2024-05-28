package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserLoginRequest {

    @JsonProperty("email")
    public String email;

    @JsonProperty("password")
    public String password;

}
