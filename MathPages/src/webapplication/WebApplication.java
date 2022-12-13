package webapplication;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class WebApplication {

    public static final int BROWSER_PORT = 80;
    public static final String NOT_FOUND_PATH = "pages/NotFound.html";
    public static final String expressionDelimiter = "=";

    /**
     * @param client
     * @return Stringa contentente la richiesta effettuata dal client
     * @throws IOException
     */
    public static String receiveHTMLRequest(Socket client) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line = bufferReader.readLine();
        StringBuilder builder = new StringBuilder();

        while (!line.isEmpty()) {
            builder.append(line);
            line = bufferReader.readLine();
        }

        return builder.toString();
    }

    public static void sendHTMLResponse(Socket client, String response) throws UnsupportedEncodingException, IOException {
        client.getOutputStream().write(response.getBytes("UTF-8"));
    }

    /**
     * @param result
     * @param body
     * @return Restituisce una stringa contentente la richiesta HTTP
     */
    public static String buildResponse(String result, String body) {
        return "HTTP/1.1 " + result + "\r\n\r\n" + body;
    }

    public static String HTMLToString(String filepath) throws FileNotFoundException {
        FileInputStream in = new FileInputStream(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader.lines().collect(Collectors.joining("\n"));
    }

    public static void runServer() throws IOException {
        ServerSocket s = new ServerSocket(BROWSER_PORT);
        while (true) {
            try (Socket client = s.accept()) {
                String request = receiveHTMLRequest(client);

                /* Request: GET /* ..., Si estrapola il metodo dal contenuto */
                String requestType = request.split(" /")[0];

                /* Si estrapola il contenuto della richiesta*/
                String requestContent = request.split(" /")[1].split(" ")[0];
                String requestPage = requestContent.split(expressionDelimiter)[0];

                System.out.println(request);
                System.out.println(requestContent);

                String response, responseResult, responseBody;

                /*  Esempio richiesta:
                    expressionDelimiter = "=",
                    10 / 2 = http://localhost/calcolatrice=10/2
                 */
                if (requestType.equals("GET") && requestPage.toUpperCase().equals("CALCOLATRICE")) {

                    /* Parsing e calcolo delle operazione da stringa mediante JavScript */
                    String operation = requestContent.split(expressionDelimiter)[1];
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

                    try {
                        responseBody
                                = "<h1>Calcolatrice</h1>\n"
                                + "<div>" + operation
                                + " = "
                                + engine.eval(operation)
                                + "</div>\n";
                        responseResult = "200 OK";
                    } catch (ScriptException ex) {
                        responseResult = "404 NOT FOUND";
                        responseBody = HTMLToString(NOT_FOUND_PATH);
                    }

                } else {
                    responseResult = "404 NOT FOUND";
                    responseBody = HTMLToString(NOT_FOUND_PATH);
                }

                response = buildResponse(responseResult, responseBody);
                sendHTMLResponse(client, response);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runServer();
    }
}
