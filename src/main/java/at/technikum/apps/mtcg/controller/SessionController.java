package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

public class SessionController implements Controller{
    private final SessionService sessionService;
    private static final String sessionRoute = "/sessions";

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    @Override
    public boolean supports(String route) {
        return route.equals(sessionRoute);
    }

    @Override
    public Response handle(Request request) throws Exception {
        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("session controller unhandled");
        return response;
    }
}
