package drivers;

import org.aeonbits.owner.ConfigFactory;


public class MobileDriverProvider {

    public static MobileDriverConfig config = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());

    public static void configure(){

    }
}
