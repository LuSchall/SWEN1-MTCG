package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SessionControllerTest {
    private SessionService sessionService;
    private  SessionController controller;


    @BeforeEach
    public void setUp() {
        sessionService = Mockito.mock(SessionService.class);
        controller = new SessionController(sessionService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(sessionService);
    }
    @Test
    void supports() {
        assertTrue(controller.supports("/sessions"));

        assertFalse(controller.supports("/sessions123"));
        assertFalse(controller.supports("/sessions/123"));
        assertFalse(controller.supports("sessions"));
    }
}