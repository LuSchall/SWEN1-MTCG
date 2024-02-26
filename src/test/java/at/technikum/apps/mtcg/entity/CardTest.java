package at.technikum.apps.mtcg.entity;

import at.technikum.apps.mtcg.entityJson.CardJson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void toCardJson() {
        Card card = new Card("ID", "name", 10, "owner", CardElement.NORMAL, CardType.GOBLIN);
        CardJson cardJson = new CardJson();
        cardJson.setC_Id("ID");
        cardJson.setName("name");
        cardJson.setDamage(10);


        CardJson cardJson2 = card.toCardJson();


        assertEquals(cardJson.getC_Id(), cardJson2.getC_Id());
        assertEquals(cardJson.getName(), cardJson2.getName());
        assertEquals(cardJson.getDamage(), cardJson2.getDamage());
    }

}