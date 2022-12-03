package genericpersistence.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * Class astratta che tute le classi intente ad essere Persistenze gestite
 * tramite List devono ereditare
 *
 * @author herfost
 * @param <K> Datatype chiave di accesso
 * @param <T> Datatype dei valori persistiti
 */
public abstract class ListPersistenceFacade<K, T extends IPersistenceObject<K>> implements IPersistence<K, T> {

    private final List<T> items;

    public ListPersistenceFacade() {
        items = getPersistence();
    }

    /**
     * Costruttore della Persistenza caricando da file;
     *
     * @param path: percorso del file
     */
    public ListPersistenceFacade(String path) {
        items = getPersistence(path);
    }

    /**
     * Metodo da implementare per fornire la persistenza desiderata
     *
     * @return persistenceList
     */
    protected abstract List<T> getPersistence();

    /**
     * Metodo da implementare per caricare la persistenza da file
     *
     * @param path: percorso del file
     * @return la lista caricata
     */
    protected abstract List<T> getPersistence(String path);

    /**
     * Metodo da implementare per memorizzare su file la persistenza
     *
     * @param path: percorso del file
     */
    public abstract void export(String path);

    /**
     * Aggiunge un nuovo elemento alla persistenza
     *
     * @param value: il nuovo elemento
     * @throws IllegalArgumentException: nel caso la chiave di accesso
     * dell'elemento sia presente nella persistenza
     */
    @Override
    public void create(T value) throws IllegalArgumentException {
        T item = null;
        try {
            item = read(value.getKey());
        } catch (IllegalArgumentException ex) {
            items.add((T) value.getClone());
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
    public void update(T value) throws IllegalArgumentException {
        T item = getItem(value.getKey());
        if (item == null) {
            throw new IllegalArgumentException("Invalid Key");
        }

        items.set(items.indexOf(item), (T) value.getClone());
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
    }

    /**
     * Restituisce la lista degli elementi nella persistenza
     *
     * @return persistenceList
     */
    @Override
    public List<T> getAll() {
        List<T> copy = new ArrayList<>();
        items.forEach((T item) -> {
            copy.add((T) item.getClone());
        });
        return copy;
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
}
