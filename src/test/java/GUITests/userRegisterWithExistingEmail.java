package GUITests;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible */

public class userRegisterWithExistingEmail {


    WebDriver driver ;
    HomePage homePage ;
    LoginPage loginPage ;
    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get(ConfigReader.getProperty("baseURL"));
        driver.manage().window().maximize();
    }



    @Test
     public void userRegisterWithExistingEmail ()
     {
         homePage = new HomePage(driver);
         loginPage = new LoginPage(driver);
         homePage.verifyHomePageVisibility()
                 .clicksignupButton();

         loginPage.verifyNewUserText()
                 .signUpWithExistingEmail("Heba", "test.heba1986@gmail.com")
                 .verifyAlreadyEmailErrorMessage();















     }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
