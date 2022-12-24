package abstractfactory.concrete;

import abstractfactory.product.Chair;

public class AmazonChair extends Chair {

    private static final long serialVersionUID = 1L;

    public AmazonChair() {
        super("Amazon's Material", "Amazon");
    }
}
