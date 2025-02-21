package Pages;

import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class AccountCreatedPage {
    private WebDriver driver;


    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }



    private By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.cssSelector("a[data-qa ='continue-button']");



    public AccountCreatedPage verifyAccountCreated ()
    {
        Assert.assertEquals(ConfigReader.getProperty("account.created.message"), driver.findElement(accountCreatedText).getText());
        return this ;
    }

    public AccountCreatedPage clickContinueButton ()

    {
        driver.findElement(continueButton).click();
        return this;
    }



}

