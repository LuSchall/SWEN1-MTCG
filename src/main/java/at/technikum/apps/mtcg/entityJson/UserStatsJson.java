package at.technikum.apps.mtcg.entityJson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserStatsJson {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Elo")
    private int elo;

    @JsonProperty("Wins")
    private int wins;
    @JsonProperty("Losses")
    private int losses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
