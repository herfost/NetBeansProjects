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

public class WebApplication {

    public static final int BROWSER_PORT = 80;
    public static final String HOME_PATH = "pages/Home.html";
    public static final String NOT_FOUND_PATH = "pages/NotFound.html";

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
            Socket client = s.accept();
            String request = receiveHTMLRequest(client);

            /* Request = GET /* ..., Si estrapola il metodo dal contenuto */
            String requestType = request.split(" /")[0];

            /* Si estrapola il contenuto della richiesta*/
            String requestContent = request.split("/")[1].split(" ")[0];

            String response, responseResult, responseBody;

            if (requestType.equals("GET") && requestContent.toUpperCase().equals("HOME")) {
                responseResult = "200 OK";
                responseBody = HTMLToString(HOME_PATH);
            } else {
                responseResult = "404 NOT FOUND";
                responseBody = HTMLToString(NOT_FOUND_PATH);
            }

            response = buildResponse(responseResult, responseBody);
            sendHTMLResponse(client, response);

            client.close();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runServer();
    }
}
