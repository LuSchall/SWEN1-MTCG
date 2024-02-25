package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Package;

import java.util.List;

public interface PackageRepository {
    public void savePackage(List<Card> cards);

    boolean hasSufficientCoins(String username);

    boolean packageIsAvailable();

    Package sellPackageTo(String username);

}
