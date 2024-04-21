package de.aperepublic.server.models.response;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.Map;

public class UserAuthResponse {

    private ResponseStatus responseStatus;
    private JSONObject arguments;

    public UserAuthResponse() {
        arguments = new JSONObject();
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
        return new JSONObject().put(responseStatus.statusText, arguments).toString();
    }

}
