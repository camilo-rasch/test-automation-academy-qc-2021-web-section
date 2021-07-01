package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to delete an user account
 */
public class DeleteAccount extends BasePage{
    /**
     * Locators of Delete Account window
     */
    @FindBy(css = "#cancel-account")
    private WebElement deleteAccountLink;

    @FindBy(css = "button.btn-primary")
    private WebElement deleteAccountConfirmationButton;
    //".main [type='submit']"

    @FindBy(css = "h2.title")
    private WebElement deleteAccountMessage;


    /**
     * Constructor
     * @param pDriver
     */
    public DeleteAccount(WebDriver pDriver) {
        super(pDriver);
    }

    public void deleteAccount(){
        switchToFrame();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.deleteAccountLink.click();
        clickOnElement(this.deleteAccountConfirmationButton);
    }

    /**
     * Method to assert the user cancelled the account
     * @return Message of "Account deleted" is displayed
     */
    public String validateDeletedAccount(){
        //switchToFrame();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitElementVisibility(this.deleteAccountMessage);
        return this.deleteAccountMessage.getText();
    }
}
