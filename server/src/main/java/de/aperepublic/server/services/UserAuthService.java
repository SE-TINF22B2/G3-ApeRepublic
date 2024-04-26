package de.aperepublic.server.services;

import de.aperepublic.server.models.User;
import de.aperepublic.server.models.UserDetails;
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
        if(userRepositoryService.existsUserByUsername(userRegisterRequest.username)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.USERNAME_TAKEN).build());
        }
        if(userRepositoryService.existsUserByEmail(userRegisterRequest.email)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.EMAIL_TAKEN).build());
        }
        // TODO: Register DB Integration
        UUID sessionToken = activeUserService.createToken(userRegisterRequest.email);
        Optional<UserDetails> optUserDetails = userRepositoryService.findUserDetailsByEmail(userRegisterRequest.email);
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.SUCCESSFUL_REGISTER).addSessionTokenId(sessionToken.toString()).addUserDetails(optUserDetails.orElse(UserDetails.buildEmpty())).build());
    }

    public ResponseEntity<String> processLoginUser(UserLoginRequest userLoginRequest) {
        Optional<User> optRequestUser = userRepositoryService.findUserByEmail(userLoginRequest.email);
        if(optRequestUser.isEmpty()) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).build());
        }
        User requestUser = optRequestUser.get();
        if(!requestUser.password.contentEquals(userLoginRequest.password)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).build());
        }
        String sessionTokenId = activeUserService.createToken(requestUser.email).toString();
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.SUCCESSFUL_LOGIN).addSessionTokenId(sessionTokenId).addUserDetails(UserDetails.build(requestUser)).build());
    }

    public ResponseEntity<String> processLogoutUser(UserLogoutRequest userLogoutRequest) {
        if(!activeUserService.removeIfTokenMatch(userLogoutRequest.token)) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.UNSUCCESSFUL_LOGOUT).build());
        }
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.SUCCESSFUL_LOGOUT).build());
    }

    public ResponseEntity<String> processDeleteUser(UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.ERROR).build());
    }

}
