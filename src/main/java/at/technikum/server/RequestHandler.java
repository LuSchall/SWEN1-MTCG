package at.technikum.server;

import at.technikum.server.http.HttpMethod;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.util.HttpMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestHandler implements Runnable {
    //curl print formatting variables START
    private static int i= 0;
    //private static String currentMethod;
    //private static String previousMethod;
    //private static String currentRoute;
    //private static String previousRoute;

    //curl print formatting variables END
    private BufferedReader in;
    private PrintWriter out;

    private final Socket client;

    private final ServerApplication app;

    public RequestHandler(Socket client, ServerApplication app) {
        this.client = client;
        this.app = app;
    }

    @Override
    public void run() {
        try {
            handle();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handle() throws IOException {
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String httpRequest = getHttpStringFromStream(in);
        //System.out.println(httpRequest);

        Request request = HttpMapper.toRequestObject(httpRequest);
        //curl print formatting START
        /*
        currentMethod = request.getMethod();
        currentRoute = request.getRoute();
        if (!currentRoute.equals(previousRoute)) {

        }
        previousMethod = currentMethod;
        previousRoute = currentRoute;
        */
        //curl print formatting END
        /*just in case I wonder about the curl requests again...*/
        //i++; System.out.println(i + ")\n" + httpRequest + "\n------------------------------------------------------");

        Response response = app.handle(request);
        if (200 != response.getStatusCode()) response.setStatusMessage(response.getBody());


        out = new PrintWriter(client.getOutputStream(), true);
        out.write(HttpMapper.toResponseString(response));

        out.close();
        in.close();
        client.close();
    }

    // THOUGHT: create a SocketReader class
    private String getHttpStringFromStream(BufferedReader in) throws IOException {
        StringBuilder builder = new StringBuilder();

        String inputLine;
        while ((inputLine = in.readLine()) != null && !inputLine.equals("")) {
            builder
                    .append(inputLine)
                    .append(System.lineSeparator());
        }


        String httpRequest = builder.toString();

        Pattern regex = Pattern.compile("^Content-Length:\\s(.+)", Pattern.MULTILINE);
        Matcher matcher = regex.matcher(httpRequest);

        if (!matcher.find()) {
            return builder.toString();
        }

        builder.append(System.lineSeparator());

        int contentLength = Integer.parseInt(matcher.group(1));
        char[] buffer = new char[contentLength];
        in.read(buffer, 0, contentLength);
        builder.append(buffer);

        return builder.toString();
    }


}
