package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.data.Database;
import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DatabasePackageRepository implements PackageRepository {
    private final Database database = new Database();
    private static final CardRepository cardRepository = new DarabaseCardRepository();
    private static final String SAVE_PACKAGE_SQL = "INSERT INTO packages(p_cardId1, p_cardId2, p_cardId3, p_cardId4, p_cardId5) VALUES(?, ?, ?, ?, ?)";
    private static final String GET_PACKAGE_SQL = "SELECT * FROM packages ORDER BY p_Id LIMIT 1";
    private static final String DELETE_PACKAGE_SQL = "DELETE FROM packages WHERE p_Id = ?";
    private static final String UPDATE_OWNER_SQL = "UPDATE cards SET Owner = ? WHERE c_Id = ?";
    private static final String GET_COINS_SQL = "SELECT Coins FROM users WHERE Username = ?";
    private static final String UPDATE_COINS_SQL = "UPDATE users SET Coins = ? WHERE Username = ?";


    @Override
    public void savePackage(List<Card> cards) {
        for (Card card : cards) {
            cardRepository.saveCard(card);
        }
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SAVE_PACKAGE_SQL)
        ) {
            pstmt.setString(1, cards.get(0).getC_Id());
            pstmt.setString(2, cards.get(1).getC_Id());
            pstmt.setString(3, cards.get(2).getC_Id());
            pstmt.setString(4, cards.get(3).getC_Id());
            pstmt.setString(5, cards.get(4).getC_Id());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasSufficientCoins(String username) {
        return getCoins(username) >= 5;
    }

    @Override
    public boolean packageIsAvailable() {
        Optional<Package> cardPackage = getPackage();
        return cardPackage.isPresent();
    }

    @Override
    public Package sellPackageTo(String username) {
        Package cardPackage = getPackage().get();
        deletePackage(cardPackage.getpId());
        deleteCoins(username);
        assignPackage(username, cardPackage);
        return cardPackage;
    }

    private void deleteCoins(String username) {
        int coins = getCoins(username);
        coins = coins - 5;
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_COINS_SQL);
        ) {
            pstmt.setInt(1, coins);
            pstmt.setString(2, username);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int getCoins(String username) {
        int coins = 0;
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_COINS_SQL);
        ) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) coins = rs.getInt("Coins");
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(username + " Coins: " + coins);
        return coins;
    }

    private void assignPackage(String username, Package cardPackage) {
        for (int i = 1; i <= 5; i++) {
            try (
                    Connection con = database.getConnection();
                    PreparedStatement pstmt = con.prepareStatement(UPDATE_OWNER_SQL);
            ) {
                pstmt.setString(1, username);
                pstmt.setString(2, cardPackage.getIdOfCard(i));
                pstmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private Optional<Package> getPackage() {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_PACKAGE_SQL);
                ResultSet rs = pstmt.executeQuery();
        ) {
            Package cardPackage;
            if (rs.next()) {
                cardPackage = new Package(
                        rs.getInt("p_Id"),
                        rs.getString("p_cardId1"),
                        rs.getString("p_cardId2"),
                        rs.getString("p_cardId3"),
                        rs.getString("p_cardId4"),
                        rs.getString("p_cardId5")
                );
                return Optional.of(cardPackage);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deletePackage(int pId) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_PACKAGE_SQL);
        ) {
            pstmt.setInt(1, pId);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
