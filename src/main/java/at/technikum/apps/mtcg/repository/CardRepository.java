package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepository {

    Optional<Card> findById(String c_Id);
    public List<Card> findAllOfUser(String username);
    public boolean saveCard(Card card);
}
