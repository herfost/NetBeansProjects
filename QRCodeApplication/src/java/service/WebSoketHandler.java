package service;

import configuration.Configuration;
import handler.SessionHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import utility.StringParser;

@ApplicationPath("/")
@Path("/")
@ServerEndpoint(value = "/platform")
public class WebSoketHandler {

    @Context
    private ServletContext context;

    @GET
    public Response loadPage() {
        /*
        String username = "admin";
        String password = SecurityHandler.encrypter.encrypt("admin");
        Authenticator.persistence.create(new UserLogin(username, password));
         */
        return getPage("index.html");
    }

    @GET
    @Path("{pageName}")
    public Response getPage(@PathParam("pageName") String pageName) {
        String pagePath = context.getRealPath(pageName);
        String pageContent;
        Response.Status status;

        try {
            pageContent = StringParser.HTMLToString(pagePath);
            status = Response.Status.OK;
        } catch (FileNotFoundException ex) {
            pageContent = ex.getMessage();
            status = Response.Status.NOT_FOUND;
        }

        return Response.ok(pageContent).status(status).build();
    }

    @OnOpen
    public static void OnOpen(Session webSocketSession) throws IOException {
        String webSocketId = webSocketSession.getId();

        String optionToken = "GENERATE_QR";
        String divider = Configuration.getDIVIDER();
        String protocol = Configuration.getPROTOCOL();
        String serverName = Configuration.getHOST();
        String serverPort = Configuration.getPORT();
        String contextPath = Configuration.getCONTEXT_PATH();
        String servicePath = Configuration.getQRCODEPATH();

        // URL = GENERATE_QR@http://localhost:8080/QRCodeApplication/qrcode/webSocketId
        String URL = optionToken + divider + protocol + "://" + serverName + ":" + serverPort + "/" + contextPath + "/" + servicePath + "/" + webSocketId;
        webSocketSession.getBasicRemote().sendText(URL);

        SessionHandler.addSession(webSocketId, webSocketSession);
    }
}
