package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class Screenshot {
    public static void takeScreenshot(WebDriver driver, String testName) {
        try {

            //Take screenshot and store it and copy the screenshot file to the specified destination

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destination = new File("target/screenshots/" + testName + ".png");

            FileUtils.copyFile(screenshot, destination);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

