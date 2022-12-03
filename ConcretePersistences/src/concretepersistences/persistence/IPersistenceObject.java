package concretepersistences.persistence;

import java.io.Serializable;

/**
 * Interfaccia devono implementare tutte le classi che devono essere persistite
 * @author herfost
 * @param <K> Datatype della chiave di accesso alla risorsa
 */
public interface IPersistenceObject<K> extends Serializable, Cloneable {
    /**
     * Restituire la chiave di accesso della risorsa
     * @return Chiave di accesso della risorsa
     */
    public K getKey();
    
    /**
     * Restituire oggetto diverso avente le stesso propiretà
     * @return Oggetto clonato
     */
    public Object getClone();
}
