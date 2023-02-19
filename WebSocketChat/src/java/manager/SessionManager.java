package manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.Session;

final public class SessionManager<T> {

    private static SessionManager instance = null;
    private final Map<Object, Session> sessions; // userId, session

    private SessionManager() {
        sessions = new ConcurrentHashMap<>();
    }

    public static SessionManager getInstance() {
        if (null == instance) {
            instance = new SessionManager();
        }

        return instance;
    }

    public String getSessionId(T userId) {
        return sessions.get(userId).getId();
    }

    public void put(T userId, Session session) {
        sessions.put(userId, session);
    }

    public void delete(T userId) {
        sessions.remove(userId);
    }

}
