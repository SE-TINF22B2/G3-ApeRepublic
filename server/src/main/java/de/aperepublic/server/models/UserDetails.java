package de.aperepublic.server.models;

import de.aperepublic.server.Entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public static UserDetails build(User user) {
        return new UserDetails(user.username, user.firstname, user.lastname, user.email, user.birthday);
    }

    public static UserDetails buildEmpty() {
        return new UserDetails("", "", "", "", null);
    }

}
