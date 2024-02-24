package at.technikum.apps.mtcg;

import at.technikum.apps.mtcg.controller.Controller;
import at.technikum.server.ServerApplication;
import at.technikum.server.http.HttpContentType;
import at.technikum.server.http.HttpStatus;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

import java.util.List;

public class MtcgApp implements ServerApplication {

    private List<Controller> controllers;

    public MtcgApp() {
        Injector injector = new Injector();
        this.controllers = injector.createControllerList();
    }

    @Override
    public Response handle(Request request) {

        for (Controller controller: controllers) {
            if (!controller.supports(request.getRoute())) {
                continue;
            }
            try {
                return controller.handle(request);
            } catch (Exception e) {

                Response response = new Response();
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                response.setContentType(HttpContentType.TEXT_PLAIN);
                response.setBody("Internal Error for request " + request.getMethod() + " " + request.getRoute());

                return response;
            }
        }
        Response response = new Response();
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setContentType(HttpContentType.TEXT_PLAIN);
        response.setBody("Route " + request.getRoute() + " not found in app!");
        //System.out.println(request.getAuthorization());
        return response;
    }
}