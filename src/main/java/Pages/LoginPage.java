package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.EmailGenerator;

public class LoginPage {
    private WebDriver driver;
    private EmailGenerator emailGenerator;

    // Locators
    private By nameField = By.xpath("//input[@name ='name']");
    private By emailField = By.xpath("//input[@data-qa = 'signup-email']");
    private By signupButton = By.xpath("//button[@data-qa = 'signup-button']");
    private By loginText = By.xpath("//h2 [ text() = 'Login to your account']");
    private By loginEmail = By.xpath("//input[@data-qa= 'login-email']");
    private By loginPassword = By.xpath("//input[@ name='password']");
    private By loginButton = By.xpath("//button [@class='btn btn-default' ]");
    private By newUserText = By.xpath("//h2 [ text () = 'New User Signup!']");
    private By errorMessage = By.xpath("//p[text() = 'Email Address already exist!']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.emailGenerator = new EmailGenerator();
    }

    // Actions Methods
    public LoginPage signUp() {
        String dynamicEmail = emailGenerator.generateDynamicEmail(); // Generate email
        driver.findElement(nameField).sendKeys("Heba");
        driver.findElement(emailField).sendKeys(dynamicEmail);
        driver.findElement(signupButton).click();
        return this;
    }

    public LoginPage loginWithValidData(String email, String pass
    ) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(pass);
        driver.findElement(loginButton).click();
        return this;
    }
    public  LoginPage verifyNewUserText ()
    {
        Assert.assertEquals(driver.findElement(newUserText).getText(), "New User Signup!");
        return  this ;
    }

    public  LoginPage verifyAlreadyEmailErrorMessage ()
    {
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Email Address already exist!");
        return  this ;
    }
    public LoginPage signUpWithExistingEmail (String name , String email)
    {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signupButton).click();
        return this ;
    }
    public LoginPage verifyUserNavigateToLoginPage ()
    {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("login"));


        return this;
    }
    public  LoginPage loginTextVisibility ()
    {
        Assert.assertEquals(driver.findElement(loginText).getText(), "Login to your account");
        return this;
    }


}
