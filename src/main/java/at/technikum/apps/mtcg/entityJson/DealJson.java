package at.technikum.apps.mtcg.entityJson;

import at.technikum.apps.mtcg.entity.Deal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DealJson {
    @JsonProperty("Id")
    private String tradeID;
    @JsonProperty("CardToTrade")
    private String cardID;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("MinimumDamage")
    private int minimumDamage;

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public Deal toDeal() {
        return new Deal(this.tradeID, this.cardID, this.type, this.minimumDamage);
    }
}
