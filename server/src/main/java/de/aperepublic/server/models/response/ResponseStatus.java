package de.aperepublic.server.models.response;

public enum ResponseStatus {

    // register
    SUCCESSFUL_REGISTER("success", "Registration successful!"), USERNAME_TAKEN("error", "Username taken!"), EMAIL_TAKEN("error", "Email is already registered!"),
    // login
    SUCCESSFUL_LOGIN("success", "Login successful!"), UNSUCCESSFUL_LOGIN("error", "Invalid email or password!"),
    // logout
    SUCCESSFUL_LOGOUT("success", "Logout successful!"), UNSUCCESSFUL_LOGOUT("error", "Invalid logout parameter!"),
    // token
    INVALID_TOKEN("error", "The provided token is invalid!"), SUCCESSFUL_VALIDATION("success", "The token is valid"),
    // stock
    INVALID_SYMBOL("error", "The provided symbol is not registered!"), SUCCESSFUL_PRICE_REQUEST("success", "PriceRequest successful!"),
    // else
    VALID_REQUEST("success", "Request was processed!"), ERROR("error", "An error occurred handling your request!"), MISSING_PARAMS("error", "One or more parameter are missing!");

    String statusText = "error";
    String message = "No message";

    ResponseStatus(String statusText, String message) {
        this.statusText = statusText;
        this.message = message;
    }

    String getStatusText() {
        return statusText;
    }

    String getMessage() {
        return message;
    }

}
