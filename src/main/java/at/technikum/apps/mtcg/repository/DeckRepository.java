package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Deck;

import java.util.List;
import java.util.Optional;

public interface DeckRepository {
    Optional<Deck> getDeck(String username);
    void saveDeck(String username, List<Card> deckCards);

}
