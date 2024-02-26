package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardControllerTest {
    private UserService userService;
    private SessionService sessionService;
    private  ScoreboardController controller;


    @BeforeEach
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        sessionService = Mockito.mock(SessionService.class);
        controller = new ScoreboardController(userService, sessionService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(userService, sessionService);
    }

    @Test
    void supports() {
    }
}