package concretepersistences.persistence.concrete;

import concretepersistences.domain.Book;
import concretepersistences.persistence.ListPersistenceFacade;
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

public class BookPersistence extends ListPersistenceFacade<String, Book> {

    private static ArrayList<Book> list = null;

    public BookPersistence() {
        super();
    }

    public BookPersistence(String path) {
        super(path);
    }

    @Override
    protected List<Book> getPersistence() {
        if (null == list) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    protected List<Book> getPersistence(String path) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            list = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException ex) {
            list = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public void export(String path) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BookPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
