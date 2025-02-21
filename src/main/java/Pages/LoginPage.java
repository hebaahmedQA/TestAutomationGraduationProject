package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.EmailGenerator;
import Utils.ConfigReader;

public class LoginPage {
    private WebDriver driver;
    private EmailGenerator emailGenerator;


    private By nameField = By.cssSelector("input[name ='name']");
    private By emailField = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By loginText = By.xpath("//h2[text()='Login to your account']");
    private By loginEmail = By.cssSelector("input[data-qa='login-email']");
    private By loginPassword = By.cssSelector("input[data-qa='login-password']");
    private By loginButton =  By.cssSelector("button[data-qa='login-button']");
    private By newUserText = By.xpath("//h2 [text () = 'New User Signup!']");
    private By errorMessage = By.xpath("//p[text() = 'Email Address already exist!']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.emailGenerator = new EmailGenerator();
    }


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
        Assert.assertEquals(driver.findElement(newUserText).getText(),ConfigReader.getProperty("new.user.text"));
        return  this ;
    }

    public  LoginPage verifyAlreadyEmailErrorMessage ()
    {
        Assert.assertEquals(driver.findElement(errorMessage).getText(),ConfigReader.getProperty("email.error.message"));
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
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(ConfigReader.getProperty("login.title.text")));


        return this;
    }
    public  LoginPage loginTextVisibility ()
    {
        Assert.assertEquals(driver.findElement(loginText).getText(),ConfigReader.getProperty("login.message"));
        return this;
    }


}
