package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author Jonathan.Triana
 */
public class HomePage extends BasePage {

    //Locator to find the user icon
    @FindBy(css = "#global-user-trigger")
    private WebElement userIcon;

    //Locator to find the Log In option
    @FindBy(css = "div.global-user:nth-child(2) div.global-user-container ul.account-management li:nth-child(7) > a:nth-child(1)")
    private WebElement logIn;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }
    /**
     * Method to click on user icon
     */
    public HomePage clickOnUserIcon() {
        waitElementVisibility(userIcon);
        clickOnElement(userIcon);
        return new HomePage(getDriver());
    }
    /**
     * Method to click on Log In option
     */
    public HomePage clickOnLogIn() {
        clickOnElement(logIn);
        return new HomePage(getDriver());
    }
}