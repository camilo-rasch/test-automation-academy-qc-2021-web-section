package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

/**
 * Class for interact with the LogIn page.
 * @author juancarlos.ortiz
 */
public class LogInPage extends BasePage {

    @FindBy (css = "a[tref=\"/members/v3_1/login\"]")
    private WebElement logInButton;

    @FindBy (css = "button[ng-click=\"vm.submitLogin()\"]")
    private WebElement newlogInButton;

    @FindBy (css = "input[ng-model=\"vm.username\"]")
    private WebElement usernameField;

    @FindBy (css = "input[ng-model=\"vm.password\"]")
    private WebElement passwordField;

    @FindBy (css = "a.btn.btn-secondary.ng-isolate-scope")
    private WebElement signUpButton;

    @FindBy (css = "h2.title")
    private WebElement AccountDeactivatedText;

    /**
     * Constructor.
     * @param driver WebDriver
     *
     */
    public LogInPage(WebDriver driver) {
        super(driver);

    }


    /**
     * Getter for Account deactivated text
     * @return WebElement
     */
    public WebElement getAccountDeactivatedText() {
        return AccountDeactivatedText;
    }

    /**
     * Getter for Sign Up Button
     * @return WebElement
     */
    public WebElement getSignUpButton() {
        return this.signUpButton;
    }

    /**
     * Getter for New Log In Button
     * @return WebElement
     */
    public WebElement getNewLogInButton() {
        return newlogInButton;
    }

    /**
     * Getter for Username field
     * @return WebELement
     */
    public WebElement getUsernameField() {
        return usernameField;
    }

    /**
     * Getter for Password Field
     * @return WebElement
     */
    public WebElement getPasswordField() {
        return passwordField;
    }


    /**
     * Method to switch to the SignUp Page
     * @return a SignUp object
     */
    public SignUpPage clickOnSignUpButton(){

        clickOnElement(getSignUpButton());

        return new SignUpPage(getDriver());
    }

    /**
     * Method to fill out the Log In form
     * @param username for the username
     * @param password for the password
     */
    public void fillLogInFields(String username,String password){
        waitElementVisibility(getUsernameField());
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
    }

    /**
     * Method to switch to the AccountPage in the LogIn button
     * @return AccountPage object
     */
    public AccountPage clickOnLogInButton(){
        clickOnElement(getNewLogInButton());
        return new AccountPage(getDriver());
    }

    /**
     * Method to check the account was deactivated by trying to log in
     * @param email for the deactivated account
     * @param password for the deactivated account
     */
    public void checkDeactivatedAccount(String email,String password){
        getUsernameField().sendKeys(email);
        getPasswordField().sendKeys(password);
        clickOnElement(getNewLogInButton());

    }

    /**
     * Method to check the Account deactivated text is displayed
     * @return true or fals
     */
    public boolean assertDeactivatedAccount(){
        waitElementVisibility(getAccountDeactivatedText());
        return getAccountDeactivatedText().isDisplayed();
    }


}
