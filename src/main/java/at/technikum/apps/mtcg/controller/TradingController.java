package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.entity.Deal;
import at.technikum.apps.mtcg.entityJson.DealJson;
import at.technikum.apps.mtcg.service.CardService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.apps.mtcg.service.TradingService;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

public class TradingController implements Controller {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final SessionService sessionService;
    private final TradingService tradingService;
    private static final String tradeRoute = "/tradings";

    public TradingController(TradingService tradingService, SessionService sessionService) {
        this.tradingService = tradingService;
        this.sessionService = sessionService;
    }


    @Override
    public boolean supports(String route) {
        return route.equals(tradeRoute) || route.startsWith(tradeRoute + "/");
    }

    @Override
    public Response handle(Request request) throws Exception {
        Optional<Response> tokenInvalidResponse = sessionService.tokenInvalidResponse(request);
        if (tokenInvalidResponse.isPresent()) return tokenInvalidResponse.get();
        String username = sessionService.getUserFromToken(request).get();
        Response response = new Response();
        //tradingService.is
        if (request.getRoute().equals(tradeRoute)){
            if (request.getMethod().equals("GET")) {
                //shows trading deals available
                Optional<String> tradeJsonString = tradingService.showAvailableDeals();
                if (tradeJsonString.isEmpty()) {
                    response.setStatus(HttpStatus.NO_CONTENT);
                    response.setContentType(HttpContentType.TEXT_PLAIN);
                    response.setBody("The request was fine, but there are no trading deals available");
                } else {
                    response.setStatus(HttpStatus.OK);
                    response.setContentType(HttpContentType.APPLICATION_JSON);
                    response.setBody(tradeJsonString.get());
                }
                return response;
            }
            if (request.getMethod().equals("POST")) {
                DealJson dealJson;
                try {
                    dealJson = objectMapper.readValue(request.getBody(), DealJson.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                Deal deal = dealJson.toDeal();
                //System.out.println(deal.getTradeID());
                //System.out.println(tradingService.dealExists(deal.getTradeID()));
                if (tradingService.dealExists(deal.getTradeID())) {
                    response.setStatus(HttpStatus.CONFLICT);
                    response.setContentType(HttpContentType.TEXT_PLAIN);
                    response.setBody("A deal with this deal ID already exists");
                    return response;
                }
                if (!tradingService.isOwnedByUser(username,deal.getCardToTrade())
                        && tradingService.isInDeck(username, deal.getCardToTrade())) {
                    response.setStatus(HttpStatus.FORBIDDEN);
                    response.setContentType(HttpContentType.TEXT_PLAIN);
                    response.setBody("The deal contains a card that is not owned by the user or locked in the deck");
                    return response;
                }
                tradingService.pushApprovedDeal(deal);
                response.setStatus(HttpStatus.CREATED);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("Trading deal successfully created");
                return response;
            }
            return response;
        }
        if (request.getRoute().startsWith(tradeRoute+"/")){
            String[] routeParts = request.getRoute().split("/");
            String tradeId = routeParts[2];
            if (request.getMethod().equals("DELETE")) {
                if (!tradingService.cardOfTradeIsOwnedByUser(username, tradeId)) {
                    response.setStatus(HttpStatus.CREATED);
                    response.setContentType(HttpContentType.TEXT_PLAIN);
                    response.setBody("The deal contains a card that is not owned by the user or locked in the deck");
                    return response;
                }
                tradingService.deleteApprovedDeal(tradeId);
            }
            if (request.getMethod().equals("POST")) {
                //check if card is owned by the one selling AND if requirements are met AND card is not in deck
                //deal id not found
            }
        }
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("trade route unhandled or no such method for this route: "+ request.getMethod());
        return response;
    }
}
