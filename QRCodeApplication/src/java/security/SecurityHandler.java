package security;

import domain.UserLogin;
import javax.ws.rs.core.NewCookie;
import persistence.IPersistence;

public final class SecurityHandler {

    public static final IEncryption encrypter = new SHA256Encrypter();

    public static boolean isValidUserLogin(UserLogin userLogin, IPersistence<String, UserLogin> persistence) {
        String userKey = userLogin.getKey();

        try {
            UserLogin readUserLogin = persistence.read(userKey);
            String userPassword = encrypter.encrypt(userLogin.getPassword());
            userLogin.setPassword(userPassword);

            return userLogin.equals(readUserLogin);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public static NewCookie authenticateUserLogin(UserLogin userLogin, IPersistence<String, UserLogin> persistence) {
        // TODO: Specificare name - value cookie
        String name = "authentication-token";
        String value = "TODO: metodo per la generazione dei token";
        return isValidUserLogin(userLogin, persistence)
                ? new NewCookie(name, value)
                : null;
    }
}
