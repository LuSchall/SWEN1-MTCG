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
    private static final String FIND_BY_USERNAME_SQL = "SELECT * FROM users WHERE Username = ?";
    private static final String SAVE_SQL = "INSERT INTO users(Username, Password) VALUES(?, ?)";


    @Override
    public Optional<User> findByUsername(String username) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(FIND_BY_USERNAME_SQL);
        ) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            User user;
            if (rs.next()) {
                user = new User(
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Elo"),
                        rs.getInt("Coins"),
                        rs.getString("ProfileName"),
                        rs.getString("Bio"),
                        rs.getString("Image")
                );
                //System.out.println(user.getUsername());
                return Optional.of(user);
            }
            return Optional.empty();

        } catch (SQLException e) {
            return Optional.empty();
        }
    }
    @Override
    public boolean saveInDB(User user) { // returns true if successful and false if already in db
        if (findByUsername(user.getUsername()).isPresent()) {
            return false;
        }
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SAVE_SQL)
        ) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

