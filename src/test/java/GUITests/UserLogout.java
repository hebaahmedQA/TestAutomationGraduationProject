package GUITests;


import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.DriverFactory;
import Utils.Screenshot;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLogout {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeMethod
    @Step
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        driver.get(ConfigReader.getProperty("baseURL"));
        driver.manage().window().maximize();
    }


    @Test (dataProvider = "logoutData", dataProviderClass = Utils.JsonDataProvider.class)
    public void userLogOut ( String mail , String password)
    {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.verifyHomePageVisibility()
                .clicksignupButton();

        loginPage.loginTextVisibility()
                .loginWithValidData(mail,password);
        homePage.verifyLoggedAsText("Heba")
                .logOut();
        loginPage.verifyUserNavigateToLoginPage();









    }
    @AfterMethod
    public void tearDown() {
        Screenshot.takeScreenshot(driver ,"logout");

        driver.quit();
    }


}