package de.aperepublic.server.models.response;

import com.google.gson.Gson;
import de.aperepublic.server.models.UserDetails;
import org.json.JSONObject;

public class APIResponse {

    private ResponseStatus responseStatus;
    private JSONObject arguments;

    public APIResponse(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
        arguments = new JSONObject();
    }

    public APIResponse setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
        return this;
    }

    public APIResponse addSessionTokenId(String sessionTokenId) {
        arguments.put("sessionTokenId", sessionTokenId);
        return this;
    }

    public APIResponse addUserDetails(UserDetails userDetails) {
        arguments.put("userDetails", new JSONObject(new Gson().toJson(userDetails)));
        return this;
    }

    public APIResponse addArgument(String argKey, Object argValue) {
        arguments.put(argKey, argValue);
        return this;
    }

    public String build() {
        arguments.put("message", responseStatus.message);
        return new JSONObject().put(responseStatus.statusText, arguments).toString();
    }

    public static APIResponse instance(ResponseStatus responseStatus) {
        return new APIResponse(responseStatus);
    }

}
