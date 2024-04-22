package de.aperepublic.server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "User")
@AllArgsConstructor
public class User {

    // TODO: Builder

    @Id
    public Long userID;

    public String username;

    public String firstName;

    public String lastName;

    public String email;

    public String password;

    public Date birthday;

}
