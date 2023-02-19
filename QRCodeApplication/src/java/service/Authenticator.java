package service;

import configuration.Configuration;
import domain.UserLogin;
import handler.CookieHandler;
import handler.SessionHandler;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.websocket.Session;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import persistence.IPersistence;
import persistence.UserLoginPersistence;
import security.SecurityHandler;

@ApplicationPath("/")
@Path("authenticate")
public final class Authenticator extends Application {

    public static final IPersistence<String, UserLogin> persistence = new UserLoginPersistence(Configuration.getUSER_LOGIN_PERSISTENCE());

    @GET
    public String AuthenticatePage() {
        return "AuthenticatePage"; // TODO: Realizzare pagina Authenticator
    }

    @GET
    @Path("{webSocketId}/{username}/{password}/{applicationId}")
    public Response authenticate(
            @PathParam("webSocketId") String webSocketId,
            @PathParam("username") String username,
            @PathParam("password") String password,
            @PathParam("password") String applicationId
    ) throws URISyntaxException, URISyntaxException, MalformedURLException {
        UserLogin userLogin = new UserLogin(username, password);
        NewCookie autheticationCookie = SecurityHandler.authenticateUserLogin(userLogin, persistence);
        CookieHandler.addCookie(webSocketId, autheticationCookie);

        return autheticationCookie == null
                ? Response.ok().status(Response.Status.UNAUTHORIZED).build()
                : Response.ok("WELCOME").cookie(autheticationCookie).build();
    }

    @GET
    @Path("mobile/{webSocketId}/{username}/{password}/{applicationId}")
    public void mobileApplicationSentData(
            @PathParam("webSocketId") String webSocketId,
            @PathParam("username") String username,
            @PathParam("password") String password,
            @PathParam("applicationId") String applicationId
    ) throws IOException {
        String optionToken = "AUTH";
        String divider = Configuration.getDIVIDER();
        String protocol = Configuration.getPROTOCOL();
        String serverName = Configuration.getHOST();

        String serverPort = Configuration.getPORT();
        String contextPath = Configuration.getCONTEXT_PATH();
        String servicePath = Configuration.getAUTHENTICATION_PATH();

        // ULR = AUTH@localhost:8080/QRCodeApplication/authenticate/webSocketId/username/password/applicationId
        String URL = optionToken + divider + protocol + "/" + serverName + ":" + serverPort + "/" + contextPath + "/" + servicePath + "/" + webSocketId + "/" + username + "/" + password + "/" + applicationId;

        Session webSocketSession = SessionHandler.getSession(webSocketId);
        webSocketSession.getBasicRemote().sendText(URL);
    }
}
