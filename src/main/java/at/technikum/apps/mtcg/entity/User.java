package at.technikum.apps.mtcg.entity;

public class User {


    private final int id;
    private String username;
    private String password;
    private String points;
    private String elo;
    private String name;
    private String bio;
    private String image;

    public User(int id, String username, String password, String points, String elo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
        this.elo = elo;
        this.name = null;
        this.bio = null;
        this.image = null;
    }

    public User(int id, String username, String password, String points, String elo, String name, String bio, String image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
        this.elo = elo;
        this.name = name;
        this.bio = bio;
        this.image = image;
    }
}
