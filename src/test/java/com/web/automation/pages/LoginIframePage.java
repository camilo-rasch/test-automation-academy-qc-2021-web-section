package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginIframePage extends BasePage {

    @FindBy(css = "h1[class='logo logo-primary']")
    private WebElement logoIframe;

    @FindBy(id = "disneyid-iframe")
    private WebElement iFrame;

    @FindBy(css = "input[type='email']")
    private WebElement email;

    @FindBy(css = "input[type='Password']")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "img[class='quicklinks_plus_icon']")
    private WebElement logoMainPage;

    @FindBy(css = "a[ng-click='vm.createAccount()']")
    private WebElement signUpButton;

    private String searchFlightsPageHandle ="";

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginIframePage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if the logo from Login Iframe is displayed
     * @return boolean
     */
    public boolean isTheLogoPresent(){
        getDriver().switchTo().frame("disneyid-iframe");
        explicitWait(logoIframe, 40);
        log.info("We are in the Iframe, because the Logo is displayed");
        waitElementVisibility(this.logoIframe);
        return this.logoIframe.isDisplayed();
    }

    /**
     * Click on Username field and fill it
     * @param pEmail
     */
    public void fillEmail(String pEmail){
        clickOnElement(this.email);
        typeOnElement(email, pEmail);
    }

    /**
     * Click on Password field and fill it
     * @param pPassword
     */
    public void fillPassword(String pPassword){
        clickOnElement(this.password);
        typeOnElement(password, pPassword);
    }

    /**
     * Click on Login button
     */
    public void clickOnLoginButton(){
        clickOnElement(this.loginButton);
    }

    /**
     * Login in The Espn page
     *@param pEmail, pPassword
     */
    public void loginEspnPage(String pEmail, String pPassword){
        log.info("Login");
        fillEmail(pEmail);
        fillPassword(pPassword);
        clickOnLoginButton();
    }

    /**
     * Verify if the Main page is displayed after the Login
     * @return boolean
     */
    public boolean isTheMainPageDisplayed(){
        switchToMainPage();
        log.info("This is the Main Page");
        waitElementVisibility(this.logoMainPage);
        explicitWait(logoMainPage, 30);
        return this.logoMainPage.isDisplayed();
    }

    /**
     * Click on Sign Up button and switch to it
     */
    public SignUpPage clickOnSignUpButton(){
        explicitWait(signUpButton, 50);
        clickOnElement(this.signUpButton);
        getDriver().switchTo().activeElement();
        return new SignUpPage(getDriver());
    }

    /**
     * Switch to parent window
     *
     */
    public void switchToMainPage(){
        getDriver().switchTo().defaultContent();
    }

    /**
     * Wait until element to be invisible.
     *
     */
    public void iframeInvisible(){
        explicitElementInvisible(iFrame, 50);
    }

}
