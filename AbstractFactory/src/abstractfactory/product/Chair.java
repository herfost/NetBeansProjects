package abstractfactory.product;

abstract public class Chair extends Product {

    private static final long serialVersionUID = 1L;

    private String material;

    public Chair(String material, String supplier) {
        super(supplier);
        this.material = material;
    }

    public Chair() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
