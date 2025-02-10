
package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/*The job of this code to read configurations stored in config.properties file
 to enable the tests script to retrieve the values of the keys (Baseurl , Environment , Browser)
 */

public class ConfigReader {
    //create an object from properties class
    private static Properties properties = new Properties();

    static {
        //using fileinputstream to read data
        try (FileInputStream configFile = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file!");
        }
    }
    //Retrieve the values of the properties from config file by parameter key

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}






