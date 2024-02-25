package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

import java.util.List;
import java.util.Optional;

public class CardController implements Controller {

    private final CardService cardService;
    private final SessionService sessionService;
    private static final String cardRoute = "/cards";

    public CardController(CardService cardService, SessionService sessionService) {
        this.cardService = cardService;
        this.sessionService = sessionService;
    }

    @Override
    public boolean supports(String route) {
        return route.equals(cardRoute);
    }

    @Override
    public Response handle(Request request) throws Exception {
        Optional<Response> invalidTokenResponse = sessionService.tokenInvalidResponse(request);
        if (invalidTokenResponse.isPresent()) return invalidTokenResponse.get();
        Response response = new Response();
        String username = sessionService.getUserFromToken(request).get(); //token got cecked so get is OK...
        if(cardService.userHasCards(username)) {
            String body = cardService.getCardsOf(username);
            response.setStatus(HttpStatus.OK);
            response.setContentType(HttpContentType.APPLICATION_JSON);
            response.setBody(body);
        }
        response.setStatus(HttpStatus.NO_CONTENT);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("The request was fine, but the user doesn't have any cards");
        return response;
    }


}
