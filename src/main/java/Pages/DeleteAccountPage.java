package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccountPage {
    private WebDriver driver;

    public  DeleteAccountPage(WebDriver driver)
    {
         this.driver = driver;
    }


    private By accountDeletedButton  = By.xpath("//a[@ href = '/delete_account']");
    private By continueButton = By.xpath("//a[@data-qa ='continue-button']");
    private By accountDeletedText = By.xpath("//h2 [@data-qa = 'account-deleted']");
    //private By accountDeletedText = By.xpath("//h2 [@data-qa = 'account-deleted']");


    public DeleteAccountPage clickDeleteAccountButton ()

    {
        driver.findElement(accountDeletedButton).click();
        return this;
    }

    public DeleteAccountPage clickContinueButton ()
    {
        driver.findElement(continueButton).click();
        return this ;
    }

  public DeleteAccountPage verifyAccountDeleted ()
    {
        Assert.assertEquals(driver.findElement(accountDeletedText).getText(), "ACCOUNT DELETED!");
        return this;
    }












}
