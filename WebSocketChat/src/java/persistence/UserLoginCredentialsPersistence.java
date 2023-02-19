package persistence;

import domain.UserLoginCredentials;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UserLoginCredentialsPersistence<T> extends PersistenceFacade<T, UserLoginCredentials<T>> {

    private List<UserLoginCredentials<T>> persistence;

    public UserLoginCredentialsPersistence(String path) {
        super(path);
        this.persistence = null;
    }

    public UserLoginCredentialsPersistence() {
        super();
        this.persistence = null;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected List<UserLoginCredentials<T>> getPersistence(String path) {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            try {
                persistence = (List<UserLoginCredentials<T>>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                persistence = new ArrayList<>();
            }

        } catch (FileNotFoundException ex) {
            persistence = new ArrayList<>();
        } catch (IOException ex) {
            persistence = new ArrayList<>();
        }

        return Collections.unmodifiableList(persistence);
    }
}
