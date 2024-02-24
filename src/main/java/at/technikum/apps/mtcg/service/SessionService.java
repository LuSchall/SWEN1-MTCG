package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SessionService {
    private final UserService userService;

    private Map<String, Optional<String>> tokens = new HashMap<>();

    public SessionService(UserService userService) {
        this.userService = userService;
    }

    public Optional<String> login(String body) {
        UserJson user = userService.getUserJsonFromBody(body);
        Optional<User> registeredUser = userService.findByUsername(user.getUsername());
        if (registeredUser.isPresent() && registeredUser.get().getPassword().equals(user.getPassword())) {
            Optional<String> newToken = generateBearerToken(user.getUsername());
            tokens.put(user.getUsername(), newToken);
            return newToken;
        }
        return Optional.empty();
    }

    private boolean isUserLoggedIn(String username) {
        if (tokens.get(username).isEmpty()) return false;
        return tokens.get(username).equals(generateBearerToken(username));
    }

    public Optional<User> isLoggedIn(Optional<String> authorization){
        if(authorization.isEmpty()) return Optional.empty();
        return getUserOfToken(authorization.get());
    }

    private Optional<String> generateBearerToken(String username) {
        return Optional.of(username + "-mtcgToken");
    }

    private Optional<User> getUserOfToken(String token){
        //MAGIC
        int length = token.length();
        token = token.substring(7, length - 10);
                //012345    0123456789
                //Bearer    -mtcgToken
        return userService.findByUsername(token);
    }
}