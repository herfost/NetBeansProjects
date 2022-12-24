package telefono.domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import telefono.persistence.IPersistenceObject;

public class Contact implements IPersistenceObject<Integer> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(Integer id, String name, String surname, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Integer getKey() {
        return id;
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
