package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    //SignUp new user Button
    @FindBy(css="button[tref='/members/v5_0/register']")
    private WebElement registerButton;

    //Uer Options label
    @FindBy(css="#global-user-trigger")
    private WebElement userOptions;

    //Login Label
    @FindBy(css="a[tref='/members/v3_1/login']")
    private WebElement loginLabel;

    //Login status label
    @FindBy(css="li.display-user")
    private WebElement loginStatusLabel;

    //LogOut Button
    @FindBy(css="a[onclick^='javascript:espn.member']")
    private WebElement logOutButton;

    //Profile Button
    @FindBy(css="a[tref='/members/v3_1/modifyAccount']")
    private WebElement profileButton;

    //cancel account Link
    @FindBy(css="#cancel-account")
    private WebElement cancelAccountLink;

    //confirm Delete Button
    @FindBy(css="button.btn.btn-primary.ng-isolate-scope")
    private WebElement confirmDeleteButton;

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
     * Hover to profile label
     */

    public void selectUserOptionsLabel(){
        this.waitImplicit(5);
        Actions act= new Actions(this.getDriver());
        act.moveToElement(userOptions).perform();

    }

    /**
     * ClickOn Login Label
     */
    public void clickOnLoginLabel(){
        this.waitImplicit(1);
        this.clickOnElement(loginLabel);
    }
    /**
     * ClickOn LogOut Label
     */
    public void clickOnLogOutLabel(){
        this.waitImplicit(1);
        this.clickOnElement(logOutButton);
    }
    /**
     * ClickOn Profile Label
     */
    public void clickOnProfileLabel(){
        this.waitImplicit(1);
        this.clickOnElement(profileButton);
    }
    /**
     * ClickOn Delete Account label
     */
    public void clickOnDeleteAccount(){
        this.waitImplicit(1);
        this.clickOnElement(cancelAccountLink);
    }

    /**
     * ClickOn confirmDeleteAccount
     */
    public void clickOnConfirmDeleteAccount(){
        this.waitImplicit(1);
        this.clickOnElement(confirmDeleteButton);
    }
    /**
     * Change to Iframe
     */
    public WebDriver changeToIframe() {
            return getDriver().switchTo().frame("disneyid-iframe");
    }

    /**
     * Change Home Focus
     */
    public WebDriver changeToHomeFocus() {
        return getDriver().switchTo().defaultContent();
    }

    /**
     * Verifies if user name is displayed
     */
    public boolean isUserNameDisplayed(){
        this.waitImplicit(2);
        this.waitElementVisibility(loginStatusLabel);

        if(loginStatusLabel.getText().contains("Aleja")){
            return true;
        }
        else return false;
    }
    /**
     * Verifies label deleted account
     */
    public boolean isLabelDeletedAccountDisplayed(){
        this.waitImplicit(2);
        this.waitElementVisibility(loginStatusLabel);

        if(loginStatusLabel.getText().contains("account has been dele")){
            return true;
        }
        else return false;
    }

    /**
     * click on register Button
     */
    public void clickOnRegisterButton(){
        this.waitImplicit(1);
        this.clickOnElement(registerButton);
    }

}
