package at.technikum.apps.mtcg.entity;

import at.technikum.apps.mtcg.entityJson.CardJson;

import java.util.Optional;

public class Card {
    private String c_Id;
    private String name;
    private CardElement cardElement;
    private CardType cardType;
    private int damage;
    private Optional<String> owner;

    //todo delete constructor
    public Card(String c_Id, String name, int damage, String owner, CardElement cardElement, CardType cardType){
        this.c_Id = c_Id;
        this.name = name;
        this.damage = damage;
        this.owner = Optional.ofNullable(owner);
        this.cardElement = cardElement;
        this.cardType = cardType;
    }
    public Card(String c_Id, String name, int damage){
        this.c_Id = c_Id;
        this.name = name;
        this.damage = damage;
        this.owner = Optional.empty();
        this.cardType = CardType.getTypeFromName(name);
        this.cardElement = CardElement.getElementFromName(name);
    }
    public Card(String c_Id, String name, int damage, String owner){
        this.c_Id = c_Id;
        this.name = name;
        this.damage = damage;
        this.owner = Optional.ofNullable(owner);
        this.cardType = CardType.getTypeFromName(name);
        this.cardElement = CardElement.getElementFromName(name);
    }

    public CardJson toCardJson() {
        CardJson cardJ = new CardJson();
        cardJ.setC_Id(this.c_Id);
        cardJ.setName(this.name);
        cardJ.setDamage(this.damage);
        return cardJ;
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

    public Optional<String> getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = Optional.ofNullable(owner);
    }

    public CardElement getCardElement() {
        return cardElement;
    }

    public CardType getCardType() {
        return cardType;
    }
}
