package concretepersistences.domain;

import concretepersistences.persistence.IPersistenceObject;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product implements IPersistenceObject<String> {

    public static final long serialVersionUID = 1L;

    private String uid;
    private int quantity;

    public Product() {
    }

    public Product(String uid, int quantity) {
        this.uid = uid;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUid() {
        return uid;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getKey() {
        return uid;
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        final Product other = (Product) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        return Objects.equals(this.uid, other.uid);
    }
}
