package abstractfactory.factory;

import abstractfactory.product.Chair;

abstract public class FurnishingFactory {

    abstract public Chair createChair();

    public FurnishingFactory() {
    }
}
