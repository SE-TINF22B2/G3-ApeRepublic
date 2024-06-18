package de.aperepublic.server.models;

import com.google.gson.Gson;
import de.aperepublic.server.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @SerializedName("username")
    public String username;

    @SerializedName("firstname")
    public String firstname;

    @SerializedName("lastname")
    public String lastname;

    @SerializedName("email")
    public String email;

    @SerializedName("birthday")
    public Date birthday;

    public static UserDetails build(Users user) {
        return new UserDetails(user.username, user.firstname, user.lastname, user.email, user.birthday);
    }

    public static UserDetails buildEmpty() {
        return new UserDetails("", "", "", "", null);
    }

}
