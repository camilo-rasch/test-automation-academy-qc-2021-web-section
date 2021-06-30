package com.web.automation.pages;

import com.web.automation.data.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Class for interact with the home page.
 * @author juancarlos.ortiz
 */
public class HomePage extends BasePage {

    @FindBy (id = "global-user-trigger")
    private WebElement globalUserButton;

    @FindBy (css = "a[tref=\"/members/v3_1/login\"]")
    private WebElement logInButton;

    @FindBy (css = "input[ng-model=\"vm.username\"]")
    private WebElement usernameField;

    @FindBy (css = "input[ng-model=\"vm.password\"]")
    private WebElement passwordField;

    public WebElement getNewlogInButton() {
        return newlogInButton;
    }

    @FindBy (css = "button[ng-click=\"vm.submitLogin()\"]")
    private WebElement newlogInButton;

    @FindBy (css = "a[ng-click=\"vm.createAccount()\"]")
    private WebElement signUpButton;

    @FindBy (css = "input[name=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy (css = "input[name=\"lastName\"]")
    private WebElement lastNameField;

    @FindBy (css = "input[name=\"email\"]")
    private WebElement emailField;

    @FindBy (css = "input[name=\"newPassword\"]")
    private WebElement newPasswordField;

    @FindBy (css = "button[did-translate=\"create.SIGN_UP\"]")
    private WebElement newSignUpButton;

    @FindBy (css = "li.display-user")
    private WebElement displayNameText;

    public WebElement getDisplayNameText() {
        return displayNameText;
    }

    public WebElement getGlobalUserButton() {
        return globalUserButton;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    public WebElement getNewSignUpButton() {
        return newSignUpButton;
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }



    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }




    public LogInPage clickOnLoginButton(){


        clickOnElement(getLogInButton());
        getDriver().switchTo().frame("disneyid-iframe");
        return new LogInPage(getDriver());
    }

    public boolean assertLogOut(){
        waitElementVisibility(getLogInButton());
        return getLogInButton().isDisplayed();
    }









}
