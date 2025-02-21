package Pages;

import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private By signupButton = By.linkText("Signup / Login");
    private By loginAsText = By.xpath("//a[contains(text(), 'Logged in as')]");
    private By deleteButton = By.linkText("Delete Account");
    private By logOutButton = By.cssSelector("a[href='/logout']");



    public HomePage clicksignupButton ()
    {
        driver.findElement(signupButton).click();
        return this;
    }

    public HomePage verifyHomePageVisibility() {

        Assert.assertEquals(driver.getTitle() , (ConfigReader.getProperty("homepage.title")));


        return this ;
    }

    public  HomePage verifyLoggedAsText (String username)
    {

        Assert.assertEquals(driver.findElement(loginAsText).getText(), ConfigReader.getProperty("loggedin.text") + " " +username);

        return  this;
    }

    public  HomePage logOut ()
    {
        driver.findElement(logOutButton).click();
        return  this ;
    }

    public HomePage clickDeleteButton ()
    {
        driver.findElement(deleteButton).click();
        return this;
    }





}
