package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
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

    //CREATE A NEW ACCOUNT

    @FindBy(css = "button[class=\"button med\"]")
    private WebElement signUpButton;

    public NewAccount clickToSignUp(){
        clickOnElement(this.signUpButton);
        getDriver().switchTo().frame(1);
        return new NewAccount(getDriver());
    }

    //LOG IN

    @FindBy(css = "a[id=\"global-user-trigger\"]")
    private WebElement bannerGeneral;

    @FindBy(css = "a[data-affiliatename=\"espn\"]")
    private WebElement logInbutton;


    public void clickOnGeneralBanner(){
        clickOnElement(this.bannerGeneral);
    }

    public LogIn clickToLogInbutton(){
        try {
            clickOnElement(this.logInbutton);
        }catch (org.openqa.selenium.StaleElementReferenceException ex){
            clickOnElement(this.logInbutton);
        }
        getDriver().switchTo().frame(this.iframe);
        return new LogIn(getDriver());
    }

    public boolean confirmationOfTheAccount (){
        clickOnElement(this.bannerGeneral);
        waitElementVisibility(this.bannerProfileOption);
        return this.bannerProfileOption.isDisplayed();
    }


    //LOG OUT

    @FindBy(css = "a[class=\"small\"]")
    private WebElement buttonLogOut;

    public void clickToSignOut(){
        clickOnElement(this.buttonLogOut);
        //waitElementInvisibility(this.buttonLogOut);
    }

    public boolean confirmationOfTheLogOut (){
        waitElementVisibility(this.signUpButton);
        return this.signUpButton.isDisplayed();
    }

    //CANCEL ACCOUNT.
    @FindBy(css = "a[tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement bannerProfileOption;

    public CancelAccount clickToProfile(){
        clickOnElement(this.bannerProfileOption);
        getDriver().switchTo().frame(this.iframe);
        return new CancelAccount(getDriver());
    }

}
