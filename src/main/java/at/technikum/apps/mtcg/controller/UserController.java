package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.entityJson.UserProfileJson;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

import java.util.Optional;

public class UserController implements Controller {
    private final UserService userService;
    private final SessionService sessionService;
    private static final String userRoute = "/users";
    public UserController(UserService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;
    }
    @Override
    public boolean supports(String route) {
        return route.startsWith(userRoute);
    }

    @Override
    public Response handle(Request request) throws Exception{
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
        if (userService.getUserByUsername(username).isEmpty()) {
            Response response = new Response();
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("User not found.");
        }
        //check access TOKEN here if I have time
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
        UserJson userJson = userService.getUserJsonFromBody(request.getBody());
        User user = userJson.toUser();
        Response response = new Response();
        if (userService.getUserByUsername(user.getUsername()).isEmpty()) {
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
        Optional<Response> tokenInvalidResponse = sessionService.tokenInvalidResponse(username, request);
        if(tokenInvalidResponse.isEmpty()) {
            Response response = new Response();
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.APPLICATION_JSON);
            response.setBody(userService.getJsonUserProfileAsString(userService.getUserByUsername(username).get()));
            return response;
        }
        return tokenInvalidResponse.get();
    }

    public Response updateUserProfile(String username, Request request) {
        Optional<Response> tokenInvalidResponse = sessionService.tokenInvalidResponse(username, request);
        if(tokenInvalidResponse.isEmpty()) {
            userService.updateUserProfile(username, request.getBody());
            Response response = new Response();
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("User successfully updated");
            //System.out.println("0: "+userService.getUserByUsername(username).get().getUsername()+ userService.getUserByUsername(username).get().getProfileName());
            return response;
        }
        return tokenInvalidResponse.get();
    }


}

