package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private ObjectMapper objectMapper;
    private UserRepository userRepository;
    private UserService service;

    @BeforeEach
    public void setUp() {
        objectMapper = Mockito.mock(ObjectMapper.class);
        userRepository = Mockito.mock(UserRepository.class);
        service = new UserService(userRepository);
    }

    @AfterEach
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(objectMapper, userRepository);
    }

    @Test
    void testRegister() {
        // Arrange
        User user = new User("username", "password");

        // Act
        service.register(user);

        // Assertion
        Mockito.verify(userRepository).saveInDB(Mockito.same(user));
    }

    @Test
    void testGetUserByUsername() {
        // Arrange
        String username = "Test";
        Optional<User> answer = Optional.empty();

        Mockito.when(userRepository.findByUsername(username)).thenReturn(answer);

        // Act
        Optional<User> result = service.getUserByUsername(username);

        // Assertion
        Mockito.verify(userRepository).findByUsername(username);

        assertSame(answer, result);
    }
    @Test
    void testGetUserJsonFromBodyWithRealObjectMapper() throws JsonProcessingException {
        // Arrange
        ObjectMapper realObjectMapper = new ObjectMapper();
        service = new UserService(userRepository);

        String body = "{\"Username\":\"MyUsername\",\"Password\":\"MySecret\"}";

        // Act
        UserJson result = service.getUserJsonFromBody(body);

        // Assertion
        assertEquals("MyUsername", result.getUsername());
        assertEquals("MySecret", result.getPassword());
    }
}