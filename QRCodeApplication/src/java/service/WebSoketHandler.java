package service;

import java.io.IOException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/plaform")
public class WebSoketHandler {

    @OnOpen
    public static void OnOpen(Session webSocketSession) throws IOException {
        String webSocketId = webSocketSession.getId();

        String optionToken = "GENERATE_QR";
        String divider = "@";
        String serverName = "localhost";
        String serverPort = "8080";
        String contextPath = "QRCodeApplication";
        String servicePath = "authenticate";
        String URL = optionToken + divider + serverName + ":" + serverPort + "/" + contextPath + "/" + servicePath + "/" + webSocketId;
        // URL = GENERATE_QR@localhost:8080/QRCodeAuthentication/authenticate/webSocketId

        webSocketSession.getBasicRemote().sendText(URL);

        // SessionHandler.addSession(webSocketId, webSocketSession);
    }

}
