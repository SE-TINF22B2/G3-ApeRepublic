package de.aperepublic.server.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    @JsonProperty("email")
    public String email;

    @JsonProperty("password")
    public String password;


    public UserLoginRequest(String email, String password, String action) {
        this.email = email;
        this.password = password;
    }

    public boolean isValid() {
        // TODO: Is Valid Logic
        return true;
    }

}
