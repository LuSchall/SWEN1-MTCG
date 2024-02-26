package at.technikum.apps.mtcg.entityJson;

import at.technikum.apps.mtcg.entity.Card;
import com.fasterxml.jackson.annotation.JsonProperty;

public class outCardJson {
    @JsonProperty("Id")
    private String c_Id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Damage")
    private int damage;

    @JsonProperty("Description")
    private String description;


    public String getC_Id() {
        return c_Id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setC_Id(String c_Id) {
        this.c_Id = c_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Card toCard() {
        return new Card(c_Id, name, damage);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
