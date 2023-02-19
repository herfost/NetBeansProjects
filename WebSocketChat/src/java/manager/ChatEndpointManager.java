package manager;

import chat.ChatEndpoint;
import domain.ChatUser;
import javax.websocket.Session;
import javax.ws.rs.core.NewCookie;

final public class ChatEndpointManager<T> {

    private static ChatEndpointManager instance = null;
    private final SessionManager sessionMessager;
    private final CookieManager cookieManager;

    private ChatEndpointManager() {
        sessionMessager = SessionManager.getInstance();
        cookieManager = CookieManager.getInstance();
    }

    public static ChatEndpointManager getInstance() {
        if (null == instance) {
            instance = new ChatEndpointManager();
        }

        return instance;
    }

    @SuppressWarnings("unchecked")
    public String getSessionId(ChatEndpoint<T> chatEndpoint) {
        T userId = chatEndpoint.getChatUserId();
        return sessionMessager.getSessionId(userId);
    }

    @SuppressWarnings("unchecked")
    public String getSessionId(ChatUser<T> chatUser) {
        T userId = chatUser.getUserInformation().getId();
        return sessionMessager.getSessionId(userId);
    }

    @SuppressWarnings("unchecked")
    public NewCookie getCookie(ChatEndpoint<T> chatEndpoint) {
        T userId = chatEndpoint.getChatUserId();
        return cookieManager.getCookie(userId);
    }

    @SuppressWarnings("unchecked")
    public NewCookie getCookie(ChatUser<T> chatUser) {
        T userId = chatUser.getUserInformation().getKey();
        return cookieManager.getCookie(userId);
    }

    @SuppressWarnings("unchecked")
    public void add(ChatEndpoint<T> chatEndpoint, Session session, NewCookie cookie) {
        T userId = chatEndpoint.getChatUserId();
        sessionMessager.put(userId, session);
        cookieManager.put(userId, cookie);
    }

    @SuppressWarnings("unchecked")
    public void remove(ChatEndpoint<T> chatEndpoint) {
        T userId = chatEndpoint.getChatUserId();
        sessionMessager.delete(userId);
        cookieManager.delete(userId);
    }
}
