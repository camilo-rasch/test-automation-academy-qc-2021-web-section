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




    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    public WebElement getNewSignUpButton() {
        return newSignUpButton;
    }





    /**
     * Constructor.
     * @param driver WebDriver
     *
     */
    public SignUpPage(WebDriver driver) {
        super(driver);

    }

    public void createUser(String firstName,String lastname, String newEmail, String newPassword){

        waitElementVisibility(getFirstNameField());

        getFirstNameField().sendKeys(firstName);

        getLastNameField().sendKeys(lastname);
        getEmailField().sendKeys(newEmail);
        getNewPasswordField().sendKeys(newPassword);

    }

    public AccountPage clickOnNewSignInButton(){
        clickOnElement(getNewSignUpButton());
        return new AccountPage(getDriver());
    }
















}
