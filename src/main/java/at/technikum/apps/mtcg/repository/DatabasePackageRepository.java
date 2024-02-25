package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.data.Database;
import at.technikum.apps.mtcg.entity.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabasePackageRepository implements PackageRepository{
    private final Database database = new Database();
    private static final CardRepository cardRepository = new DarabaseCardRepository();
    private final String SAVE_PACKAGE_SQL = "INSERT INTO packages(p_cardId1, p_cardId2, p_cardId3, p_cardId4, p_cardId5) VALUES(?, ?, ?, ?, ?)";

    @Override
    public boolean savePackage(List<Card> cards) {
        boolean nothingWentWrong = true;
        for (Card card: cards) {
            if (cardRepository.findById(card.getC_Id()).isPresent()) nothingWentWrong = false;
        }
        if (nothingWentWrong) {
            for (Card card: cards) {
                if (!cardRepository.saveCard(card)) nothingWentWrong = false;
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
        return nothingWentWrong;
    }
}
