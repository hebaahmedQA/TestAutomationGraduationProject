package GUITests;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.DriverFactory;
import Utils.Screenshot;
import io.qameta.allure.AllureId;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class userRegisterWithExistingEmail {


    WebDriver driver ;
    HomePage homePage ;
    LoginPage loginPage ;
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        driver.get(ConfigReader.getProperty("baseURL"));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.verifyHomePageVisibility()
                .clicksignupButton();


    }


 @Test(dataProvider = "SignUpData", dataProviderClass = Utils.JsonDataProvider.class)
    public void userRegisterWithExistingEmail (String name , String email) {
     loginPage.verifyNewUserText()
             .signUpWithExistingEmail(name, email)
             .verifyAlreadyEmailErrorMessage();
 }

    @AfterMethod
    public void tearDown() {
        Screenshot.takeScreenshot(driver ,"userRegisterWithExistingEmail");

        driver.quit();
    }

}
