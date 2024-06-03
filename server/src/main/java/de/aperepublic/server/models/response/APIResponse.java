package de.aperepublic.server.models.response;

import com.google.gson.Gson;
import de.aperepublic.server.models.UserDetails;
import lombok.Getter;
import org.json.JSONObject;

import java.util.UUID;

public class APIResponse {

    @Getter
    private ResponseStatus status;
    private JSONObject attributes;

    public APIResponse() {
        status = ResponseStatus.ERROR;
        attributes = new JSONObject();
    }

    public APIResponse(ResponseStatus responseStatus) {
        this.status = responseStatus;
        attributes = new JSONObject();
    }

    public APIResponse setStatus(ResponseStatus status) {
        this.status = status;
        return this;
    }

    public APIResponse addAttribute(String key, String value) {
        attributes.put(key, value);
        return this;
    }

    public APIResponse addAttribute(String key, JSONObject value) {
        attributes.put(key, value);
        return this;
    }

    public APIResponse addSessionTokenId(UUID sessionTokenId) throws NullPointerException {
        if(sessionTokenId == null) throw new NullPointerException("Provided sessionTokenId is null!");
        return addAttribute("sessionTokenId", sessionTokenId.toString());
    }

    public APIResponse addUserDetails(UserDetails userDetails) throws NullPointerException {
        if(userDetails == null) throw new NullPointerException("Provided UserDetails is null!");
        return addAttribute("userDetails", new JSONObject(new Gson().toJson(userDetails)));
    }

    public String toString() {
        addAttribute("message", status.message).addAttribute("status", status.statusText);
        return attributes.toString();
    }

    public static APIResponse instance(ResponseStatus responseStatus) {
        return new APIResponse(responseStatus);
    }

}
