package abstractfactory.concrete;

import abstractfactory.factory.FurnishingFactory;
import abstractfactory.product.Chair;

public class AmazonFurnishing extends FurnishingFactory {

    @Override
    public Chair createChair() {
        return new AmazonChair();
    }

}
