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


    @Override
    public List<Deal> getAvailableDeals() {
        List<Deal> allDeals = new ArrayList<>();
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_DEALS_SQL);
                ResultSet rs = pstmt.executeQuery();
        ) {
            Deal deal;
            if (rs.next()) {
                deal = new Deal(
                        rs.getString("TradeID"),
                        rs.getString("CardToTrade"),
                        rs.getString("Type"),
                        rs.getInt("MinDamage")
                );
                return allDeals;
            }
            return allDeals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

