package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.HttpMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController implements Controller {
    private final UserService userService;
    private static final String userRoute = "/users";
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Override
    public boolean supports(String route) {
        return route.startsWith(userRoute);
    }

    @Override
    public Response handle(Request request) {
        if (request.getRoute().equals(userRoute)) {
            switch (request.getMethod()) {
                case "POST": return register(request);
                default:
                    Response response = new Response();
                    response.setStatus(HttpStatus.BAD_REQUEST);
                    response.setContentType(HttpContentType.TEXT_PLAIN);
                    response.setBody(HttpStatus.BAD_REQUEST.getMessage());
            }
        }
        //routing for the specific users
        String[] routeParts = request.getRoute().split("/");
        String username = routeParts[2];
        // check in DB if user exists
        if (userService.findByUsername(username).isEmpty()) {
            Response response = new Response();
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("User not found.");
        }
        //TODO: check access TOKEN
        switch (request.getMethod()) {
            case "GET": return getUserProfile(username, request); // only NAME BIO AND IMAGE
            case "PUT": return updateUserProfile(username, request); // only NAME BIO AND IMAGE
            default:
                Response response = new Response();
                response.setStatus(HttpStatus.BAD_REQUEST);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody(HttpStatus.BAD_REQUEST.getMessage());
        }

        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("user controller unhandled");

        return response;
    }

    public Response register(Request request) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserJson userJson;
        try {
            userJson = objectMapper.readValue(request.getBody(), UserJson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        User user = userJson.toUser();
        Response response = new Response();
        if (userService.findByUsername(user.getUsername()).isEmpty()) {
            //System.out.println(userService.findByUsername(user.getUsername()));
            userService.register(user);
            response.setStatus(HttpStatus.CREATED);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("User successfully created");
            return response;
        }
        response.setStatus(HttpStatus.CONFLICT);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("User with same username already registered");
        return response;
    }

    public Response getUserProfile(String username, Request request) {
        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("grabbing of User Profile unhandled / not implemented");
        return response;
    }

    public Response updateUserProfile(String username, Request request) {
        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("update of User Profile unhandled / not implemented");
        return response;
    }


}

