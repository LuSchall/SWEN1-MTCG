package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import at.technikum.apps.mtcg.data.Database;
import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.task.entity.Task;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUserRepository implements UserRepository {
    private static final Database database = new Database();
    private static final String FIND_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    private static final String SAVE = "INSERT INTO users(Username, Password) VALUES(?, ?)";
    @Override
    public boolean saveInDB(User user) { // returns true if successful and false if already in db


        return false;

    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(FIND_BY_USERNAME);
                ResultSet rs = pstmt.executeQuery()
        ) {
            if (!rs.next()) {
                return Optional.empty();
            }
            User user = new User(
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("Elo"),
                    rs.getString("Coins"),
                    rs.getString("ProfileName"),
                    rs.getString("Bio"),
                    rs.getString("Image")
            );
            return Optional.of(user);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
