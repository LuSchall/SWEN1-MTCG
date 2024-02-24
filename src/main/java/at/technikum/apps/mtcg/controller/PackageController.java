package at.technikum.apps.mtcg.controller;

import at.technikum.apps.mtcg.service.PackageService;
import at.technikum.apps.mtcg.service.SessionService;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

public class PackageController implements Controller {
    private final PackageService packageService;
    private static final String packageRoute = "/packages";

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @Override
    public boolean supports(String route) {
        return route.equals(packageRoute);
    }

    @Override
    public Response handle(Request request) throws Exception {
        return null;
    }
}
