package at.technikum.apps.mtcg.entity;

public class User {


    private String username;
    private String password;
    private String coins;
    private String elo;
    private String name;
    private String bio;
    private String image;

    public User(String username, String password, String elo, String coins) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.elo = elo;
        this.name = null;
        this.bio = null;
        this.image = null;
    }

    public User(String username, String password, String coins, String elo, String name, String bio, String image) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.elo = elo;
        this.name = name;
        this.bio = bio;
        this.image = image;
    }
}
