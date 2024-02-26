package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.PackageService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PackageControllerTest {
    private PackageService packageService;
    private SessionService sessionService;
    private  PackageController controller;


    @BeforeEach
    public void setUp() {
        packageService = Mockito.mock(PackageService.class);
        sessionService = Mockito.mock(SessionService.class);
        controller = new PackageController(packageService, sessionService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(packageService, sessionService);
    }
    @Test
    void supports() {
    }
}