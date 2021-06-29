package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public void logInData(){
        dataKeys(this.logInEmail,"testing4581@aol.com");
        dataKeys(this.logInPassword,"13a1efhGRB");
    }

    public void clickToLogInWithCredentials(){
        clickOnElement(this.clickToLogIn);
    }

    public boolean isTheDriverInTheRightIframe (){
        waitElementVisibility(this.buttonToConfirmTheIframe);
        return this.buttonToConfirmTheIframe.isDisplayed();
    }


}