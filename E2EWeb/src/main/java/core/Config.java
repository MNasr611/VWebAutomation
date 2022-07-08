package core;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static helpers.PropertiesLoader.readPropertyFile;
import static java.lang.System.getProperty;

public class Config {
    private static String url;

    public Config() {
        Logger.getLogger("org.openqa.core.remote").setLevel(Level.OFF);
        Properties prop = readPropertyFile("config/url.properties");
        url = System.getProperty("URL", prop.getProperty("URL"));
    }

    public String getUrl() {
        return url;
    }

}
