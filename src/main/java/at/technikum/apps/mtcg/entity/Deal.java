package at.technikum.apps.mtcg.entity;

import at.technikum.apps.mtcg.entityJson.DealJson;

public class Deal {
    private final String tradeID;
    private final String cardToTrade;
    private final String type;
    private final int minDamage;

    public Deal(String tradeID, String cardToTrade, String type, int minDamage) {
        this.tradeID = tradeID;
        this.cardToTrade = cardToTrade;
        this.type = type;
        this.minDamage = minDamage;
    }

    public String getTradeID() {
        return tradeID;
    }

    public String getCardToTrade() {
        return cardToTrade;
    }

    public String getType() {
        return type;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public DealJson toDealJson() {
        DealJson dealJson = new DealJson();
        dealJson.setTradeID(this.getTradeID());
        dealJson.setCardID(this.getCardToTrade());
        dealJson.setType(this.getType());
        dealJson.setMinimumDamage(this.getMinDamage());
        return dealJson;
    }

}
