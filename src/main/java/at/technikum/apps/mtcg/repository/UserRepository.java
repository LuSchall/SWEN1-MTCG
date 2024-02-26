package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserStatsJson;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    //saves the user in the db. if he already is does nothing.
    //after adding or confirming he is, returns true, else false.
    void saveInDB(User user);
    Optional<User> findByUsername(String username);
    void updateUserProfile(String username, String profileName, String bio, String image);
    List<User> getSortedUsersByElo();
}
