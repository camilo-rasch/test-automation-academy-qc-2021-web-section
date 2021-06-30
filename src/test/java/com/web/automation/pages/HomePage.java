package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class for interact with the home page.
 * @author juancarlos.ortiz
 */
public class HomePage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement globalUserButton;

    @FindBy(css = "a[tref=\"/members/v3_1/login\"]")
    private WebElement logInButton;

    @FindBy (css = "button[tref=\"/members/v3_1/login\"]")
    private WebElement externalLogInButton;


    /**
     * Constructor.
     *
     * @param driver WebDriver
     * @param url    String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Getter for GlobalUserButton
     *
     * @return WebElement
     */
    public WebElement getGlobalUserButton() {
        return globalUserButton;
    }


    /**
     * Getter for Log In button
     * @return WebElement
     */
    public WebElement getLogInButton() {
        return logInButton;
    }

    /**
     * Getter for External Log In Button
     * @return WebElement
     */
    public WebElement getExternalLogInButton() {
        return externalLogInButton;
    }


    /**
     * Method to switch to Log in iframe
     * @return
     */
    public LogInPage clickOnLoginButton(){


        clickOnElement(getLogInButton());
        getDriver().switchTo().frame("disneyid-iframe");
        return new LogInPage(getDriver());
    }

    public void clickOnglobalButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getWait().until(ExpectedConditions.elementToBeClickable(getGlobalUserButton()));
        getGlobalUserButton().click();
    }

    /**
     * Method to External Log In button visibility
     * @return
     */
    public boolean assertLogOut(){
        waitElementVisibility(getLogInButton());
        return getLogInButton().isDisplayed();
    }










}
