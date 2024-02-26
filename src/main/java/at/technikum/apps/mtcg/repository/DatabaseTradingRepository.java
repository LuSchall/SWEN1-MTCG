package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.data.Database;
import at.technikum.apps.mtcg.entity.Deal;
import at.technikum.apps.mtcg.entity.Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseTradingRepository implements TradingRepository {
    private final Database database = new Database();
    private static final String GET_ALL_DEALS_SQL = "SELECT * FROM tradingdeals";
    private final String SAVE_DEAL_SQL = "INSERT INTO tradingdeals(TradeID, CardToTrade, Type, MinDamage) VALUES(?, ?, ?, ?)";

    @Override
    public List<Deal> getAvailableDeals() {
        List<Deal> allDeals = new ArrayList<>();
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_DEALS_SQL);
                ResultSet rs = pstmt.executeQuery();
        ) {
            Deal deal;
            while (rs.next()) {
                deal = new Deal(
                        rs.getString("TradeID"),
                        rs.getString("CardToTrade"),
                        rs.getString("Type"),
                        rs.getInt("MinDamage")
                );
                allDeals.add(deal);
            }
            return allDeals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveDeal(Deal deal) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SAVE_DEAL_SQL)
        ) {
            pstmt.setString(1, deal.getTradeID());
            pstmt.setString(2, deal.getCardToTrade());
            pstmt.setString(3, deal.getType());
            pstmt.setInt(4, deal.getMinDamage());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

