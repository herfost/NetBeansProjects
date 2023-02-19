package domain;

import java.util.Objects;
import persistence.IPersistenceObject;

public abstract class User<T> implements IPersistenceObject<T> {

    private static final long serialVersionUID = 1L;

    private final T id;

    // TODO: in aggiungiUser controllare che username non sia stato usato
    private String username;

    public User(T id, String username) {
        this.id = id;
        this.username = username;
    }

    public T getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }
}
