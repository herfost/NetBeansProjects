package chat;

import domain.ChatUser;
import domain.UserInformation;
import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import manager.ChatEndpointManager;

// TODO: individuare mapping @ServerEndpoint(value = "?")
public class ChatEndpoint<T> {

    private ChatUser<T> chatUser;

    public ChatUser<T> getChatUser() {
        return chatUser;
    }

    public T getChatUserId() {
        return chatUser.getUserInformation().getKey();
    }

    @OnOpen
    @SuppressWarnings("unchecked")
    public void onOpen(Session session, @PathParam("id") T id, @PathParam("username") String username) throws IOException, EncodeException {

        UserInformation<T> userInformation = new UserInformation<>(id, username);
        chatUser = new ChatUser<>(userInformation);
        ChatEndpointManager.getInstance().add(this, session, null); // TODO: Aggiungere Cookie

        // TODO: impostare Status: online | offline
    }

    @OnClose
    @SuppressWarnings("unchecked")
    public void onClose() throws IOException, EncodeException {
        ChatEndpointManager.getInstance().remove(this);
        chatUser = null;
    }

    // TODO: @OnMessage, @OnError
}
