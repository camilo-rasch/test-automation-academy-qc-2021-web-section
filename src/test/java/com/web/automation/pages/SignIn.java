package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Parent of the other classes of test.
 * @author juandaniel.castano
 */

public class SignIn extends BasePage{

    /**
     * Define WebElements
     */

    @FindBy(css = ".field-group input[type=\"email\"]")
    private WebElement emailField;

    @FindBy(css = ".field-group input[type=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = "button[class=\"btn btn-primary btn-submit ng-isolate-scope\"]")
    private WebElement signInButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public SignIn(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Method to send data to desired WebElement
     * @param emailUser To received emailUser value from User object
     * @param passwordUser To received passwordUser value from User object
     */

    public void sendData(String emailUser, String passwordUser) {
        sendDataOnElement(this.emailField, emailUser);
        sendDataOnElement(this.passwordField, passwordUser);
    }

    /**
     * Method to click on desired WebElement
     */

    public void clickOnSignInButton() {
        clickOnElement(this.signInButton);
    }

    /**
     * Method to validate WebElement is displayed
     * @return Boolean value
     */

    public boolean signInWindowIsDisplayed(){
        return emailField.isDisplayed();
    }

    /**
     * Method to validate the value of specific attribute
     * @return Boolean value
     */

    public boolean dataEnteredValidation(){
        return passwordField.getAttribute("aria-required").contains("false");
    }
}
