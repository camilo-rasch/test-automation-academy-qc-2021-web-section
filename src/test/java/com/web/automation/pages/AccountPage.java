package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the Account page.
 * @author juancarlos.ortiz
 */
public class AccountPage extends BasePage {

    @FindBy (id = "global-user-trigger")
    private WebElement globalUserButton;

    @FindBy (css = "a[tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement espnProfileButton;

    @FindBy (css = "div[ng-if=\"vm.readOnlyEmailValue\"] > div > span.value span")
    private WebElement emailText;

    @FindBy (css = "button[type=\"submit\"]")
    private WebElement doneButton;

    @FindBy (id = "cancel-account")
    private WebElement deleteAccountButton;

    @FindBy (css = "button[ng-click=\"vm.confirm()\"]")
    private WebElement deleteConfirmationButton;

    @FindBy (css = "li.display-user")
    private WebElement displayNameText;

    @FindBy (css = "a[onclick*=\"logout\"]")
    private WebElement logOutButton;

    @FindBy (css = "button[tref=\"/members/v3_1/login\"]")
    private WebElement externalLogInButton;



    /**
     * Constructor.
     * @param driver WebDriver
     *
     */
    public AccountPage(WebDriver driver) {
        super(driver);

    }

    /**
     * Getter for logOutButton
     * @return WebElement
     */
    public WebElement getLogOutButton() {
        return logOutButton;
    }

    /**
     * Getter for displayNameText
     * @return WebElement
     */
    public WebElement getDisplayNameText() {
        return displayNameText;
    }

    /**
     * Get GlobalUserButton.
     * @return WebElement
     */
    public WebElement getGlobalUserButton() {
        return globalUserButton;
    }


    /**
     * Get EspnProfileButton.
     * @return WebElement
     */
    public WebElement getEspnProfileButton() {
        return espnProfileButton;
    }

    /**
     * Getter for EmailText
     * @return WebElement
     */
    public WebElement getEmailText() {
        return emailText;
    }

    /**
     * Getter for DoneButton
     * @return WebElement
     */
    public WebElement getDoneButton() {
        return doneButton;
    }

    /**
     * Getter for DeleteAccountButton
     * @return WebElement
     */
    public WebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    /**
     * Getter for DeleteConfirmationButton
     * @return
     */
    public WebElement getDeleteConfirmationButton() {
        return deleteConfirmationButton;
    }



    /**
     * Method to switch to the ProfilePage
     * @return ProfilePage Object
     */
    public ProfilePage clickOnProfileButton(){


        clickOnElement(getEspnProfileButton());
        getDriver().switchTo().frame("disneyid-iframe");
        return new ProfilePage(getDriver());
    }

    /**
     * Method to log out user
     */
    public void logOutUser(){
        waitElementVisibility(getGlobalUserButton());
        clickOnElement(getGlobalUserButton());
        clickOnElement(getLogOutButton());

    }










}
