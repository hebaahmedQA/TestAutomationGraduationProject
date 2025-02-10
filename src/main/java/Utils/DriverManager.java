package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static Utils.ConfigReader.getProperty;
/* the job of this code is to moderate create WebDriver according to configurations properties */
public class DriverManager {
    private static WebDriver driver;
//this methode retrieve Webdriver based on browser after initialize the webdriver
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if ("chrome".equalsIgnoreCase(getProperty("browser"))) {
                driver = new ChromeDriver();
            } else if ("firefox".equalsIgnoreCase(getProperty("browser"))) {
                driver = new FirefoxDriver();
            } else if ("edge".equalsIgnoreCase(getProperty("browser"))) {
                driver = new EdgeDriver();

            } else {
                throw new RuntimeException("Unsupported browser");
            }
        }
        return driver; //return the WebDriver
    }


}