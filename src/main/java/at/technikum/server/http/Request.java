package at.technikum.server.http;

import java.util.Optional;

public class Request {
    public Optional<String> getAuthorization() {
        return authorization;
    }
    public void setAuthorization(String authorization) {
        this.authorization = Optional.ofNullable(authorization);
    }
    //TOKENS
    private Optional<String> authorization;


    // GET, POST, PUT, DELETE
    private String method;

    // /, /home, /package
    private String route;

    private String host;

    // application/json, text/plain
    private String contentType;

    // 0, 17
    private int contentLength;

    // none, "{ "name": "foo" }"
    private String body;

    public String getMethod() {
        return method;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod.getMethod();
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthorization(Optional<String> authorization) {
        this.authorization = authorization;
    }
}
