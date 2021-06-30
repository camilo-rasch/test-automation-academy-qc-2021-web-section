package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

/**
 * Class for interact with the home page.
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

    public WebElement getAccountDeactivatedText() {
        return AccountDeactivatedText;
    }


    public WebElement getSignUpButton() {
        return this.signUpButton;
    }

    public WebElement getNewLogInButton() {
        return newlogInButton;
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
     *
     */
    public LogInPage(WebDriver driver) {
        super(driver);

    }

    public SignUpPage clickOnSignUpButton(){

        clickOnElement(getSignUpButton());

        return new SignUpPage(getDriver());
    }

    public void fillLogInFields(String username,String password){
        waitElementVisibility(getUsernameField());
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
    }

    public AccountPage clickOnLogInButton(){
        clickOnElement(getNewLogInButton());
        return new AccountPage(getDriver());
    }

    public void checkDeactivatedAccount(String email,String password){
        getUsernameField().sendKeys(email);
        getPasswordField().sendKeys(password);
        clickOnElement(getNewLogInButton());

    }

    public boolean assertDeactivatedAccount(){
        waitElementVisibility(getAccountDeactivatedText());
        return getAccountDeactivatedText().isDisplayed();
    }











}
