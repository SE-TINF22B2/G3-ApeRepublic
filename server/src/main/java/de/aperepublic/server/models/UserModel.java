package de.aperepublic.server.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User")
public class UserModel {

    @Id
    public Long userID;

    public String username;

    public String firstName;

    public String lastName;

    public String email;

    public String password;

    public Date birthday;

    public UserModel(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

}
