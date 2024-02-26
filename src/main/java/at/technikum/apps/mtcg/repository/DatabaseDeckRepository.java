package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.data.Database;
import at.technikum.apps.mtcg.entity.Card;
import at.technikum.apps.mtcg.entity.Deck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DatabaseDeckRepository implements DeckRepository{
    private final Database database = new Database();
    private static final CardRepository cardRepository = new DarabaseCardRepository();
    private static final String GET_DECK_SQL = "SELECT * FROM decks WHERE Owner = ?";
    private static final String SAVE_DECK_SQL = "INSERT INTO decks(Owner, d_cardId1, d_cardId2, d_cardId3, d_cardId4) VALUES(?, ?, ?, ?, ?)";
    @Override
    public Optional<Deck> getDeck(String username) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_DECK_SQL);
        ) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Deck deck;
            if (rs.next()) {
                deck = new Deck(
                        rs.getString("Owner"),
                        rs.getString("d_cardId1"),
                        rs.getString("d_cardId2"),
                        rs.getString("d_cardId3"),
                        rs.getString("d_cardId4")
                );
                return Optional.of(deck);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveDeck(String username, List<Card> deckCards) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SAVE_DECK_SQL);
        ) {
            pstmt.setString(1, username);
            pstmt.setString(2, deckCards.get(0).getC_Id());
            pstmt.setString(3, deckCards.get(1).getC_Id());
            pstmt.setString(4, deckCards.get(2).getC_Id());
            pstmt.setString(5, deckCards.get(3).getC_Id());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
