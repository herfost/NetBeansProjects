package rubricatelefonica.domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import rubricatelefonica.persistence.IPersistenceObject;

@Entity
public class ContattoTelefonico implements IPersistenceObject<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    private int uid;
    private String name;
    private String description;
    private String number;

    public ContattoTelefonico(int uid, String name, String description, String number) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.number = number;
    }

    public ContattoTelefonico() {
    }

    @Override
    public Integer getKey() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ContattoTelefonico.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public String toString() {
        return "ContattoTelefonico{" + "uid=" + uid + ", name=" + name + ", description=" + description + ", number=" + number + '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
