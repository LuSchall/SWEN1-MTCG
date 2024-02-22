package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

public class UserController implements Controller {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Override
    public boolean supports(String route) {
        return route.equals("/users");
    }

    @Override
    public Response handle(Request request) {
        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("user controller");

        return response;
    }
}
