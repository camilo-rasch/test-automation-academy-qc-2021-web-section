package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static java.lang.Thread.sleep;

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

    //Locator to find the welcome message
    @FindBy(css = "#global-user-trigger~div>div>ul.account-management>li.display-user")
    private WebElement message;

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
     * Method to click on user icon
     */
    public void clickOnUserIcon() {
        waitElementVisibility(userIcon);
        clickOnElement(userIcon);
    }
    /**
     * Method to click on Log In option
     */
    public void clickOnLogIn() {
        clickOnElement(logIn);
    }
    /**
     * Method to confirm if the account was deleted
     */
    public String messageConfirmation() throws InterruptedException {
        waitElementVisibility(message);
        sleep(2000);
        String label_text = message.getText();
        return label_text;
    }
    /**
     * Method to switch to log in Iframe
     */
    public void switchToIframeLogIn() throws InterruptedException {
        getDriver().switchTo().frame("disneyid-iframe");
        sleep(1000);
    }
}