package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.PackageService;
import at.technikum.apps.mtcg.service.SessionService;
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

    //no response for missing cards needed... - BUG inc.
    @Override
    public Response handle(Request request) throws Exception {
        Response response = new Response();
        if (!request.getMethod().equals("POST")) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("Method \"" +request.getMethod()+ "\" not valid at this Route");
            return response;
        }
        Optional<Response> tokenInvalidResponse = sessionService.tokenInvalidResponse(request);
        if (tokenInvalidResponse.isPresent()) return tokenInvalidResponse.get();
        //TRANSACTION
        if (request.getRoute().equals(transactionRoute)) {
            String buyer = sessionService.getUserFromToken(request).get();
            if (!packageService.hasSufficientCoins(buyer)){
                response.setStatus(HttpStatus.FORBIDDEN);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("Not enough money for buying a card package");
                return response;
            }
            if (!packageService.aPackageIsAvailabe()) {
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("No card package available for buying");
                return response;
            }
            String cardsOfPackage = packageService.sellPackageToUser(buyer);
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.APPLICATION_JSON);
            response.setBody(cardsOfPackage);
            return response;
        }
        //PACKAGE
        Optional<Response> invalidAdminSessionResponse = sessionService.invalidAdminSessionResponse(request);
        if (invalidAdminSessionResponse.isPresent()) return invalidAdminSessionResponse.get();
        if (request.getRoute().equals(packageRoute)) {
            //System.out.println("got to package admin post route");
            boolean packageAdded = packageService.addPackage(request.getBody());
            if (packageAdded) {
                //System.out.println("packages added?????");
                response.setStatus(HttpStatus.CREATED);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("Package and cards successfully created");
                return response;
            }
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("package controller unhandled");
            return response;
        }
        return response;
    }

}
