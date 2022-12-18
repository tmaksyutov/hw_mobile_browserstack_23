package drivers;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"})

public interface MobileDriverConfig extends Config {

    @Key("user")
    @DefaultValue("")
    String user();

    @Key("key")
    @DefaultValue("")
    String key();

    @Key("app")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String app();

    @Key("remoteUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String remoteUrl();


}
