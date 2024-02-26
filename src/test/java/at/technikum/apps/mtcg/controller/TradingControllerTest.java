package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.TradingService;
import at.technikum.apps.mtcg.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TradingControllerTest {
    private TradingService tradingService;
    private SessionService sessionService;
    private  TradingController controller;


    @BeforeEach
    public void setUp() {
        tradingService = Mockito.mock(TradingService.class);
        sessionService = Mockito.mock(SessionService.class);
        controller = new TradingController(tradingService, sessionService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(tradingService, sessionService);
    }
    @Test
    void supports() {
        assertTrue(controller.supports("/tradings"));
        assertTrue(controller.supports("/tradings/123"));

        assertFalse(controller.supports("/tradings123"));
        assertFalse(controller.supports("tradings"));
        assertFalse(controller.supports("123/tradings"));
    }
}