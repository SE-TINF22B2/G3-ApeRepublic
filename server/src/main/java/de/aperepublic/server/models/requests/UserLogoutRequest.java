package de.aperepublic.server.models.requests;

public class UserLogoutRequest {

    public String token;

    public UserLogoutRequest(String token) {
        this.token = token;
    }

}
