package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.PackageService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.UserService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

import java.util.Optional;

public class PackageController implements Controller {
    private final PackageService packageService;
    private final SessionService sessionService;
    private static final String packageRoute = "/packages";
    private static final String transactionRoute = "/transactions/packages";

    public PackageController(PackageService packageService, SessionService sessionService) {
        this.packageService = packageService;
        this.sessionService = sessionService;
    }

    @Override
    public boolean supports(String route) {
        return route.equals(packageRoute) || route.equals(transactionRoute);
    }

    @Override
    public Response handle(Request request) throws Exception {
        Optional<Response> tokenInvalidResponse = sessionService.tokenInvalidResponse(request);
        if (tokenInvalidResponse.isPresent()) return tokenInvalidResponse.get();
        boolean adminSession = sessionService.isAdmin(request);
        Response response = new Response();
        if (adminSession && request.getRoute().equals(packageRoute)) {
            //todo continue
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("package controller unhandled");
            return response;
        }
        if (request.getRoute().equals(transactionRoute)) {
            //todo continue
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("packageTransaction controller unhandled");
            return response;
        }
        return null;
    }
}
