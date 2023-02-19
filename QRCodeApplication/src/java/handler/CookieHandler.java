package handler;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.NewCookie;

final public class CookieHandler {

    private static Map<String, NewCookie> cookies = new HashMap<>();

    public static void addCookie(String webSocketId, NewCookie autheticationCookie) {
        cookies.put(webSocketId, autheticationCookie);
    }

    public static NewCookie getCookie(String webSocketId) {
        return cookies.get(webSocketId);
    }
}
