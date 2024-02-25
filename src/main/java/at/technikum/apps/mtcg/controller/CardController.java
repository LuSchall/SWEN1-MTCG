package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

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
        Optional<String> optUsername = sessionService.getUserFromToken(request);
        if (invalidTokenResponse.isPresent()) return invalidTokenResponse.get();
        if (optUsername.isEmpty()) return invalidTokenResponse.get(); //impossible i know but...
        String username = optUsername.get();
        cardService.getCardsOfUser(username);


        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("card controller unhandled");
        return response;
    }


}
