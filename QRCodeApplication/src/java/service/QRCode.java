package service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import qrLib.QR;

@ApplicationPath("/")
@Path("/qrcode")
public final class QRCode extends Application {

    @GET
    public String QRCodePage() {
        return "QRCode Page"; // TODO: Realizzare pagina QRCode
    }

    @GET
    @Produces("image/png")
    @Path("{token}")
    public Response generateQRCode(@PathParam("token") String token) {
        return Response.ok(QR.createQRCodeBufferedImage(token, 512)).build();
    }
}
