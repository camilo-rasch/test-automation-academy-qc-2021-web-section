package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    /**
     * Locators of the ESPN Home Page
     */
    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;

    @FindBy(css = ".account-management a[data-affiliatename=\"espn\"]")
    private WebElement loginButton;

    @FindBy(css = ".display-user span")
    private WebElement usernameLabel;

    @FindBy(css = ".small")
    private WebElement logoutButton;

    @FindBy(css= "#sideLogin-left-rail .button-alt")
    private WebElement leftLoginButton;

    @FindBy(css= "a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfile;


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
     * Method to switch to the class to login a user
     * @return driver to Login page
     */
    public LoginPage loginUser(){
        clickOnElement(this.userIcon);
        loginButton.click();
        return new LoginPage(getDriver());
    }

    /**
     * Method to switch to the class to delete the account
     * @return driver to delete account
     */
    public DeleteAccount deleteAccount(){
        clickOnElement(this.espnProfile);
        return new DeleteAccount(getDriver());
    }

    /**
     * Get the user name to assert the user logged in
     * @return username
     */
    public boolean validateUserLogin(){
        try {
            Thread.sleep(6000);
            this.userIcon.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.usernameLabel.isDisplayed();
    }

    /**
     * Method to click in the logout user button
     */
    public void logoutUser(){
        clickOnElement(this.userIcon);
        logoutButton.click();
    }

    /**
     * Method to assert the user is logout
     * @return login button is displayed
     */
    public boolean validateUserLogout(){
        //wait.until(ExpectedConditions.visibilityOf(this.userIcon));
        waitForVisibilityOf(this.leftLoginButton);
        return this.leftLoginButton.isDisplayed();
    }


}
