package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Class with the locator and methods to create an account.
 * @author Jonathan.Triana
 */
public class CreateUserPage extends BasePage {

    //Locator to find the sign up option
    @FindBy(css = "[ng-click='vm.createAccount()']")
    private WebElement signUp;

    //Locator to find the first name field
    @FindBy(name = "firstName")
    private WebElement firstName;

    //Locator to find the last name field
    @FindBy(name = "lastName")
    private WebElement lastName;

    //Locator to find the email field
    @FindBy(name = "email")
    private WebElement email;

    //Locator to find the password field
    @FindBy(css = "[type='password']")
    private WebElement password;

    //Locator to save the new user
    @FindBy(css = "button.btn.btn-primary.ng-scope.ng-isolate-scope")
    private WebElement signup;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public CreateUserPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to click on the sign up option
     */
    public CreateUserPage clickOnSignUp() {
        clickOnElement(signUp);
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to click on the first name field
     */
    public CreateUserPage clickOnFirstNameField() {
        clickOnElement(firstName);
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to input the first name
     */
    public CreateUserPage inputOnFirstNameField() {
        this.firstName.sendKeys("Jonathan");
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to click on the last name field
     */
    public CreateUserPage clickOnLastNameField() {
        clickOnElement(lastName);
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to input the last name
     */
    public CreateUserPage inputOnLastNameField() {
        this.lastName.sendKeys("Test");
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to click on the email field
     */
    public CreateUserPage clickOnEmailField() {
        clickOnElement(email);
        return new CreateUserPage(getDriver());
    }
    /**
     * Method input the random email using the time
     */
    public CreateUserPage inputOnEmailField() {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HHmmss", Locale.ENGLISH));
        String randomEmail="jonathantest"+time+"email"+"@mail.com";
        this.email.sendKeys(randomEmail);
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to click on the password field
     */
    public CreateUserPage clickOnPasswordField() {
        clickOnElement(password);
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to input the password
     */
    public CreateUserPage inputOnPasswordField() {
        this.password.sendKeys("Pss_845");
        return new CreateUserPage(getDriver());
    }
    /**
     * Method to click on sign up button
     */
    public CreateUserPage clickOnSignUpButton() {
        clickOnElement(signup);
        return new CreateUserPage(getDriver());
    }
}