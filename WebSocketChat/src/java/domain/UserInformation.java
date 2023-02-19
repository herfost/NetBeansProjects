package domain;

public class UserInformation<T> extends User<T> {

    private static final long serialVersionUID = 1L;

    public UserInformation(T id, String username) {
        super(id, username);
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public T getKey() {
        return super.getId();
    }
}
