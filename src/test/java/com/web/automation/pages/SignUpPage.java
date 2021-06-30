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
public class SignUpPage extends BasePage {











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

    /**
     * Constructor.
     * @param driver WebDriver
     *
     */
    public SignUpPage(WebDriver driver) {
        super(driver);

    }

    /**
     * Getter for First Name Field
     * @return WebElement
     */
    public WebElement getFirstNameField() {
        return firstNameField;
    }

    /**
     * Getter for Last Name field
     * @return WebElement
     */
    public WebElement getLastNameField() {
        return lastNameField;
    }

    /**
     * Getter for Email field
     * @return WebElement
     */
    public WebElement getEmailField() {
        return emailField;
    }

    /**
     * Getter for New Password Field
     * @return WebElement
     */
    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    /**
     * Getter new Sign Up Button
     * @return WebElement
     */
    public WebElement getNewSignUpButton() {
        return newSignUpButton;
    }

    /**
     * Method to fill out the account creation form
      * @param firstName String
     * @param lastname String
     * @param newEmail String
     * @param newPassword String
     */
    public void createUser(String firstName,String lastname, String newEmail, String newPassword){

        waitElementVisibility(getFirstNameField());

        getFirstNameField().sendKeys(firstName);

        getLastNameField().sendKeys(lastname);
        getEmailField().sendKeys(newEmail);
        getNewPasswordField().sendKeys(newPassword);

    }

    /**
     * Method to switch to the AccountPage by clickin in the SignUp Button
     * @return AccountPage object
     */
    public AccountPage clickOnNewSignInButton(){
        clickOnElement(getNewSignUpButton());

        return new AccountPage(getDriver());
    }
















}
