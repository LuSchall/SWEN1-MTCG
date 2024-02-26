package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.Deal;
import at.technikum.apps.mtcg.entityJson.DealJson;
import at.technikum.apps.mtcg.repository.TradingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TradingService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TradingRepository tradingRepository;
    private final CardService cardService;

    public TradingService(TradingRepository tradingRepository, CardService cardService) {
        this.cardService = cardService;
        this.tradingRepository = tradingRepository;
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
}
