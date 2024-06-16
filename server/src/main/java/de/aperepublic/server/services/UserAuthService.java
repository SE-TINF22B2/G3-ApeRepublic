package de.aperepublic.server.services;

import de.aperepublic.server.Entity.Users;
import de.aperepublic.server.models.UserDetails;
import de.aperepublic.server.models.requests.TokenRequest;
import de.aperepublic.server.models.requests.UserLoginRequest;
import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.models.response.ResponseStatus;
import de.aperepublic.server.models.response.APIResponse;
import de.aperepublic.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserAuthService {

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity<String> processRegisterUser(UserRegisterRequest userRegisterRequest) {
        if(!userRegisterRequest.isValid()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.MISSING_PARAMS).toString());
        }
        if(userRepository.existsByUsername(userRegisterRequest.username)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.USERNAME_TAKEN).toString());
        }
        if(userRepository.existsByEmail(userRegisterRequest.email)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.EMAIL_TAKEN).toString());
        }
        UUID sessionToken = activeUserService.createToken(userRegisterRequest.email);
        Users newUser = Users.buildFromRegisterRequest(userRegisterRequest);
        userRepository.save(newUser);
        UserDetails userDetails = UserDetails.build(userRepository.findByEmail(userRegisterRequest.email).orElse(new Users()));
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_REGISTER).addSessionTokenId(sessionToken).addUserDetails(userDetails).toString());
    }

    public ResponseEntity<String> processLoginUser(UserLoginRequest userLoginRequest) {
        Optional<Users> optRequestUser = userRepository.findByEmail(userLoginRequest.email);
        if(optRequestUser.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).toString());
        }
        de.aperepublic.server.Entity.Users requestUser = optRequestUser.get();
        if(!requestUser.password.contentEquals(userLoginRequest.password)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.UNSUCCESSFUL_LOGIN).toString());
        }
        UUID sessionTokenId = activeUserService.createToken(requestUser.email);
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_LOGIN).addSessionTokenId(sessionTokenId).addUserDetails(UserDetails.build(requestUser)).toString());
    }

    public ResponseEntity<String> processLogoutUser(TokenRequest userLogoutRequest) {
        if(!activeUserService.removeIfTokenMatch(userLogoutRequest.token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.UNSUCCESSFUL_LOGOUT).toString());
        }
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_LOGOUT).toString());
    }

    public ResponseEntity<String> processDeleteUser(UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok(new APIResponse(ResponseStatus.ERROR).toString());
    }

    public ResponseEntity<String> processValidateToken(TokenRequest tokenValidationRequest) {
        UUID token = null;
        try {
            token = UUID.fromString(tokenValidationRequest.token);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        if(!activeUserService.containsToken(token)) {
            return ResponseEntity.ok(new APIResponse(ResponseStatus.INVALID_TOKEN).toString());
        }
        return ResponseEntity.ok(new APIResponse(ResponseStatus.SUCCESSFUL_VALIDATION).toString());
    }

}
