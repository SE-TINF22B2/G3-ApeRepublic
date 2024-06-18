package de.aperepublic.server.Entity;

import de.aperepublic.server.models.requests.UserRegisterRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "User")
@Data
public class Users {
        public static final String COLUMN_IDUSER= "idUser";
        public static final String COLUMN_BIRTHDAY= "birthday";
        public static final String COLUMN_FIRSTNAME = "firstName";
        public static final String COLUMN_LASTNAME = "lastName";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";

        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column(name = COLUMN_IDUSER, nullable = false , unique = true)
        public Integer userID;

        @Column(name = COLUMN_USERNAME, nullable = false, length = 32)
        public String username;

        @Column(name = COLUMN_FIRSTNAME, nullable = false, length = 32)
        public String firstname;

        @Column(name = COLUMN_LASTNAME, nullable = false, length = 32)
        public String lastname;

        @Column(name = COLUMN_EMAIL, nullable = false, length = 32)
        public String email;

        @Column(name = COLUMN_PASSWORD, nullable = false, length = 32)
        public String password;

        @Column(name = COLUMN_BIRTHDAY, nullable = false)
        public Date birthday;

        public static Users buildFromRegisterRequest(UserRegisterRequest request) {
                Users newUser = new Users();
                newUser.userID = 1;
                newUser.username = request.username;
                newUser.email = request.email;
                newUser.password = request.password;
                newUser.firstname = request.firstname;
                newUser.lastname = request.lastname;
                newUser.birthday = Date.valueOf(request.birthday);
                return newUser;
        }

    }
