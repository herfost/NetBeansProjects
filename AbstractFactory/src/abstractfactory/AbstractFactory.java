package abstractfactory;

import abstractfactory.concrete.AmazonFurnishing;
import abstractfactory.concrete.IKEAFurnishing;
import abstractfactory.factory.FurnishingFactory;

public class AbstractFactory {

    public static void main(String[] args) {
        FurnishingFactory furnishing;
        AmazonFurnishing amazonFurnishing = new AmazonFurnishing();
        IKEAFurnishing ikeaFurnishing = new IKEAFurnishing();

        furnishing = amazonFurnishing;
        System.out.println(furnishing.createChair().getSupplier());

        furnishing = ikeaFurnishing;
        System.out.println(furnishing.createChair().getSupplier());
    }
}
