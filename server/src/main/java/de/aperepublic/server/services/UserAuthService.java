package de.aperepublic.server.services;

import de.aperepublic.server.models.User;
import de.aperepublic.server.models.UserDetails;
import de.aperepublic.server.models.requests.UserLoginRequest;
import de.aperepublic.server.models.requests.UserLogoutRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.models.response.ResponseStatus;
import de.aperepublic.server.models.response.APIResponse;
import de.aperepublic.server.repositories.MockUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserAuthService {

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private MockUserRepository mockUserRepository;

    public ResponseEntity<String> processRegisterUser(UserRegisterRequest userRegisterRequest) {
        // TODO: Possible SQL Injection???
        if(!userRegisterRequest.isValid()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.MISSING_PARAMS).toString());
        }
        if(mockUserRepository.existsByUsername(userRegisterRequest.username)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.USERNAME_TAKEN).toString());
        }
        if(mockUserRepository.existsByEmail(userRegisterRequest.email)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.EMAIL_TAKEN).toString());
        }
        // TODO: Register DB Integration
        UUID sessionToken = activeUserService.createToken(userRegisterRequest.email);
        UserDetails userDetails = UserDetails.build(mockUserRepository.findByEmail(userRegisterRequest.email).orElse(new User()));
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_REGISTER).addSessionTokenId(sessionToken).addUserDetails(userDetails).toString());
    }

    public ResponseEntity<String> processLoginUser(UserLoginRequest userLoginRequest) {
        Optional<User> optRequestUser = mockUserRepository.findByEmail(userLoginRequest.email);
        if(optRequestUser.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).toString());
        }
        User requestUser = optRequestUser.get();
        if(!requestUser.password.contentEquals(userLoginRequest.password)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).toString());
        }
        UUID sessionTokenId = activeUserService.createToken(requestUser.email);
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_LOGIN).addSessionTokenId(sessionTokenId).addUserDetails(UserDetails.build(requestUser)).toString());
    }

    public ResponseEntity<String> processLogoutUser(UserLogoutRequest userLogoutRequest) {
        if(!activeUserService.removeIfTokenMatch(userLogoutRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.UNSUCCESSFUL_LOGOUT).toString());
        }
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_LOGOUT).toString());
    }

    public ResponseEntity<String> processDeleteUser(UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
    }

}
