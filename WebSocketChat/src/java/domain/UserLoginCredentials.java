package domain;

import java.util.Objects;

public class UserLoginCredentials<T> extends User<T> {

    private static final long serialVersionUID = 1L;

    private String password;

    public UserLoginCredentials(T id, String password, String username) {
        super(id, username);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.password);
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
        final UserLoginCredentials other = (UserLoginCredentials) obj;
        return Objects.equals(this.password, other.password);
    }

    @Override
    public T getKey() {
        return getId();
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
