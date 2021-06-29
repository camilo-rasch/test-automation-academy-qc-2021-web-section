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
    @FindBy(css = "cancel-account")
    private WebElement deleteAccountLink;

    @FindBy(css = ".main [type='submit']")
    private WebElement deleteAccountButton;

    /**
     * Constructor
     * @param pDriver
     */
    public DeleteAccount(WebDriver pDriver) {
        super(pDriver);
    }

    public void deleteAccount(){
        switchToFrame();
        clickOnElement(this.deleteAccountLink);
        deleteAccountButton.click();
    }
}
