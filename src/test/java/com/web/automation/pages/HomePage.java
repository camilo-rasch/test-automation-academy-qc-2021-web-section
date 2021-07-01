package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Class for interact with the home page.
 * @author juandaniel.castano
 */

public class HomePage extends BasePage {

    /**
     * Define WebElements
     */

    @FindBy(css = "button[class=\"button med\"]")
    private WebElement signUpButton;

    @FindBy(css = "iframe[id=\"disneyid-iframe\"]")
    private WebElement disneyIFrame;

    @FindBy(css = "a[tref=\"/members/v3_1/login\"]")
    private WebElement signInButton;

    @FindBy(css = "a[id=\"global-user-trigger\"]")
    private WebElement accountButton;

    @FindBy(css = "a[class=\"small\"]")
    private WebElement logOutButton;

    @FindBy(css = "a[tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement espnProfileButton;

    @FindBy(css = "#did-ui button[id=\"close\"]")
    private WebElement closeButtonValidation;

    @FindBy(css = "h2[class=\"feed-title favorites\"]")
    private WebElement favoriteList;

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
     * Method to create a new SignUp object
     * @return new SignUp object
     */

    public SignUp clickOnSignUpButton(){
        if(!signUpButton.isDisplayed()){
            getDriver().navigate().refresh();
            clickOnElement(this.signUpButton);
        }
        clickOnElement(this.signUpButton);
        getDriver().switchTo().frame(disneyIFrame);
        return new SignUp(getDriver());
    }

    /**
     * Method to create a new SignIn object
     * @return new SignIn object
     */

    public SignIn clickOnSignInButton(){
        clickOnElement(this.signInButton);
        getDriver().switchTo().frame(disneyIFrame);
        return new SignIn(getDriver());
    }

    /**
     * Method to click on account button
     */

    public void clickOnAccountButton(){
        clickOnElement(this.accountButton);
    }

    /**
     * Method to click on logOut button
     */

    public void clickOnLogOutButton(){
        clickOnElement(this.logOutButton);
        getDriver().navigate().refresh();
    }

    /**
     * Method to click on edit profile button
     */

    public Profile clickOnESPNProfileButton(){
        clickOnElement(this.espnProfileButton);
        getDriver().switchTo().frame(disneyIFrame);
        return new Profile(getDriver());
    }

    /**
     * Method to validate the current URL
     * @return boolean value
     */

    public boolean expectedWePageIsDisplayed(){
        String espnURL = "https://www.espn.com/?src=com&_adblock=true";
        return espnURL.equalsIgnoreCase(getDriver().getCurrentUrl());
    }

    /**
     * Method to validate the required data is entered
     * @return boolean value
     */

    public boolean closeButtonIsDisplayed(){
        return closeButtonValidation.getAttribute("aria-hidden").contains("false");
    }

    /**
     * Method to validate if required WebElement is displayed
     * @return boolean value
     */

    public boolean favoriteListIsDisplayed(){
        return favoriteList.isDisplayed();
    }

    /**
     * Method to validate if required WebElement is displayed
     * @return boolean value
     */

    public boolean validateLogInIsActive(){
        return signUpButton.isDisplayed();
    }


}
