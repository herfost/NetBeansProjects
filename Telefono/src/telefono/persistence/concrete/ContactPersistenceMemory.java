package telefono.persistence.concrete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import telefono.domain.Contact;
import telefono.persistence.MemoryPersistenceFacade;

public class ContactPersistenceMemory extends MemoryPersistenceFacade<Integer, Contact> {

    private static ArrayList<Contact> contacts = null;

    public ContactPersistenceMemory(String path) {
        super(path);
    }

    @Override
    protected List<Contact> getPersistence(String path) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            contacts = (ArrayList<Contact>) ois.readObject();
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }

        if (null == contacts) {
            contacts = new ArrayList();
        }

        return contacts;
    }
}
