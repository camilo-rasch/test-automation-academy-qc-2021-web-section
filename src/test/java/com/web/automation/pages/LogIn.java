package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Login methods
 * @author fabio.alarcon
 */

public class LogIn extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LogIn(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "input[type=\"email\"]")
    private WebElement logInEmail;

    @FindBy(css = "input[type=\"password\"]")
    private WebElement logInPassword;

    @FindBy(css = "button[ng-click=\"vm.submitLogin()\"]")
    private WebElement clickToLogIn;

    @FindBy(css = "a[did-translate=\"login.NEED_HELP\"]")
    private WebElement buttonToConfirmTheIframe;

    @FindBy(css = "#disneyid-iframe")
    private WebElement iframe;

    /**
     * Method to send keys (credentials) in order to login
     * @param logInEmail email of the account created
     * @param logInPassword password of the account created
     */
    public void logInData(String logInEmail, String logInPassword){
        dataKeys(this.logInEmail,logInEmail);
        dataKeys(this.logInPassword,logInPassword);
    }

    /**
     * Method to click on the button to login
     */
    public void clickToLogInWithCredentials(){
        clickOnElement(this.clickToLogIn);
    }

    /**
     * Check that the driver is in the right place
     * @return the location of the driver
     */
    public boolean isTheDriverInTheRightIframe (){
        waitElementVisibility(this.buttonToConfirmTheIframe);
        return this.buttonToConfirmTheIframe.isDisplayed();
    }
}