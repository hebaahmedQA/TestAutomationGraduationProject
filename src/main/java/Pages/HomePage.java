package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By signupButton = By.xpath("//a[@href ='/login']");
    private By loginAsText = By.xpath("//a[contains(text(), 'Logged in as')]");
    private By deleteButton = By.cssSelector("a[href='/delete_account']");
    private By logOutButton = By.cssSelector("a[href='/logout']");




    //Methods "Actions"
    public HomePage clicksignupButton ()
    {
        driver.findElement(signupButton).click();
        return this;
    }

    public HomePage verifyHomePageVisibility() {
        String expectedPageTitle = "Automation Exercise";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Automation Exercise - Signup / Login");
        return this ;
    }

    public  HomePage verifyLoggedAsText (String username)
    {

        Assert.assertEquals(driver.findElement(loginAsText).getText(), "Logged in as " + username);
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
