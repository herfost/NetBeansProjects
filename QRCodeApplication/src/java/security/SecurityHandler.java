package security;

import domain.UserLogin;
import javax.ws.rs.core.NewCookie;
import org.apache.commons.codec.digest.DigestUtils;
import persistence.IPersistence;

public final class SecurityHandler {

    public static boolean isValidUserLogin(UserLogin userLogin, IPersistence<String, UserLogin> persistence) {
        String userKey = userLogin.getKey();

        try {
            UserLogin readUserLogin = persistence.read(userKey);
            String userPassword = DigestUtils.sha256Hex(userLogin.getPassword());
            userLogin.setPassword(userPassword);

            return userLogin.equals(readUserLogin);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public static NewCookie authenticateUserLogin(UserLogin userLogin, IPersistence<String, UserLogin> persistence) {
        // TODO: Specificare name - value cookie
        String name = "authToken";
        String value = "";
        return isValidUserLogin(userLogin, persistence)
                ? new NewCookie(name, value)
                : null;
    }

}
