package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.Deal;

import java.util.List;
import java.util.Optional;

public interface TradingRepository {
    List<Deal> getAvailableDeals();

    void saveDeal(Deal deal);

    Optional<Deal> getDealByID(String dealId);

    void deleteDeal(String tradeId);
}
