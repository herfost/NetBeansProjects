package service;

import configuration.Configuration;
import domain.UserLogin;
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

    private static final IPersistence<String, UserLogin> persistence = new UserLoginPersistence(Configuration.USER_LOGIN_PERSISTENCE);
    // TODO: associazione UserId - ApplicationId
    // TODO: associazione UserId - SessionId

    @GET
    public String AuthenticatePage() {
        return "AuthenticatePage"; // TODO: Realizzare pagina Authenticator
    }

    // TODO: Reindirizzare utente
    @GET
    @Path("{webSocketId}/{username}/{password}{applicationId}")
    public Response authenticate(
            @PathParam("webSocketId") String webSocketId,
            @PathParam("username") String username,
            @PathParam("password") String password,
            @PathParam("password") String applicationId
    ) {
        UserLogin userLogin = new UserLogin(username, password);
        NewCookie autheticationCookie = SecurityHandler.authenticateUserLogin(userLogin, persistence);
        return autheticationCookie == null
                ? Response.ok().status(Response.Status.UNAUTHORIZED).build()
                : Response.ok().cookie(autheticationCookie).build();
    }
}
