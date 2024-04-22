package de.aperepublic.server.services;

import de.aperepublic.server.models.User;
import de.aperepublic.server.models.requests.UserLoginRequest;
import de.aperepublic.server.models.requests.UserLogoutRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.models.response.ResponseStatus;
import de.aperepublic.server.models.response.UserAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserAuthService {

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private UserRepositoryService userRepositoryService;

    public ResponseEntity<String> processRegisterUser(UserRegisterRequest userRegisterRequest) {
        // TODO: Possible SQL Injection???
        if(!userRegisterRequest.isValid()) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.MISSING_PARAMS).build());
        }
        if(userRepositoryService.existsByUsername(userRegisterRequest.username)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.USERNAME_TAKEN).build());
        }
        if(userRepositoryService.existsByEmail(userRegisterRequest.email)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.EMAIL_TAKEN).build());
        }
        // TODO: Register User Logic
        UUID sessionToken = activeUserService.createToken(userRegisterRequest.email);
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.SUCCESSFUL_REGISTER).addSessionToken(sessionToken.toString()).build());
    }

    public ResponseEntity<String> processLoginUser(UserLoginRequest userLoginRequest) {
        Optional<User> optRequestUser = userRepositoryService.findByEmail(userLoginRequest.email);
        if(optRequestUser.isEmpty()) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).build());
        }
        User requestUser = optRequestUser.get();
        if(!requestUser.password.contentEquals(userLoginRequest.password)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).build());
        }
        String tokenId = activeUserService.createToken(requestUser.email).toString();
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.SUCCESSFUL_LOGIN).addSessionToken(tokenId).build());
    }

    public ResponseEntity<String> processLogoutUser(UserLogoutRequest userLogoutRequest) {
        if(!activeUserService.removeIfTokenAndEmailMatch(userLogoutRequest.token, userLogoutRequest.username)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.UNSUCCESSFUL_LOGOUT).build());
        }
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.SUCCESSFUL_LOGOUT).build());
    }

    public ResponseEntity<String> processDeleteUser(UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.ERROR).build());
    }

}
