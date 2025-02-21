package GUITests;
import Pages.*;
import Utils.DriverFactory;
import Utils.Screenshot;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utils.ConfigReader;



public class UserRegister {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserRegisterPage userRegisterPage;
    private AccountCreatedPage accountCreatedPage;
    private DeleteAccountPage  deleteAccountPage;






    @BeforeMethod
    @Step
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        driver.get(ConfigReader.getProperty("baseURL"));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clicksignupButton();
        loginPage.signUp();



    }
    @Test(dataProvider = "registerData", dataProviderClass = Utils.JsonDataProvider.class)

    public void registerUser(String name, String title, String password, String birth_date, String birth_month, String birth_year, String firstname, String lastname, String company, String address1, String address2, String country, String zipcode, String state, String city, String mobile_number )
    {

        userRegisterPage = new UserRegisterPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);


        userRegisterPage
                .ensureAccountInfoVisible()
                .selectCheckboxNewsletter()
                .selectCheckboxOffers()
                .userRegister( title, password,
                         birth_date,  birth_month,  birth_year,
                         firstname,  lastname,  company,
                        address1, address2, country,  state ,  city,  zipcode ,mobile_number );


        accountCreatedPage
                .verifyAccountCreated()
                .clickContinueButton();
     homePage
                .clickDeleteButton();

       deleteAccountPage
                .verifyAccountDeleted()
                .clickContinueButton()
        ;
    }

   @AfterMethod
    public void tearDown() {
        Screenshot.takeScreenshot(driver, "RegisterUser");

            driver.quit();
        }
    }








