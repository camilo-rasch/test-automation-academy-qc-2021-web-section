package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Cancel Account methods.
 * @author fabio.alarcon
 */

public class CancelAccount extends BasePage{

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CancelAccount(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "a[id=\"cancel-account\"]")
    private WebElement deleteAccountButton;

    @FindBy(css = "button[ng-click=\"vm.cancel()\"]")
    private WebElement confirmfirstcancel;

    @FindBy(css = "button[ng-click=\"vm.confirm()\"]")
    private WebElement confirmDeleteAccount;

    @FindBy(css = "button[ng-click=\"vm.close()\"]")
    private WebElement lastConfirmation;

    /**
     * Method to click on delete account the first time
     */
    public void cancelAccount1(){
        waitElementVisibility(this.deleteAccountButton);
        clickOnElement(this.deleteAccountButton);
    }

    /**
     * Method to check if the click in the first cancel button was success
     * @return Display the second confirmation
     */
    public boolean assertfirstcancel(){
        waitElementVisibility(this.confirmfirstcancel);
        return this.confirmfirstcancel.isDisplayed();
    }

    /**
     * Method to click on delete account the second time
     */
    public void confirmCancelAccount(){
        clickOnElement(this.confirmDeleteAccount);
    }

    /**
     * Method to confirm the deleted of the account by third time
     */
    public void lastCancelConfirmation(){
        clickOnElement(this.lastConfirmation);
    }

    /**
     * Method to confirm that the account is deleted, the driver is out of the account
     * @return Header of the webpage
     */
    public String cancelDeactivated(){
        return getDriver().getTitle();
    }
}