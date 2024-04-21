package de.aperepublic.server.models.response;

import com.google.gson.Gson;

import java.util.Map;

public class UserAuthResponse {

    private ResponseStatus responseStatus;
    private Map<String, Object> arguments;

    public UserAuthResponse() {
        arguments = Map.of();
    }

    public UserAuthResponse(ResponseStatus responseStatus) {
        this();
        this.responseStatus = responseStatus;
    }

    public UserAuthResponse addSessionToken(long sessionToken) {
        arguments.put("sessionToken", sessionToken);
        return this;
    }

    public UserAuthResponse addArgument(String argKey, Object argValue) {
        arguments.put(argKey, argValue);
        return this;
    }

    public String build() {
        arguments.put("message", responseStatus.message);
        return new Gson().toJson(Map.of(responseStatus.statusText, arguments));
    }

}
