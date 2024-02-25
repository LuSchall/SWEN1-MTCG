package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entityJson.CardJson;
import at.technikum.apps.mtcg.repository.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardJson> getCardsOfUser(String username) {
        List<CardJson> cards = new ArrayList<>();
        //todo: CONTINUE HERE:: or CARD REPOSITORY FOR METHODS REQUIRED HERE

        return cards;
    }
}
