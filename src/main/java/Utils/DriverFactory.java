package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static Utils.ConfigReader.getProperty;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null ;

            if ("chrome".equalsIgnoreCase(getProperty("browser"))) {
                driver = new ChromeDriver();
            } else if ("firefox".equalsIgnoreCase(getProperty("browser"))) {
                driver = new FirefoxDriver();
            } else if ("edge".equalsIgnoreCase(getProperty("browser"))) {
                driver = new EdgeDriver();

            } else {
                throw new RuntimeException("Unsupported browser");
            }
       return driver; }

    }


