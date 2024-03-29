package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import at.technikum.apps.mtcg.data.Database;
import at.technikum.apps.mtcg.entityJson.UserStatsJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUserRepository implements UserRepository {
    private static final Database database = new Database();
    private static final String FIND_BY_USERNAME_SQL = "SELECT * FROM users WHERE Username = ?";
    private static final String GET_USERS_SORTED_BY_ELO_SQL = "SELECT * FROM users ORDER BY Elo DESC";
    private static final String SAVE_SQL = "INSERT INTO users(Username, Password) VALUES(?, ?)";
    private static final String UPDATE_PROFILE_SQL = "UPDATE users SET ProfileName = ?, Bio = ?, Image = ? WHERE Username = ?";

    @Override
    public List<User> getSortedUsersByElo() {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_USERS_SORTED_BY_ELO_SQL);
        ) {
            ResultSet rs = pstmt.executeQuery();
            List<User> orderedUsers = new ArrayList<>();
            User user;
            while (rs.next()) {
                user = new User(
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Elo"),
                        rs.getInt("Coins"),
                        rs.getString("ProfileName"),
                        rs.getString("Bio"),
                        rs.getString("Image"),
                        rs.getInt("Wins"),
                        rs.getInt("Losses")
                );
                orderedUsers.add(user);
            }
            return orderedUsers;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
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
                        rs.getString("Image"),
                        rs.getInt("Wins"),
                        rs.getInt("Losses")
                );
                //System.out.println(user.getUsername());
                return Optional.of(user);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserProfile(String username, String profileName, String bio, String image) {
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_PROFILE_SQL);
        ) {
            pstmt.setString(1, profileName);
            pstmt.setString(2, bio);
            pstmt.setString(3, image);
            pstmt.setString(4, username);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    @Override
    public void saveInDB(User user) { // returns true if successful and false if already in db
        if (findByUsername(user.getUsername()).isPresent()) {
            return;
        }
        try (
                Connection con = database.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SAVE_SQL)
        ) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

