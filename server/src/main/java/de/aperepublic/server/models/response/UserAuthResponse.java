package de.aperepublic.server.models.response;

import org.json.JSONObject;

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

    public UserAuthResponse addSessionTokenId(String sessionTokenId) {
        arguments.put("sessionTokenId", sessionTokenId);
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
