package de.aperepublic.server.models.response;

public enum ResponseStatus {

    SUCCESSFUL_REGISTER("success", "Registration successful!"), USERNAME_TAKEN("error", "Username taken!"), EMAIL_TAKEN("error", "Email is already registered!"),
    SUCCESSFUL_LOGIN("success", "Login successful!"), UNSUCCESSFUL_LOGIN("error", "Invalid username, email or password!"),
    ERROR("error", "An error occurred handling your request!"), MISSING_PARAMS("error", "One or more parameter are missing!"),
    SUCCESSFUL_LOGOUT("success", "Logout successful!"), UNSUCCESSFUL_LOGOUT("error", "Invalid logout parameter!");

    String statusText = "error";
    String message = "No message";

    ResponseStatus(String statusText, String message) {
        this.statusText = statusText;
        this.message = message;
    }

}
