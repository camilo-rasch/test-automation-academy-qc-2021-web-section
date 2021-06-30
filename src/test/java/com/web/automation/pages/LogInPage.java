package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Class with the locators and methods to log in a user.
 * @author Jonathan.Triana
 */
public class LogInPage extends BasePage{

    //Locator to find the email field
    @FindBy(css = "[type='email']")
    private WebElement email;

    //Locator to find the password field
    @FindBy(css = "[type='password']")
    private WebElement password;

    //Locator to find the submit button
    @FindBy(css = "[type='submit']")
    private WebElement submit;

    //Locator to find the Log Out option
    @FindBy(css = "div.global-user:nth-child(2) div.global-user-container ul.account-management li:nth-child(9) > a.small")
    private WebElement logOut;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public LogInPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Method to click on the email field
     */
    public void clickEmailField() {
        clickOnElement(email);
    }
    /**
     * Method to input the email
     */
    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }
    /**
     * Method to click on the password field
     */
    public void clickPasswordField() {
        clickOnElement(password);
    }
    /**
     * Method to input the password
     */
    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }
    /**
     * Method to click on the Log In button
     */
    public void clickSubmitButton() {
        clickOnElement(submit);
    }
    /**
     * Method to click on the Log Out button
     */
    public void clickOnLogOut() {
        clickOnElement(logOut);
    }
}
