package at.technikum.server.http;

public enum HttpRoute {
    USER("/users"),
    SESSION("/sessions"),
    PACKAGE("/packages"),
    TRANSACTION("/transactions/packages"),
    CARD("/cards"),
    DECK("/deck");

    private final String route;

    HttpRoute(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
