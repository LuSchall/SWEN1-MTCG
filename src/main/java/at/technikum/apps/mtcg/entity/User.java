package at.technikum.apps.mtcg.entity;

import at.technikum.apps.mtcg.entityJson.UserProfileJson;

public class User {
    private String username;
    private String password;
    private int elo;
    private int coins;
    private String profileName;
    private String bio;
    private String image;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.coins = 0;
        this.elo = 0;
        this.profileName = null;
        this.bio = null;
        this.image = null;
    }

    public User(String username, String password, int elo, int coins, String profileName, String bio, String image) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.elo = elo;
        this.profileName = profileName;
        this.bio = bio;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCoins() {
        return coins;
    }

    public int getElo() {
        return elo;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }

    public UserProfileJson getUserProfileJson() {
        UserProfileJson profileJson = new UserProfileJson();
        profileJson.setName(profileName);
        profileJson.setBio(bio);
        profileJson.setImage(image);
        return profileJson;
    }
}
