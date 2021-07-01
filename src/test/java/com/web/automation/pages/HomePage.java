package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Class to start test methods
 * @author fabio.alarcon
 */
public class HomePage extends BasePage {

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    @FindBy(css = "#disneyid-iframe")
    private WebElement iframe;

    @FindBy(css = "button[class=\"button med\"]")
    private WebElement signUpButton;

    @FindBy(css = "a[id=\"global-user-trigger\"]")
    private WebElement bannerGeneral;

    @FindBy(css = "a[data-affiliatename=\"espn\"]")
    private WebElement logInbutton;

    @FindBy(css = "a[class=\"small\"]")
    private WebElement buttonLogOut;

    @FindBy(css = "a[tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement bannerProfileOption;

    //CREATE A NEW ACCOUNT
    /**
     * Method to click on the sign up button
     * @return
     */
    public NewAccount clickToSignUp(){
        clickOnElement(this.signUpButton);
        getDriver().switchTo().frame(this.iframe);
        return new NewAccount(getDriver());
    }

    //LOG IN
    /**
     * Method to open the hover
     */
    public void clickOnGeneralBanner(){
        clickOnElement(this.bannerGeneral);
    }

    /**
     * Method to click in LogIn button
     */
    public LogIn clickToLogInbutton(){
        try {
            clickOnElement(this.logInbutton);
        }catch (org.openqa.selenium.StaleElementReferenceException ex){
            clickOnElement(this.logInbutton);
        }
        getDriver().switchTo().frame(this.iframe);
        return new LogIn(getDriver());
    }

    /**
     * Method to confirm the profile button
     * @return Profile button available
     */
    public boolean confirmationOfTheAccount (){
        clickOnElement(this.bannerGeneral);
        waitElementVisibility(this.bannerProfileOption);
        return this.bannerProfileOption.isDisplayed();
    }


    //LOG OUT
    /**
     * Method to click on the logout button
     */
    public void clickToSignOut(){
        clickOnElement(this.buttonLogOut);
        getDriver().navigate().refresh();
    }

    /**
     * Method to confirm if the logout was success
     * @return
     */
    public boolean confirmationOfTheLogOut (){
        waitElementVisibility(this.signUpButton);
        return this.signUpButton.isDisplayed();
    }

    //CANCEL ACCOUNT.
    /**
     * Method to confirm if the account was successfully deactivated
     * @return {Driver into the frame}
     */
    public CancelAccount clickToProfile(){
        clickOnElement(this.bannerProfileOption);
        waitElementVisibility(this.iframe);
        getDriver().switchTo().frame(this.iframe);
        return new CancelAccount(getDriver());
    }
}