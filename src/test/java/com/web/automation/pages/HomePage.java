package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

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

    @FindBy (css = "button[ng-click=\"vm.submitLogin()\"]")
    private WebElement logInButton;

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








}
