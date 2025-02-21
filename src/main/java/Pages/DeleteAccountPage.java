package Pages;

import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccountPage {
    private WebDriver driver;

    public  DeleteAccountPage(WebDriver driver)
    {
         this.driver = driver;
    }

    private By continueButton =By.cssSelector("[data-qa='continue-button']");

    private By accountDeletedText = By.xpath("//b[text()='Account Deleted!']")
;

    public DeleteAccountPage clickContinueButton ()
    {
        driver.findElement(continueButton).click();
        return this ;
    }

  public DeleteAccountPage verifyAccountDeleted ()
    {
        Assert.assertEquals(driver.findElement(accountDeletedText).getText(), ConfigReader.getProperty("account.deleted.message"));
        return this;
    }












}
