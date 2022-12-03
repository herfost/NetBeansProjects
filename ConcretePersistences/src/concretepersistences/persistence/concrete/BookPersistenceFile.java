package concretepersistences.persistence.concrete;

import concretepersistences.domain.Book;
import concretepersistences.persistence.MemoryPersistenceFacade;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookPersistenceFile extends MemoryPersistenceFacade<String, Book> {

    private static ArrayList<Book> list = null;

    public BookPersistenceFile(String path) {
        super(path);
    }

    @Override
    @SuppressWarnings("unchecked")
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
        return Collections.unmodifiableList(list);
    }

}
