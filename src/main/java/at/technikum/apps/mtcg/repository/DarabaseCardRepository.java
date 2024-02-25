package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.data.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DarabaseCardRepository implements CardRepository{
    private final Database database = new Database();
    private final String FIND_ALL_OF_USER_SQL = "SELECT * FROM cards WHERE Owner  = ?";
    private final String SAVE_CARD_SQL = "INSERT INTO cards(c_Id, Name, Damage, CardElement, CardType) VALUES(?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM cards WHERE c_Id = ?";
    @Override
    public Optional<Card> findById(String c_Id) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(FIND_BY_ID_SQL);
        ) {
            pstmt.setString(1, c_Id);
            ResultSet rs = pstmt.executeQuery();
            Card card;
            if (rs.next()) {
                card = new Card(
                        rs.getString("c_Id"),
                        rs.getString("Name"),
                        rs.getInt("Damage"),
                        rs.getString("Owner")
                );
                System.out.println(card.getOwner());
                return Optional.of(card);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Card> findAllOfUser(String username) {
        List<Card> cards = new ArrayList<>();

        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(FIND_ALL_OF_USER_SQL);
        ) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Card card = new Card(
                        rs.getString("c_Id"),
                        rs.getString("Name"),
                        rs.getInt("Damage"),
                        rs.getString("Owner")
                );
                cards.add(card);
            }

            return cards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean saveCard(Card card) {
        if (findById(card.getC_Id()).isPresent()) {
            return false;
        }
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SAVE_CARD_SQL)
        ) {
            pstmt.setString(1, card.getC_Id());
            pstmt.setString(2, card.getName());
            pstmt.setInt(3, card.getDamage());
            pstmt.setString(4, card.getCardElement().get());
            pstmt.setString(5, card.getCardType().get());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


}
