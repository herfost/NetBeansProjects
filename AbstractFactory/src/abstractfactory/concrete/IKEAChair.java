package abstractfactory.concrete;

import abstractfactory.product.Chair;

public class IKEAChair extends Chair {

    private static final long serialVersionUID = 1L;

    public IKEAChair() {
        super("IKEA's Material", "IKEA");
    }
}
