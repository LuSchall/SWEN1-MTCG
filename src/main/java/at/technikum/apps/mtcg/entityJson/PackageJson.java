package at.technikum.apps.mtcg.entityJson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PackageJson {
    private List<CardJson> cardsJson;

    public List<CardJson> getCardsJson() {
        return cardsJson;
    }
    public boolean setCardsJsonIsViablePackage(List<CardJson> cardsJson) {
        for (int i = 0; i<5;   i++) {
            for (int j = 0; j<5; j++) {
                if (cardsJson.get(i).getC_Id().equals(cardsJson.get(j).getC_Id())) return false;
            }
        }
        if (cardsJson.size() == 5) {
            this.cardsJson = cardsJson;
            return true;
        }
        return false;
    }
}
