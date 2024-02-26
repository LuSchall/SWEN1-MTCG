package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Package;
import at.technikum.apps.mtcg.entityJson.CardJson;
import at.technikum.apps.mtcg.entityJson.outCardJson;
import at.technikum.apps.mtcg.repository.PackageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class PackageService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PackageRepository packageRepository;
    private final CardService cardService;

    public PackageService(PackageRepository packageRepository, CardService cardService) {
        this.cardService = cardService;
        this.packageRepository = packageRepository;
    }

    public boolean addPackage(String body) {
        List<CardJson> cardsJson;
        //System.out.println(body);
        try {
            cardsJson = objectMapper.readValue(body, new TypeReference<List<CardJson>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<Card> cards = new ArrayList<>();
        for (CardJson cardJson : cardsJson) {
            cards.add(cardJson.toCard());
        }
        packageRepository.savePackage(cards);
        return true;
    }


    public boolean hasSufficientCoins(String buyer) {
        return packageRepository.hasSufficientCoins(buyer);
    }

    public boolean aPackageIsAvailabe() {
        return packageRepository.packageIsAvailable();
    }

    public String sellPackageToUser(String buyer) {
        Package soldPackage = packageRepository.sellPackageTo(buyer);
        return packageCardsAsJson(soldPackage);
    }

    private String packageCardsAsJson(Package pack) {
        String cardsAsJsonString;
        List<Card> cardsAsList = cardService.getCardsFromPackage(pack);
        List<outCardJson> cardJsonsList = new ArrayList<>();
        for (Card card : cardsAsList) {
            cardJsonsList.add(card.toOutCardJson());
        }
        try {
            cardsAsJsonString = objectMapper.writeValueAsString(cardJsonsList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cardsAsJsonString;
    }

}
