package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Deck;
import at.technikum.apps.mtcg.entityJson.CardJson;
import at.technikum.apps.mtcg.repository.DeckRepository;
import at.technikum.server.http.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeckService {
    private final CardService cardService;
    private final DeckRepository deckRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public DeckService(CardService cardService, DeckRepository deckRepository) {
        this.cardService = cardService;
        this.deckRepository = deckRepository;
    }

    public boolean userHasDeck(String username) {
        return deckRepository.getDeck(username).isPresent();
    }
    public boolean deckHasRightAmount(String body) {
        if (body.isEmpty()) return false;
        List<String> cardIds;
        try {
            cardIds = objectMapper.readValue(body, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cardIds.size() == 4;
    }

    private List<String> getDeckCardIds(String body) {
        List<String> cardIds;
        try {
            cardIds = objectMapper.readValue(body, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cardIds;
    }

    private List<Card> getDeckCards(String username, String body) {
        List<String> cardIds = getDeckCardIds(body);
        List<Card> deckCards = new ArrayList<>();
        Optional<Card> card;
        for (String cardId : cardIds) {
            card = cardService.findById(cardId);
            if (card.isPresent()) deckCards.add(card.get());
        }
        return deckCards;
    }

    public boolean deckIsOwnedByUser(String username, String body) {
        List<Card> deckCards = getDeckCards(username, body);
        Optional<String> owner;
        for (Card card : deckCards) {
            owner = card.getOwner();
            if (owner.isEmpty()) return false;
            if (!owner.get().equals(username)) return false;
        }
        return true;
    }

    public void saveDeck(String username, String body) {
        List<Card> deckCards = getDeckCards(username, body);
        deckRepository.saveDeck(username, deckCards);
    }

    public String getDeckJsonString(String username) {
        List<String>deckCardIds = deckRepository.getDeck(username).get().asListOfCardIds();
        List<Card> deckCards = new ArrayList<>();
        for (String cardId: deckCardIds             ) {
            deckCards.add(cardService.findById(cardId).get());
        }
        return cardService.convertListToJsonString(deckCards);
    }

    public String getDeckString(String username) {
        List<String>deckCardIds = deckRepository.getDeck(username).get().asListOfCardIds();
        List<Card> deckCards = new ArrayList<>();
        String deckString = username + ":\n";
        Card card;
        int i = 1;
        for (String cardId: deckCardIds             ) {
            card = cardService.findById(cardId).get();
            deckString = deckString +"Card" +i++ +": " + card.getName() +" with " + card.getDamage()+ " Damage.\n";
        }
        return deckString;
    }
    public Optional<Deck> getDeckFromUser(String username) {
        return deckRepository.getDeck(username);
    }
}
