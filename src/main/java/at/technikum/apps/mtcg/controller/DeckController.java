package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.DeckService;
import at.technikum.apps.mtcg.service.PackageService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

import java.util.Optional;

public class DeckController implements Controller{
    private final DeckService deckService;
    private final SessionService sessionService;
    private static final String deckRoute = "/deck";

    public DeckController(DeckService deckService, SessionService sessionService) {
        this.deckService = deckService;
        this.sessionService = sessionService;
    }



    @Override
    public boolean supports(String route) {
        return route.startsWith(deckRoute);
    }

    @Override
    public Response handle(Request request) throws Exception {
        Optional<Response> tokenInvalidResponse = sessionService.tokenInvalidResponse(request);
        if (tokenInvalidResponse.isPresent()) return tokenInvalidResponse.get();
        String username = sessionService.getUserFromToken(request).get();
        Response response = new Response();
        if (request.getMethod().equals("GET")) {
            //System.out.println(deckService.userHasDeck(username) +" "+ username);
            //System.out.println(deckService.getDeckString(username));
            if (!(deckService.userHasDeck(username))) {
                response.setStatus(HttpStatus.NO_CONTENT);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("The request was fine, but the deck doesn't have any cards");
                return response;
            }
            if (request.getRoute().endsWith("?format=plain")) {
                response.setStatus(HttpStatus.OK);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody(deckService.getDeckString(username));
                return response;
            }
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.APPLICATION_JSON);
            response.setBody(deckService.getDeckJsonString(username));
            return response;
        } else if (request.getMethod().equals("PUT")) {
            if (!deckService.deckHasRightAmount(request.getBody())){
                response.setStatus(HttpStatus.BAD_REQUEST);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("The provided deck did not include the required amount of cards");
                return response;
            }
            if (!deckService.deckIsOwnedByUser(username, request.getBody())) {
                response.setStatus(HttpStatus.FORBIDDEN);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("At least one of the provided cards does not belong to the user or is not  available");
                return response;
            }
            deckService.saveDeck(username, request.getBody());
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.TEXT_PLAIN);
            response.setBody("The deck has been successfully configured");
            return response;
        }
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("deck Controller unhandled no such Method "+ request.getMethod());
        return response;
    }
}
