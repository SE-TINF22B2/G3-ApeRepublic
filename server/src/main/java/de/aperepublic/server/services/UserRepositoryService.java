package de.aperepublic.server.services;

import de.aperepublic.server.models.User;
import de.aperepublic.server.models.UserDetails;
import de.aperepublic.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public Optional<UserDetails> findUserDetailsByEmail(String email) {
        Optional<User> optUser = findUserByEmail(email);
        return Optional.of(UserDetails.build(optUser.orElse(new User())));
    }
}
