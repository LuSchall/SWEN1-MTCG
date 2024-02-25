package at.technikum.apps.mtcg.entityJson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileJson {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Bio")
    private String bio;

    @JsonProperty("Image")
    private String image;

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }
}
