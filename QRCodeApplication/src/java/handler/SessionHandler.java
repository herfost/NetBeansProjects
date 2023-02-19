package handler;

import java.util.HashMap;
import java.util.Map;
import javax.websocket.Session;

final public class SessionHandler {

    private static Map<String, Session> activeSessions = new HashMap<>();

    public static Session getSession(String webSocketId) {
        return activeSessions.get(webSocketId);
    }

    public static void addSession(String webSocketId, Session webSocketSession) {
        activeSessions.put(webSocketId, webSocketSession);
    }
}
