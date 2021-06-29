package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for login user page.
 * @author harvey.yepes
 */
public class LoginPage extends BasePage {
    /**
     * Locators of the login page
     */
    @FindBy(css  = "span input[type=\"email\"]")
    private WebElement emailTextBox;

    @FindBy(css  = "span [type=\"password\"]")
    private WebElement passwordTextBox;

    @FindBy(css  = "button[type=\"submit\"]")
    private WebElement loginsubmitButton;

    @FindBy(css = "a.btn-secondary")
    private WebElement signupButton;

    private String mainPageHandle = "";

    /**
     * Constructor
     * @param pDriver
     */
    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }


    /**
     * Method to log in
     */
    public void loginUser(){
        //fill the form and click on the Log In button
        switchToFrame();
        //wait while the new frame is displayed
        waitForVisibilityOf(this.emailTextBox);
        this.emailTextBox.sendKeys("josue@correo.com");
        this.passwordTextBox.sendKeys("portugalcr7");
        this.loginsubmitButton.click();
    }


    /**
     * Method to switch to signup a user
     * @return driver to Signup page
     */
    public SignupPage signupUser(){
        //fill the form and click on the Sign Up button
        switchToFrame();
        clickOnElement(signupButton);
        return new SignupPage(getDriver());
    }
}
