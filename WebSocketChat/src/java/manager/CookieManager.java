package manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.core.NewCookie;

final public class CookieManager<T> {

    private static CookieManager instance = null;
    private final Map<T, NewCookie> cookies;

    private CookieManager() {
        cookies = new ConcurrentHashMap<>();
    }

    public static CookieManager getInstance() {
        if (null == instance) {
            instance = new CookieManager();
        }

        return instance;
    }

    public NewCookie getCookie(T userId) {
        return cookies.get(userId);
    }

    public void put(T userId, NewCookie cookie) {
        cookies.put(userId, cookie);
    }

    public void delete(T userId) {
        cookies.remove(userId);
    }

}
