package at.technikum.apps.mtcg.entityJson;

import com.fasterxml.jackson.annotation.JsonProperty;
public class UserJson {
    @JsonProperty("Username")
    private String username;

    @JsonProperty("Password")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
