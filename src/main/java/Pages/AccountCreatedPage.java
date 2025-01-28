package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class AccountCreatedPage {
    private WebDriver driver;

    // Constructor
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }


    //locator
    private By accountCreatedText = By.xpath("//h2[contains(@class, 'title text-center')]");
    private By continueButton = By.xpath("//a[@data-qa ='continue-button']");

    //Actions

    public AccountCreatedPage verifyAccountCreated ()
    {
        Assert.assertEquals("ACCOUNT CREATED!", driver.findElement(accountCreatedText).getText());
        return this ;
    }

    public AccountCreatedPage clickContinueButton ()

    {
        driver.findElement(continueButton).click();
        return this;
    }



}

