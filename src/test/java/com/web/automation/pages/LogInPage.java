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
     * Page Constructor
     * @param driver to execute
     */
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to click on the email field
     */
    public LogInPage clickEmailField() {
        clickOnElement(email);
        return new LogInPage(getDriver());
    }
    /**
     * Method to input the email
     */
    public LogInPage inputEmail() {
        this.email.sendKeys("Userespn@espnespnespn.com");
        return new LogInPage(getDriver());
    }
    /**
     * Method to click on the password field
     */
    public LogInPage clickPasswordField() {
        clickOnElement(password);
        return new LogInPage(getDriver());
    }
    /**
     * Method to input the password
     */
    public LogInPage inputPassword() {
        this.password.sendKeys("User123");
        return new LogInPage(getDriver());
    }
    /**
     * Method to click on the Log In button
     */
    public LogInPage clickSubmitButton() {
        clickOnElement(submit);
        return new LogInPage(getDriver());
    }
    /**
     * Method to click on the Log Out button
     */
    public LogInPage clickOnLogOut() {
        clickOnElement(logOut);
        return new LogInPage(getDriver());
    }
}
