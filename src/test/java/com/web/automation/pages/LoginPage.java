package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }


    @FindBy(css="a.btn.btn-secondary.ng-isolate-scope")
    private WebElement signUpButton;

    @FindBy(css="button.btn.btn-primary.btn-submit.ng-isolate-scope")
    private WebElement logInButton;

    @FindBy(css="input[type='email']")
    private WebElement userNameInput;

    @FindBy(css="input[type='password']")
    private WebElement userPassInput;

    //sign in page

    @FindBy(css="input[name='firstName']")
    private WebElement firstnameInput;

    @FindBy(css="input[name='lastName']")
    private WebElement lastNameInput;

    @FindBy(css="input[name='email']")
    private WebElement emailInput;

    @FindBy(css="input[name='newPassword']")
    private WebElement newPassInput;

    @FindBy(css="button.btn.btn-primary.ng-scope.ng-isolate-scope")
    private WebElement signInButton;

    //logOutPage

    @FindBy(css="#global-user-trigger")
    private WebElement userOptions;

    @FindBy(css="a[onclick^='javascript:espn.member']")
    private WebElement logOutButton;

    //assertions for loggedIn

    @FindBy(css="li.display-user")
    private WebElement userNameLabel;


    //for cancel account

    @FindBy(css="a[tref='/members/v3_1/modifyAccount']")
    private WebElement editProfileButton;

    @FindBy(css="#cancel-account")
    private WebElement cancelAccountLink;

    @FindBy(css="button.btn.btn-primary.ng-isolate-scope")
    private WebElement confirmDeleteButton;


    public void userNameSendKeys(String email){

        userNameInput.click();
        userNameInput.sendKeys(email);

    }

    public void userPassSendKeys(){

        userPassInput.click();
        userPassInput.sendKeys("Losangeles1020");

    }

    public void clickOnLoginButton(){

        this.clickOnElement(logInButton);

    }



}
