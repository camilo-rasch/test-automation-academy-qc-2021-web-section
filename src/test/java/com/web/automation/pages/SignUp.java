package com.web.automation.pages;
import com.web.automation.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Parent of the other classes of test.
 * @author juandaniel.castano
 */

public class SignUp extends BasePage{

    /**
     * Define WebElements
     */

    @FindBy(css = "input[name=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[name=\"lastName\"]")
    private WebElement lastNameField;

    @FindBy(css = "input[name=\"email\"]")
    private WebElement emailField;

    @FindBy(css = "input[name=\"newPassword\"]")
    private WebElement newPasswordField;

    @FindBy(css = "button[class=\"btn btn-primary ng-scope ng-isolate-scope\"]")
    private WebElement signUpButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */

    public SignUp(WebDriver pDriver) { super(pDriver); }

    /**
     * Method to send data to desired WebElement
     * @param userFirstName To received userFirstName value from User object
     * @param userLastName To received userLastName value from User object
     * @param userEmail To received emailUser value from User object
     * @param userNewPassword To received userNewPassword value from User object
     */

    public void sendData(String userFirstName, String userLastName, String userEmail, String userNewPassword) {
        sendDataOnElement(this.firstNameField, userFirstName);
        sendDataOnElement(this.lastNameField, userLastName);
        sendDataOnElement(this.emailField, userEmail);
        sendDataOnElement(this.newPasswordField, userNewPassword);
    }

    /**
     * Method to click on desired WebElement
     */

    public void clickOnSignUpButton() {
        clickOnElement(this.signUpButton);
    }

    /**
     * Method to validate the value of specific attribute
     * @return Boolean value
     */

    public boolean dataEnteredValidation(){
        return newPasswordField.getAttribute("aria-required").contains("false");
    }
}
