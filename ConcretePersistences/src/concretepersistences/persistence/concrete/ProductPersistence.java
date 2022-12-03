package concretepersistences.persistence.concrete;

import concretepersistences.domain.Product;
import concretepersistences.persistence.ListPersistenceFacade;
import java.util.ArrayList;
import java.util.List;

public class ProductPersistence extends ListPersistenceFacade<String, Product> {

    private static ArrayList<Product> products;

    @Override
    protected List<Product> getPersistence() {
        if (null == products) {
            products = new ArrayList<>();
        }
        return products;
    }

    @Override
    protected List<Product> getPersistence(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void export(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
