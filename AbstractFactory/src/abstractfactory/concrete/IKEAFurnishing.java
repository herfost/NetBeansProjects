package abstractfactory.concrete;

import abstractfactory.factory.FurnishingFactory;
import abstractfactory.product.Chair;

public class IKEAFurnishing extends FurnishingFactory {

    @Override
    public Chair createChair() {
        return new IKEAChair();
    }
}
