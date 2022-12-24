package abstractfactory.product;

import java.io.Serializable;
import java.util.Objects;

abstract public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private String supplier;

    public Product(String supplier) {
        this.supplier = supplier;
    }

    public Product() {
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
        return Objects.equals(this.supplier, other.supplier);
    }
}
