package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Deal;
import at.technikum.apps.mtcg.entity.Deck;
import at.technikum.apps.mtcg.entityJson.DealJson;
import at.technikum.apps.mtcg.repository.TradingRepository;
import at.technikum.server.http.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TradingService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TradingRepository tradingRepository;
    private final DeckService deckService;
    private final CardService cardService;

    public TradingService(TradingRepository tradingRepository, CardService cardService, DeckService deckService) {
        this.cardService = cardService;
        this.tradingRepository = tradingRepository;
        this.deckService = deckService;
    }

    public Optional<String> showAvailableDeals() {
        List<Deal> allDeals = tradingRepository.getAvailableDeals();
        if (allDeals.isEmpty()) return Optional.empty();
        List<DealJson> allDealsJson = new ArrayList<>();
        for (Deal deal : allDeals) {
            allDealsJson.add(deal.toDealJson());
        }
        String allDealsJsonString;
        try {
            allDealsJsonString = objectMapper.writeValueAsString(allDealsJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(allDealsJsonString);
    }


    public boolean dealExists(String dealId) {
        List<Deal> deals = tradingRepository.getAvailableDeals();
        if (deals.isEmpty()) return false;
        for (Deal deal : deals) {
            if(deal.getTradeID().equals(dealId)) return true;
        }
        return false;
    }

    public boolean isOwnedByUser(String username, String cardId) {
        Optional<Card> card = cardService.findById(cardId);
        return card.filter(value -> value.getOwner().isPresent() && value.getOwner().get().equals(username)).isPresent();
    }

    public boolean isInDeck(String username, String cardId) {
        Optional<Deck> deck = deckService.getDeckFromUser(username);
        if (deck.isEmpty()) return false;
        for (String newCardID : deck.get().asListOfCardIds()) {
            if (newCardID.equals(cardId)) return true;
        }
        return false;
    }

    public void pushApprovedDeal(Deal deal) {
        tradingRepository.saveDeal(deal);
    }
}
