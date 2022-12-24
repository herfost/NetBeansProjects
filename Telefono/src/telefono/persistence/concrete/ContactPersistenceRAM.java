package telefono.persistence.concrete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import telefono.domain.Contact;
import telefono.persistence.ListPersistenceFacade;

public class ContactPersistenceRAM extends ListPersistenceFacade<Integer, Contact> {

    private static ArrayList<Contact> contacts = null;

    @Override
    protected List<Contact> getPersistence() {
        if (null == contacts) {
            contacts = new ArrayList();
        }

        return contacts;
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

    @Override
    public void export(String path) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(contacts);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactPersistenceRAM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContactPersistenceRAM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
