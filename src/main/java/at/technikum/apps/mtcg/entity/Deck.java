package at.technikum.apps.mtcg.entity;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final String owner;
    private final String pCardId1;
    private final String pCardId2;
    private final String pCardId3;
    private final String pCardId4;

    public Deck(String owner, String pCardId1, String pCardId2, String pCardId3, String pCardId4) {
        this.owner = owner;
        this.pCardId1 = pCardId1;
        this.pCardId2 = pCardId2;
        this.pCardId3 = pCardId3;
        this.pCardId4 = pCardId4;
    }

    public String getIdOfCard(int cardNumber) {
        return switch (cardNumber) {
            case 1 -> pCardId1;
            case 2 -> pCardId2;
            case 3 -> pCardId3;
            case 4 -> pCardId4;
            default -> throw new IndexOutOfBoundsException("getIdOfCard(Deck) IOOB");
        };
    }

    public String getOwner() {
        return owner;
    }
    public List<String> asListOfCardIds(){
        List<String> cardIds = new ArrayList<>();
        cardIds.add(pCardId1);
        cardIds.add(pCardId2);
        cardIds.add(pCardId3);
        cardIds.add(pCardId4);
        return cardIds;
    }
}
