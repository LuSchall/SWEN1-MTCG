package at.technikum.apps.mtcg.repository;

import at.technikum.apps.mtcg.entity.User;

import java.util.Optional;

public class UserRepository implements UserRepositoryInterface{


    @Override
    public boolean saveInDB(User user) {
        return false;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
