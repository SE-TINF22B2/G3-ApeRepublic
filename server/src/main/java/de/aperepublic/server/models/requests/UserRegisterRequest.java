package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

public class UserRegisterRequest {

    @JsonProperty("username")
    public String username;

    @JsonProperty("email")
    public String email;

    @JsonProperty("password")
    public String password;

    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("lastname")
    public String lastname;

    @JsonProperty("birthday")
    public String birthday;

    public UserRegisterRequest(String username, String email, String password, String firstname, String lastname, String birthday) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public boolean isValid() {
        return username != null && email != null && password != null && firstname != null && lastname != null && birthday != null;
    }

}
