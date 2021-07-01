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


    //Login Button
    @FindBy(css="button.btn.btn-primary.btn-submit.ng-isolate-scope")
    private WebElement logInButton;

    //User Name Input
    @FindBy(css="input[type='email']")
    private WebElement userNameInput;

    //User Pass Input
    @FindBy(css="input[type='password']")
    private WebElement userPassInput;



    /**
     * Fills user name input
     */
    public void userNameSendKeys(){
        userNameInput.click();
        userNameInput.sendKeys("algiraldo888@gmail.com");
    }

    /**
     * Fills user Pass input
     */
    public void userPassSendKeys(){

        userPassInput.click();
        userPassInput.sendKeys("Losangeles1020");

    }

    /**
     * Click on login Button
     */
    public void clickOnLoginButton(){

        this.clickOnElement(logInButton);

    }
}
