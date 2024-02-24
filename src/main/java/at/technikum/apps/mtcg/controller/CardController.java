package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

public class CardController implements Controller{

    private final CardService cardService;
    private static final String cardRoute = "/cards";

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public boolean supports(String route) {
        return route.equals(cardRoute);
    }

    @Override
    public Response handle(Request request) {
        //todo: continue here after session was implemented
        /*
        SessionService sessionService = new SessionService()
        switch (request.getMethod()) {
            case "GET": return showOwnersCards();
        }

         */
        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("card controller unhandled");
        return response;
    }


}
