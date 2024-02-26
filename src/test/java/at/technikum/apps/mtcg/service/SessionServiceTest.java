package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SessionServiceTest {
    private UserService userService;
    private SessionService service;
    @BeforeEach
    void setUp() {
        userService = Mockito.mock(UserService.class);
        service = new SessionService(userService);
    }

    @AfterEach
    void tearDown() {
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    void generateBearerToken() {
        String result = service.generateBearerToken("username").get();

        assertEquals("username-mtcgToken", result);
    }
/*
    @Test
    void invalidAdminSession(){
        final var request = new Request();
        request.setAuthorization("Bearer NOADMIN-mtcgToken");

        Optional<Response> response = service.invalidAdminSessionResponse(request);
        assertTrue(response.isPresent());



    }


 */

}