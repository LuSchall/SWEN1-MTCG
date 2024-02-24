package at.technikum.apps.mtcg;

import at.technikum.server.http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurlTest {
    /*
    Just an idea, maybe an alternative to the curl script

    MtcgApp mtcgApp = new MtcgApp();

    @Test
    void createUser() {
        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    curl -X POST http://localhost:10001/users --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\", \"Password\":\"daniel\"}"
     */
    MtcgApp mtcgApp = new MtcgApp();

    @Test
    void ServerIntegrationTest1of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest2of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest3of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest4of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest5of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest6of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest7of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }@Test
    void ServerIntegrationTest8of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest9of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest10of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest11of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest12of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest13of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest14of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest15of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest16of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest17of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest18of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest19of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest20of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest21of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest22of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest23of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest24of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest25of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest26of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest27of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest28of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest29of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest30of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest31of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest32of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest33of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest34of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest35of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest36of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest37of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest38of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest39of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest40of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest41of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest42of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest43of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest44of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest45of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest46of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest47of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest48of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest49of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest50of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest51of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest52of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest53of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest54of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest55of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest56of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest57of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest58of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest59of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest60of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest61of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest62of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest63of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest64of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest65of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest66of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest67of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest68of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest69of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest70of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest71of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest72of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest73of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest74of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest75of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest76of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }
    @Test
    void ServerIntegrationTest77of77() {

        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setRoute("http://localhost:10001/users");
        request.setContentType(HttpContentType.APPLICATION_JSON.getMimeType());
        request.setBody("{\"username\":\"kienboec\", \"password\":\"daniel\"}");

        Response response = mtcgApp.handle(request);

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
    }






}
