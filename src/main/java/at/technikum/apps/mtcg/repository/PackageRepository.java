package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.Card;

import java.util.List;

public interface PackageRepository {
    public boolean savePackage(List<Card> cards);
}
