package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Package;
import at.technikum.apps.mtcg.entityJson.CardJson;
import at.technikum.apps.mtcg.repository.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public boolean userHasCards(String username) {
        return !cardRepository.findAllOfUser(username).isEmpty();
    }
    public Optional<Card> findById(String cardId) {
        return cardRepository.findById(cardId);
    }
    public String getCardsOf(String username) {
        return convertListToJsonString(getAllCardsOfUser(username));
    }

    private List<Card> getAllCardsOfUser(String username) {
        return cardRepository.findAllOfUser(username);
    }

    public List<Card> getCardsFromPackage(Package pack) {
        return cardRepository.getAllFromPackage(pack);
    }

    public String convertListToJsonString(List<Card> cardsAsList) {
        String cardsAsJsonString;
        List<CardJson> cardJsonsList = new ArrayList<>();
        for (Card card : cardsAsList) {
            cardJsonsList.add(card.toCardJson());
        }
        try {
            cardsAsJsonString = objectMapper.writeValueAsString(cardJsonsList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cardsAsJsonString;
    }

    public String convertJsonListToString(List<CardJson> cardJsonsList) {
        String cardsAsJsonString;
        try {
            cardsAsJsonString = objectMapper.writeValueAsString(cardJsonsList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cardsAsJsonString;
    }
}

