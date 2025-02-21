
package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

    private static Properties properties = new Properties();

    static {

        try (FileInputStream configFile = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file!");
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}






