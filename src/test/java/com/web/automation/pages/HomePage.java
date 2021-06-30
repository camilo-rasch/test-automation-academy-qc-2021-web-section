package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = "[class ='tools'] [id = 'global-user-trigger']")
    private WebElement userButton;

    @FindBy(css = "[class='user hover'] [tref *='login'] ")
    private WebElement loginButton;

    @FindBy(css = "[class ='tools focused'] [onclick *='logout']")
    private WebElement logoutButton;

    @FindBy(css = "[class='user hover'] ul li:nth-child(5) a")
    private WebElement espnProfileButton;

    @FindBy(css = "[class ='user hover'] [class ='button sm open-favs']")
    private WebElement addFavoritesButton;



    /**
     * Page Constructor with url
     * @param driver to execute
     * @param url    to get
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
     * Select the user button, The Actions class is used to interact with the button
     * @return
     */
    public void selectUserButton(){
        waitElementVisibility(userButton);
        Actions action = new Actions(getDriver());
        action.moveToElement(userButton).perform();
    }

    /**
     * Click on the login button
     * @return
     */
    public void clickOnLoginButton() {
        waitElementVisibility(loginButton);
        clickOnElement(loginButton);
    }

    /**
     * Click on the log out button
     * @return new HomePage
     */
    public HomePage logoutAccount(){
        waitElementVisibility(logoutButton);
        logoutButton.click();
        return new HomePage(getDriver());
    }

    /**
     * Click on the ESPN profile button
     * @return
     */
    public void clickOnEspnProfButton(){
        waitElementVisibility(espnProfileButton);
        espnProfileButton.click();
    }


    /**
     * Method to validate if espnProfileButton is displayed
     * @return espnProfileButton.isDisplayed()
     */
    public boolean isEspnProfileButtonDisplayed() {
      //  waitElementVisibility(espnProfileButton);
        return espnProfileButton.isDisplayed();
    }

    /**
     * Method to validate if loginButton is displayed
     * @return loginButton.isDisplayed()
     */
    public boolean isLoginButtonDisplayed() {
        waitElementVisibility(loginButton);
        return loginButton.isDisplayed();
    }

    /**
     * Method to validate if AddFavoriteButton is displayed
     * @return AddFavoriteButton.isDisplayed()
     */
    public boolean isAddFavoritesButtonDisplayed() {
        waitElementVisibility(addFavoritesButton);
        return addFavoritesButton.isDisplayed();
    }


    /**
     * Method to switch to Login Modal
     * @return new LoginModal
     */
    public LoginModal switchToLoginModal() {
        getDriver().switchTo().frame("disneyid-iframe");
        return new LoginModal(getDriver());
    }

    /**
     * Method to switch to DeleteAccount Modal
     * @return new DeleteAccountModal
     */
    public DeleteAccountModal switchToDeleteAccountModal() {
        getDriver().switchTo().frame("disneyid-iframe");
        return new DeleteAccountModal(getDriver());
    }

}
