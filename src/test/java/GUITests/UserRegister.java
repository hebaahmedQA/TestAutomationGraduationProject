package GUITests;
import Pages.*;
import Utils.DriverManager;
import Utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utils.ConfigReader;
/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/


public class UserRegister {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserRegisterPage userRegisterPage;
    private AccountCreatedPage accountCreatedPage;
    private DeleteAccountPage  deleteAccountPage;




    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("baseURL"));
        driver.manage().window().maximize();


    }
    @Test(dataProvider = "registerData", dataProviderClass = Utils.JsonDataProvider.class)

    public void testAutomationRegisterUser(String name, String title, String password, String birth_date, String birth_month, String birth_year, String firstname, String lastname, String company, String address1, String address2, String country, String zipcode, String state, String city, String mobile_number )
    {


        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userRegisterPage = new UserRegisterPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);

        homePage.clicksignupButton(); // Navigate to signup page
        loginPage.signUp(); // Go to registration page

        // Register user

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








