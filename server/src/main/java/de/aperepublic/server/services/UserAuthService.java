package de.aperepublic.server.services;

import de.aperepublic.server.models.requests.UserLogRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.models.response.ResponseStatus;
import de.aperepublic.server.models.response.UserAuthResponse;
import de.aperepublic.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserAuthService {

    @Autowired
    private ActiveUserService activeUserService;

    //@Autowired
    //private UserRepository userRepository;

    public ResponseEntity<String> processRegisterUser(UserRegisterRequest userRegisterRequest) {
        // TODO: Possible SQL Injection???
        if(userRegisterRequest.anyNullValue()) {
            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.MISSING_PARAMS).build());
        }
//        if(userRepository.existsByUsername(userRegisterRequest.username)) {
//            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.USERNAME_TAKEN).build());
//        }
//        if(userRepository.existsByEmail(userRegisterRequest.email)) {
//            return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.EMAIL_TAKEN).build());
//        }
        // TODO: Register User Logic
        // TODO: Create SessionToken
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.SUCCESSFUL_REGISTER).addSessionToken(5L).build());
    }

    public ResponseEntity<String> processLoginUser(UserLogRequest userLogRequest) {
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.ERROR).build());
    }

    public ResponseEntity<String> processLogoutUser(UserLogRequest userLogRequest) {
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.ERROR).build());
    }

    public ResponseEntity<String> processDeleteUser(UserLogRequest userLogRequest) {
        return ResponseEntity.ok(new UserAuthResponse(ResponseStatus.ERROR).build());
    }

}
