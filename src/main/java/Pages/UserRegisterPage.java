package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;
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
15. Click 'Contلinue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button        */

public class UserRegisterPage {
    private WebDriver driver;

    // Constructor
    public UserRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By genderField = By.id("id_gender1");
    By passwordField = By.id("password");
    By dayDropDown = By.id("days");
    By monthDropDown = By.id("months");
    By yearDropDown = By.id("years");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By companyField = By.id("company");
    By address1Field = By.id("address1");
    By address2Field = By.id("address2");
    By countryDropDown = By.name("country");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumberField = By.id("mobile_number");
    By continueButton = By.xpath("//button[@type = 'submit']");
    By newsletterCheckbox = By.id("newsletter");
    By offersCheckbox = By.id("optin");
    By enterAccountInfo = By.xpath("//b[text() ='Enter Account Information']");




    // Actions
    public UserRegisterPage userRegister(
           String title, String password,
            String birth_date, String birth_month, String birth_year,
            String firstname, String lastname, String company,
            String address1, String address2, String country, String state , String city, String zipcode ,String mobile_number ) {

        driver.findElement(genderField).click(); // Select gender
        driver.findElement(passwordField).sendKeys(password);
        new Select(driver.findElement(dayDropDown)).selectByVisibleText(birth_date);
        new Select(driver.findElement(monthDropDown)).selectByVisibleText(birth_month);
        new Select(driver.findElement(yearDropDown)).selectByVisibleText(birth_year);

        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(address2Field).sendKeys(address2);

        new Select(driver.findElement(countryDropDown)).selectByVisibleText(country);

        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobile_number);

        driver.findElement(continueButton).click();
        return this;
    }

    public UserRegisterPage selectCheckboxNewsletter ()

    {
        driver.findElement(newsletterCheckbox).click();
        return this;
    }

    public UserRegisterPage selectCheckboxOffers ()

    {
        driver.findElement(offersCheckbox).click();
        return this;
    }
    public UserRegisterPage ensureAccountInfoVisible() {

        Assert.assertEquals(driver.findElement(enterAccountInfo).getText().toLowerCase(),"enter account information");

        return this ;

    }


}




