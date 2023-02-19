package domain;

import java.util.Objects;
import manager.ChatEndpointManager;

public class ChatUser<T> {

    private UserInformation<T> userInformation;

    public ChatUser(UserInformation<T> userInformation) {
        this.userInformation = userInformation;
    }

    public UserInformation<T> getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation<T> userInformation) {
        this.userInformation = userInformation;
    }

    public String getSessionId() {
        return ChatEndpointManager.getInstance().getSessionId(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.userInformation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChatUser<?> other = (ChatUser<?>) obj;
        return Objects.equals(this.userInformation, other.userInformation);
    }
}
