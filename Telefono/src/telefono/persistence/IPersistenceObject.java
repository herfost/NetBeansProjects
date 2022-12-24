package telefono.persistence;

import java.io.Serializable;

public interface IPersistenceObject<K> extends Serializable, Cloneable {

    public K getKey();

    public Object getClone();
}
