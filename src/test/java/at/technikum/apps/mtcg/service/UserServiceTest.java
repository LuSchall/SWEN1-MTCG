package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;
    @BeforeEach
    public void init() {
        ObjectMapper objectMapper = new ObjectMapper();
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }
    @AfterEach
    public void verifyMock() {
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    void getUserJsonFromBody() {
        userService = new UserService(userRepository);

        String body = "{\"Username\":\"MyUsername\",\"Password\":\"MySecret\"}";

        // Act
        UserJson result = userService.getUserJsonFromBody(body);

        // Assertion
        assertEquals("MyUsername", result.getUsername());
        assertEquals("MySecret", result.getPassword());
    }
    @Test
    void testGetUserByUsername() {
        // Arrange
        String username = "Test";
        Optional<User> answer = Optional.empty();

        Mockito.when(userRepository.findByUsername(username)).thenReturn(answer);

        // Act
        Optional<User> result = userService.getUserByUsername(username);

        // Assertion
        Mockito.verify(userRepository).findByUsername(username);

        assertSame(answer, result);
    }
}