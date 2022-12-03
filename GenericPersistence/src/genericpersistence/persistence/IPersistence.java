package genericpersistence.persistence;

import java.util.List;

/**
 * Interfaccia che tutte le classi intente ad essere Peristenze devono implementare 
 * @author herfost
 * @param <K> Datatype della chiave di accesso
 * @param <T> Datatype dei valori persistiti
 */
public interface IPersistence<K, T extends IPersistenceObject<K>> {

    /**
     * Aggiunge un nuovo elemento alla persistenza
     * @param value: il nuovo elemento
     * @throws IllegalArgumentException: nel caso la chiave di accesso dell'elemento sia presente nella persistenza
     */
    public void create(T value) throws IllegalArgumentException;

    /**
     * Legge un elemento tramite chiave di accesso
     * @param key: la chiave di accesso usata per le ricerca
     * @return l'elemento associato alla chiave dei accesso
     * @throws IllegalArgumentException: nel caso la chiave di accesso non sia presente nella persistenza
     */
    public T read(K key) throws IllegalArgumentException;

    /**
     * Aggiorna un elemento tramite chiave di accesso
     * @param value: la chiave di accesso per la ricerca
     * @throws IllegalArgumentException: nel caso la chiave di accesso non sia presente nella persistenza
     */
    public void update(T value) throws IllegalArgumentException;

    /***
     * Rimuove un elemento tramite chiave di accesso
     * @param key: la chiave di accesso per la ricerca
     * @throws IllegalArgumentException: nel caso la chiave di accesso non sia presente nella persistenza
     */
    public void delete(K key) throws IllegalArgumentException;

    /**
     * Restituisce la lista degli elementi nella persistenza
     * @return persistenceList
     */
    public List<T> getAll();
}