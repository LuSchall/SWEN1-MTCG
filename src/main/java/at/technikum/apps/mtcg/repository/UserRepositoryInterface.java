package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.User;
import java.util.Optional;

public interface UserRepositoryInterface {
    //saves the user in the db. if he already is does nothing.
    //after adding or confirming he is, returns true, else false.
    boolean saveInDB(User user);
    Optional<User> findByUsername(String username);





}