package com.web.automation.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EspnProfile extends BasePage {

    @FindBy(css = "h2[did-translate='update.header.PRIMARY']")
    private WebElement updateYourAccountTitle;

    @FindBy(css = "a[ng-click='vm.cancelAccount()']")
    private WebElement deleteAccountOption;

    @FindBy(css = "h2[did-translate='deactivate.confirmation.messages.header']")
    private WebElement confirmationDeleteAccount;

    @FindBy(css = "button[ng-click='vm.confirm()']")
    private WebElement yesDeleteThisAccountButton;

    @FindBy(css = "h2[did-translate='deactivate.successful.messages.header']")
    private WebElement accountSuccessfulDeleted;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public EspnProfile(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if the ESPN Profile container is displayed
     * @return boolean
     */
    public boolean isTheESPNProfileDisplayed(){
        getDriver().switchTo().frame("disneyid-iframe");
        log.info("This is the ESPN Profile Up container");
        waitElementVisibility(this.updateYourAccountTitle);
        return this.updateYourAccountTitle.isDisplayed();
    }

    /**
     * Click on Delete Account and handle the exception until the option will be found
     */
    public void clickOnDeleteAccount(){
            try{
                clickOnElement(deleteAccountOption);
            } catch(StaleElementReferenceException e){
                clickOnElement(deleteAccountOption);
            }
        }

    /**
     * Verify if the Confirmation to Delete the Account container is displayed
     * @return boolean
     */
    public boolean isTheConfirmationToDeleteAccountDisplayed(){
        log.info("This is the Confirmation to Delete the Account container");
        waitElementVisibility(this.confirmationDeleteAccount);
        return this.confirmationDeleteAccount.isDisplayed();
    }

    /**
     * Click on Delete this Account button
     */
    public void clickOnDeleteThisAccountButton(){
        clickOnElement(this.yesDeleteThisAccountButton);
    }

    /**
     * Verify if Your account has been deleted message is displayed
     * @return String
     */
    public String messageAccountHasBeenDeleted(){
        waitElementVisibility(accountSuccessfulDeleted);
        waitElementVisibility(this.accountSuccessfulDeleted);
        return this.accountSuccessfulDeleted.getText();
    }
}
