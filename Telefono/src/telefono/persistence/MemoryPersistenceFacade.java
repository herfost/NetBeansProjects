package telefono.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class astratta che tute le classi intente ad essere Persistenze gestite
 * tramite List devono ereditare
 *
 * @author herfost
 * @param <K> Datatype chiave di accesso
 * @param <T> Datatype dei valori persistiti
 */
public abstract class MemoryPersistenceFacade<K, T extends IPersistenceObject<K>> implements IPersistence<K, T> {

    private final String PATH;
    private final List<T> items;

    /**
     * Costruttore della Persistenza caricando da file;
     *
     * @param path: percorso del file
     */
    public MemoryPersistenceFacade(String path) {
        this.PATH = path;
        items = getPersistence(PATH);
    }

    /**
     * Metodo da implementare per caricare la persistenza da file
     *
     * @param path: percorso del file
     * @return la lista caricata
     */
    protected abstract List<T> getPersistence(String path);

    /**
     * Aggiunge un nuovo elemento alla persistenza
     *
     * @param value: il nuovo elemento
     * @throws IllegalArgumentException: nel caso la chiave di accesso
     * dell'elemento sia presente nella persistenza
     */
    @Override
    @SuppressWarnings("unchecked")
    public void create(T value) throws IllegalArgumentException {
        T item = null;
        try {
            item = read(value.getKey());
        } catch (IllegalArgumentException ex) {
            items.add((T) value.getClone());
            writeChanges();
        }

        if (item != null) {
            throw new IllegalArgumentException("Key already been used: @key = " + item.getKey());
        }
    }

    /**
     * Legge un elemento tramite chiave di accesso
     *
     * @param key: la chiave di accesso usata per le ricerca
     * @return l'elemento associato alla chiave dei accesso
     * @throws IllegalArgumentException: nel caso la chiave di accesso non sia
     * presente nella persistenza
     */
    @Override
    @SuppressWarnings("unchecked")
    public T read(K key) throws IllegalArgumentException {
        T item = getItem(key);
        if (item == null) {
            throw new IllegalArgumentException("Invalid Key");
        }

        return (T) item.getClone();
    }

    /**
     * Aggiorna un elemento tramite chiave di accesso
     *
     * @param value: la chiave di accesso per la ricerca
     * @throws IllegalArgumentException: nel caso la chiave di accesso non sia
     * presente nella persistenza
     */
    @Override
    @SuppressWarnings("unchecked")
    public void update(T value) throws IllegalArgumentException {
        T item = getItem(value.getKey());
        if (item == null) {
            throw new IllegalArgumentException("Invalid Key");
        }

        items.set(items.indexOf(item), (T) value.getClone());
        writeChanges();
    }

    /**
     * *
     * Rimuove un elemento tramite chiave di accesso
     *
     * @param key: la chiave di accesso per la ricerca
     * @throws IllegalArgumentException: nel caso la chiave di accesso non sia
     * presente nella persistenza
     */
    @Override
    public void delete(K key) throws IllegalArgumentException {
        T item = getItem(key);

        if (item == null) {
            throw new IllegalArgumentException("Invalid Key");
        }

        items.remove(getItem(item.getKey()));
        writeChanges();
    }

    /**
     * Restituisce la lista degli elementi nella persistenza
     *
     * @return persistenceList
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(PATH));
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MemoryPersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        /*
        List<T> copy = new ArrayList<>();
        items.forEach((T item) -> {
            copy.add((T) item.getClone());
        });
         */
    }

    /**
     * Restituisce elemento tramite chiave di accesso
     *
     * @param key: la chiave di accesso
     * @return T item | null
     */
    private T getItem(K key) {
        for (T item : items) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        items.forEach(item -> {
            builder.append(item.toString()).append('\n');
        });

        return builder.toString();
    }

    private void writeChanges() {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(items);
        } catch (FileNotFoundException ex1) {
            Logger.getLogger(MemoryPersistenceFacade.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (IOException ex1) {
            Logger.getLogger(MemoryPersistenceFacade.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
}
