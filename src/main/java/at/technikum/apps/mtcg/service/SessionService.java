package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

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
        Optional<User> registeredUser = userService.getUserByUsername(user.getUsername());
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

    public Optional<User> isLoggedIn(String authorization){
        if(authorization.isEmpty()) return Optional.empty();
        return getUserOfToken(authorization);
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
        return userService.getUserByUsername(token);
    }
    //RETURNS OPTIONAL.EMPTY IF TOKEN IS VALID!!!!!
    public Optional<Response> tokenInvalidResponse(String username, Request request) {
        Response response = new Response();
        response.setStatus(HttpStatus.UNAUTHORIZED);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("Access token is missing or invalid");
        Optional<String> token = request.getAuthorization();
        if (token.isEmpty()) return Optional.of(response);
        Optional<User> user = isLoggedIn(token.get());
        if (user.isEmpty()) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("User not found");
            return Optional.of(response);
        }
        if (user.get().getUsername().equals(username)) {
            return Optional.empty();
        }
        return Optional.of(response);
    }
}