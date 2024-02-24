package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(User user) {
        return userRepository.saveInDB(user);
    }

    public Optional<User> findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public UserJson getUserJsonFromBody(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserJson userJson;
        try {
            userJson = objectMapper.readValue(body, UserJson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return userJson;
    }

}
