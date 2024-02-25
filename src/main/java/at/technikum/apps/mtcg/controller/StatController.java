package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.StatService;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

import java.util.Optional;

public class StatController implements Controller{
    private final UserService userService;
    private final SessionService sessionService;
    private static final String statRoute = "/stats";

    public StatController(UserService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;
    }
    @Override
    public boolean supports(String route) {
        return route.equals(statRoute);
    }

    @Override
    public Response handle(Request request) throws Exception {
        Optional<Response> invalidTokenResponse = sessionService.tokenInvalidResponse(request);
        if (invalidTokenResponse.isPresent()) return invalidTokenResponse.get();
        String username = sessionService.getUserFromToken(request).get();
        Response response = new Response();
        String body = userService.getStatsAsJsonString(username);
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.APPLICATION_JSON);
        response.setBody(body);
        return response;
    }
}
