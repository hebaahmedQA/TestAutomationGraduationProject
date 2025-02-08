package GUITests;
/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page*/

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLogout {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("baseURL"));
        driver.manage().window().maximize();
    }


    @Test(dependsOnMethods = "GUITests.UserRegister.testAutomationRegisterUser")
    public void userLogOut ( )
    {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.verifyHomePageVisibility() //verify home page visibility
                .clicksignupButton(); // Click the 'Signup / Login' button

       loginPage.loginTextVisibility() //Verify 'Login to your account' is visible
               .loginWithValidData(); //Login in with valid data
        homePage.verifyLoggedAsText("Heba")  // Verify that 'Logged in as username' is visible
                .logOut();
        loginPage.verifyUserNavigateToLoginPage(); //Verify that user is navigated to login page*/









    }
    @AfterMethod
    public void tearDown() {

            driver.quit();
        }


    }
