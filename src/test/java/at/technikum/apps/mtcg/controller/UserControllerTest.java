package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.server.http.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    private  UserService userService;
    private  SessionService sessionService;
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
    public void testSupportsRoute() {
        assertTrue(controller.supports("/users"));
        assertTrue(controller.supports("/users/"));
        assertTrue(controller.supports("/users/123"));

        assertFalse(controller.supports("/users123"));
    }

    @Test
    public void testRegisterFirstTime() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users");
        request.setMethod(HttpMethod.POST);
        request.setBody("*");

        final var userJson = new UserJson();
        userJson.setUsername("myUsername");
        userJson.setPassword("myPassword");

        Mockito.when(userService.getUserJsonFromBody("*")).thenReturn(userJson);
        Mockito.when(userService.getUserByUsername("myUsername")).thenReturn(Optional.empty());

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(userService).getUserJsonFromBody(Mockito.eq("*"));
        Mockito.verify(userService).getUserByUsername(Mockito.eq("myUsername"));

        final var userArgCaptor =  ArgumentCaptor.forClass(User.class);
        Mockito.verify(userService).register(userArgCaptor.capture());
        assertEquals("myUsername", userArgCaptor.getValue().getUsername());
        assertEquals("myPassword", userArgCaptor.getValue().getPassword());

        assertEquals(HttpStatus.CREATED.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.TEXT_PLAIN.getMimeType(), response.getContentType());
        assertEquals("User successfully created", response.getBody());
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

    @Test
    public void testRegisterNotPostMethod() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users");
        request.setMethod(HttpMethod.GET);

        // Act
        final var response = controller.handle(request);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.TEXT_PLAIN.getMimeType(), response.getContentType());
        assertEquals("Bad Request", response.getBody());
    }

    @Test
    public void testInvalidRoute() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users/name/invalid");

        // Act
        final var response = controller.handle(request);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.TEXT_PLAIN.getMimeType(), response.getContentType());
        assertEquals("Bad Request", response.getBody());
    }

    @Test
    public void testUnknownUser() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users/abc");


        Mockito.when(sessionService.tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request))).thenReturn(Optional.empty());
        Mockito.when(userService.getUserByUsername("abc")).thenReturn(Optional.empty());

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(sessionService).tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request));
        Mockito.verify(userService).getUserByUsername("abc");

        assertEquals(HttpStatus.NOT_FOUND.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.TEXT_PLAIN.getMimeType(), response.getContentType());
        assertEquals("User not found.", response.getBody());
    }

    @Test
    public void testInvalidUserMethod() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users/abc");
        request.setMethod(HttpMethod.DELETE);

        Mockito.when(userService.getUserByUsername("abc")).thenReturn(Optional.of(new User("1", "2")));

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(sessionService).tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request));
        Mockito.verify(userService).getUserByUsername("abc");

        assertEquals(HttpStatus.BAD_REQUEST.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.TEXT_PLAIN.getMimeType(), response.getContentType());
        assertEquals("Bad Request", response.getBody());
    }

    @Test
    public void testGetUserUnauthorized() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users/abc");
        request.setMethod(HttpMethod.GET);

        Response unauthorizedResponse = new Response();

        User savedUser = new User("1", "2");
        Mockito.when(sessionService.tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request))).thenReturn(Optional.of(unauthorizedResponse));

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(sessionService).tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request));

        assertSame(unauthorizedResponse, response);
    }

    @Test
    public void testGetUser() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users/abc");
        request.setMethod(HttpMethod.GET);

        User savedUser = new User("1", "2");
        Mockito.when(userService.getUserByUsername("abc")).thenReturn(Optional.of(savedUser));
        Mockito.when(sessionService.tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request))).thenReturn(Optional.empty());
        Mockito.when(userService.getJsonUserProfileAsString(Mockito.same(savedUser))).thenReturn("jsonForUser");

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(userService).getUserByUsername("abc");
        Mockito.verify(sessionService).tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request));
        Mockito.verify(userService).getJsonUserProfileAsString(Mockito.same(savedUser));

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.APPLICATION_JSON.getMimeType(), response.getContentType());
        assertEquals("jsonForUser", response.getBody());
    }

    @Test
    public void testUpdateUserUnauthorized() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users/abc");
        request.setMethod(HttpMethod.PUT);

        Response unauthorizedResponse = new Response();

        User savedUser = new User("1", "2");
        Mockito.when(sessionService.tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request))).thenReturn(Optional.of(unauthorizedResponse));

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(sessionService).tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request));

        assertSame(unauthorizedResponse, response);
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Arrange
        final var request = new Request();
        request.setRoute("/users/abc");
        request.setMethod(HttpMethod.PUT);
        request.setBody("UpdateJson");

        User savedUser = new User("1", "2");
        Mockito.when(sessionService.tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request))).thenReturn(Optional.empty());
        Mockito.when(userService.getUserByUsername("abc")).thenReturn(Optional.of(savedUser));

        // Act
        final var response = controller.handle(request);

        // Assert
        Mockito.verify(sessionService).tokenInvalidResponse(Mockito.eq("abc"), Mockito.same(request));
        Mockito.verify(userService).getUserByUsername("abc");
        Mockito.verify(userService).updateUserProfile("abc", "UpdateJson");

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
        assertEquals(HttpContentType.TEXT_PLAIN.getMimeType(), response.getContentType());
        assertEquals("User successfully updated", response.getBody());
    }
}