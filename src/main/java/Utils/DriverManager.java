package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  Utils.ConfigReader ;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static Utils.ConfigReader.getProperty;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            if ("chrome".equalsIgnoreCase(getProperty("browser"))) {
                driver = new ChromeDriver();
            } else if ("firefox".equalsIgnoreCase(getProperty("browser"))) {
                driver = new FirefoxDriver();
            } else {
                throw new RuntimeException("Unsupported browser");
            }
        }
        return driver;
    }


}
