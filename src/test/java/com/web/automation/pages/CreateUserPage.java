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
     * Method to click on the sign up option
     */
    public void clickOnSignUp() {
        clickOnElement(signUp);
    }
    /**
     * Method to click on the first name field
     */
    public void clickOnFirstNameField() {
        clickOnElement(firstName);
    }
    /**
     * Method to input the first name
     */
    public void inputOnFirstNameField() {
        this.firstName.sendKeys("Jonathan");
    }
    /**
     * Method to click on the last name field
     */
    public void clickOnLastNameField() {
        clickOnElement(lastName);
    }
    /**
     * Method to input the last name
     */
    public void inputOnLastNameField() {
        this.lastName.sendKeys("Test");
    }
    /**
     * Method to click on the email field
     */
    public void clickOnEmailField() {
        clickOnElement(email);
    }
    /**
     * Method input the random email using the time
     */
    public void inputOnEmailField() {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HHmmss", Locale.ENGLISH));
        String randomEmail="jonathantest"+time+"email"+"@mail.com";
        this.email.sendKeys(randomEmail);
    }
    /**
     * Method to click on the password field
     */
    public void clickOnPasswordField() {
        clickOnElement(password);
    }
    /**
     * Method to input the password
     */
    public void inputOnPasswordField() {
        this.password.sendKeys("Pss_845");
    }
    /**
     * Method to click on sign up button
     */
    public void clickOnSignUpButton() {
        clickOnElement(signup);
    }
}