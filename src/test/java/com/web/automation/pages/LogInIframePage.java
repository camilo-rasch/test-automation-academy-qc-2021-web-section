package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author Jonathan.Triana
 */
public class LogInIframePage extends BasePage{

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
    public LogInIframePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public LogInIframePage(WebDriver driver) {
        super(driver);
    }
    /**
     * Method to switch to log in Iframe
     */
    public LogInIframePage switchToIframeLogIn() {
        getDriver().switchTo().frame("disneyid-iframe");
        return new LogInIframePage(getDriver());
    }
    /**
     * Method to click on email field
     */
    public LogInIframePage clickEmailField() {
        clickOnElement(email);
        return new LogInIframePage(getDriver());
    }
    /**
     * Method to input the email
     */
    public LogInIframePage inputEmail() {
        this.email.sendKeys("Userespn@espnespnespn.com");
        return new LogInIframePage(getDriver());
    }
    /**
     * Method to click on password field
     */
    public HomePage clickPasswordField() {
        clickOnElement(password);
        return new HomePage(getDriver());
    }
    /**
     * Method to input the password
     */
    public HomePage inputPassword() {
        this.password.sendKeys("User123");
        return new HomePage(getDriver());
    }
    /**
     * Method to click on Log In button
     */
    public HomePage clickSubmitButton() {
        clickOnElement(submit);
        return new HomePage(getDriver());
    }
    /**
     * Method to click on Log Out button
     */
    public HomePage clickOnLogOut() {
        clickOnElement(logOut);
        return new HomePage(getDriver());
    }
}
