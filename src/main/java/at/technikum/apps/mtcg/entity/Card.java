package at.technikum.apps.mtcg.entity;

public class Card {
    private String c_Id;
    private String name;
    private String cardElement;
    private String cardType;
    private int damage;
    private String owner;

    public Card(String c_Id, String name, int damage, String owner, String cardElement, String cardType){
        this.c_Id = c_Id;
        this.name = name;
        this.damage = damage;
        this.owner = owner;
        this.cardElement = cardElement;
        this.cardType = cardType;
    }
    public Card(String c_Id, String name, int damage){
        this.c_Id = c_Id;
        this.name = name;
        this.damage = damage;
        this.owner = null;
    }

    public String getC_Id() {
        return c_Id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
