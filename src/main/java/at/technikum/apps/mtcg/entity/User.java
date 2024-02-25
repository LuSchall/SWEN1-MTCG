package at.technikum.apps.mtcg.entity;

import at.technikum.apps.mtcg.entityJson.UserProfileJson;

public class User {
    private final String username;
    private final String password;
    private int elo;
    private int coins;
    private String profileName;
    private String bio;
    private String image;
    private int wins;
    private int losses;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.coins = 0;
        this.elo = 0;
        this.profileName = null;
        this.bio = null;
        this.image = null;
        this.wins = 0;
        this.losses = 0;
    }

    public User(String username, String password, int elo, int coins, String profileName, String bio, String image, int wins, int losses) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.elo = elo;
        this.profileName = profileName;
        this.bio = bio;
        this.image = image;
        this.wins = wins;
        this.losses = losses;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getElo() {
        return elo;
    }

    public int getCoins() {
        return coins;
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

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}
