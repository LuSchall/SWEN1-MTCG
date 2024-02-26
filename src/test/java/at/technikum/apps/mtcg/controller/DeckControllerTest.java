package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.DeckService;
import at.technikum.apps.mtcg.service.SessionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DeckControllerTest {
    private DeckService deckService;
    private SessionService sessionService;
    private  DeckController controller;


    @BeforeEach
    public void setUp() {
        deckService = Mockito.mock(DeckService.class);
        sessionService = Mockito.mock(SessionService.class);
        controller = new DeckController(deckService, sessionService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(deckService, sessionService);
    }

    @Test
    void supports() {
        assertTrue(controller.supports("/deck"));
        assertTrue(controller.supports("/deck/"));
        assertTrue(controller.supports("/deck/123"));

        assertFalse(controller.supports("/deck123"));
        assertFalse(controller.supports("deck"));
    }
}