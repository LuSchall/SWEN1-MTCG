package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CardControllerTest {

    private CardService cardService;
    private SessionService sessionService;
    private  CardController controller;


    @BeforeEach
    public void setUp() {
        cardService = Mockito.mock(CardService.class);
        sessionService = Mockito.mock(SessionService.class);
        controller = new CardController(cardService, sessionService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(cardService, sessionService);
    }

    @Test
    void supports() {
        assertTrue(controller.supports("/cards"));
        assertTrue(controller.supports("/cards/"));

        assertFalse(controller.supports("/cards/123"));
        assertFalse(controller.supports("/cards123"));
    }
}