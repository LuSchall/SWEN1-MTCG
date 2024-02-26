package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.TradingService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

import java.util.Optional;

public class TradingController implements Controller {
    private final SessionService sessionService;
    private final TradingService tradingService;
    private static final String tradeRoute = "/tradings";

    public TradingController(TradingService tradingService, SessionService sessionService) {
        this.tradingService = tradingService;
        this.sessionService = sessionService;
    }


    @Override
    public boolean supports(String route) {
        return route.startsWith(tradeRoute);
    }

    @Override
    public Response handle(Request request) throws Exception {
        Optional<Response> tokenInvalidResponse = sessionService.tokenInvalidResponse(request);
        if (tokenInvalidResponse.isPresent()) return tokenInvalidResponse.get();
        String username = sessionService.getUserFromToken(request).get();
        //String
        Response response = new Response();
        //tradingService.is


        if (request.getMethod().equals("GET")) {
            //shows trading deals available
            //String tradeJsonString = tradingService.showAvailableDeals();
        }
        if (request.getMethod().equals("POST") && request.getRoute().endsWith(tradeRoute)) {
            //creates new trading deal
            //check card: IF IN DECK and IF card OWNED BY USER
            //check IF DEAL_ID EXISTS
        }
        if (request.getMethod().equals("DELETE")) {
            //deletes an existing trading deal
            //check if deal is owned by user
            //check if deal found
        }
        if (request.getMethod().equals("POST")) {
            //check if card is owned by the one selling AND if requirements are met AND card is not in deck
            //deal id not found
        }
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("trade route unhandled or no such method for this route: "+ request.getMethod());
        return response;
    }
}
