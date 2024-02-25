package at.technikum.apps.mtcg.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Package {
    private final int pId;
    private final String pCardId1;
    private final String pCardId2;
    private final String pCardId3;
    private final String pCardId4;
    private final String pCardId5;

    public Package(int pId, String pCardId1, String pCardId2, String pCardId3, String pCardId4, String pCardId5) {
        this.pId = pId;
        this.pCardId1 = pCardId1;
        this.pCardId2 = pCardId2;
        this.pCardId3 = pCardId3;
        this.pCardId4 = pCardId4;
        this.pCardId5 = pCardId5;
    }

    public String getIdOfCard(int cardNumber) {
        return switch (cardNumber) {
            case 1 -> pCardId1;
            case 2 -> pCardId2;
            case 3 -> pCardId3;
            case 4 -> pCardId4;
            case 5 -> pCardId5;
            default -> throw new IndexOutOfBoundsException("getIdOfCard IOOB");
        };
    }

    public int getpId() {
        return pId;
    }
    public List<String> asListOfCardIds(){
        List<String> cardIds = new ArrayList<>();
        cardIds.add(pCardId1);
        cardIds.add(pCardId2);
        cardIds.add(pCardId3);
        cardIds.add(pCardId4);
        cardIds.add(pCardId5);
        return cardIds;
    }

    public String getpCardId1() {
        return pCardId1;
    }

    public String getpCardId2() {
        return pCardId2;
    }

    public String getpCardId3() {
        return pCardId3;
    }

    public String getpCardId4() {
        return pCardId4;
    }

    public String getpCardId5() {
        return pCardId5;
    }

}
