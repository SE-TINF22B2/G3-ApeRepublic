package de.aperepublic.server.models;

import de.aperepublic.server.models.requests.UserRegisterRequest;
import de.aperepublic.server.repositories.UserRepository;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    // TODO: Builder

    @Id
    public Long userID;

    public String username;

    public String firstname;

    public String lastname;

    public String email;

    public String password;

    public String birthday;

    public User() {

    }

    public User(UserBuilder userBuilder) {
        this.userID = userBuilder.userID;
        this.username = userBuilder.username;
        this.firstname = userBuilder.firstname;
        this.lastname = userBuilder.lastname;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.birthday = userBuilder.birthday;
    }

    public static class UserBuilder {

        private final Long userID;

        private String username;

        private String firstname;

        private String lastname;

        private String email;

        private String password;

        private String birthday;

        public UserBuilder(long userID) {
            this.userID = userID;
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    public static User buildFromRegisterRequest(UserRegisterRequest request) {
        User newUser = new User();
        newUser.userID = 1L;
        newUser.username = request.username;
        newUser.email = request.email;
        newUser.password = request.password;
        newUser.firstname = request.firstname;
        newUser.lastname = request.lastname;
        newUser.birthday = request.birthday;
        return newUser;
    }

}
