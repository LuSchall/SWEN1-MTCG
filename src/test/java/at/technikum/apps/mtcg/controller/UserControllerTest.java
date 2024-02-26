package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpMethod;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private UserService userService;
    private SessionService sessionService;
    private  UserController controller;


    @BeforeEach
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        sessionService = Mockito.mock(SessionService.class);
        controller = new UserController(userService, sessionService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(userService, sessionService);
    }

    @Test
    public void testRegisterConflict() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users");
        request.setMethod(HttpMethod.POST);
        request.setBody("*");

        final var userJson = new UserJson();
        userJson.setUsername("myUsername");
        userJson.setPassword("myPassword");

        Mockito.when(userService.getUserJsonFromBody("*")).thenReturn(userJson);
        Mockito.when(userService.getUserByUsername("myUsername")).thenReturn(Optional.of(new User("1", "2")));

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(userService).getUserJsonFromBody("*");
        Mockito.verify(userService).getUserByUsername("myUsername");

        assertEquals(HttpStatus.CONFLICT.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.TEXT_PLAIN.getMimeType(), response.getContentType());
        assertEquals("User with same username already registered", response.getBody());
    }




}