package manager;

import persistence.UserLoginCredentialsPersistence;

final public class PersistenceManager {

    private static UserLoginCredentialsPersistence userLoginCredentialsPersistence = null;

    public UserLoginCredentialsPersistence getUserLoginCredentialsPersistence() {
        if (null == userLoginCredentialsPersistence) {
            userLoginCredentialsPersistence = new UserLoginCredentialsPersistence();
        }
        return userLoginCredentialsPersistence;
    }
}
