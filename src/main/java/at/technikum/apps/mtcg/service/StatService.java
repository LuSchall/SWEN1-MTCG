package at.technikum.apps.mtcg.service;

import com.fasterxml.jackson.databind.ObjectMapper;

//todo delete - same functionality as userService - separating them makes it just more complicated
public class StatService {
    private final UserService userService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public StatService(UserService userService) {
        this.userService = userService;
    }
}
