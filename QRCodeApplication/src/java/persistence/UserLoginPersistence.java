package persistence;

import domain.UserLogin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLoginPersistence extends PersistenceOnFile<String, UserLogin> {

    private static List<UserLogin> persistence = null;

    public UserLoginPersistence(String path) {
        super(path);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected List<UserLogin> getPersistence(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            persistence = (List<UserLogin>) objectInputStream.readObject();
            return persistence;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserLoginPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UserLoginPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<>();
    }
}
