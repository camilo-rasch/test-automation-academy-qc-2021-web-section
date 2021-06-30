package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the Profile page.
 * @author juancarlos.ortiz
 */
public class ProfilePage extends BasePage {

    @FindBy (css = "div[ng-if=\"vm.readOnlyEmailValue\"] > div > span.value span")
    private WebElement emailText;

    @FindBy (id = "cancel-account")
    private WebElement deleteAccountButton;

    @FindBy (css = "button[ng-click=\"vm.confirm()\"]")
    private WebElement deleteConfirmationButton;

    /**
     * Constructor.
     * @param driver WebDriver
     *
     */
    public ProfilePage(WebDriver driver) {
        super(driver);

    }

    /**
     * Getter for Email text
     * @return WebElement
     */
    public WebElement getEmailText() {
        return emailText;
    }

    /**
     * Getter for delete Account Button
     * @return WebElement
     */
    public WebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    /**
     * Getter for Delete Confirmation Button
     * @return WebElement
     */
    public WebElement getDeleteConfirmationButton() {
        return deleteConfirmationButton;
    }


    /**
     * Method to Delete Account
     */
    public void deleteAccount(){
        clickOnElement(getDeleteAccountButton());
        clickOnElement(getDeleteConfirmationButton());
    }























}
