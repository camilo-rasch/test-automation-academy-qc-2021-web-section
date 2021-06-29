package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author juancarlos.ortiz
 */
public class AccountPage extends BasePage {

    @FindBy (id = "global-user-trigger")
    private WebElement globalUserButton;

    @FindBy (css = "a[tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement espnProfileButton;

    @FindBy (css = "div[ng-if=\"vm.readOnlyEmailValue\"] > div > span.value span")
    private WebElement emailText;

    @FindBy (css = "button[type=\"submit\"]")
    private WebElement doneButton;

    @FindBy (id = "cancel-account")
    private WebElement deleteAccountButton;

    @FindBy (css = "button[ng-click=\"vm.confirm()\"]")
    private WebElement deleteConfirmationButton;



    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public AccountPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Method to switch to alert
     * @return the switch to the alert
     */

    public void playYouTube(){
        getDriver().switchTo().frame(0);
        clickOnElement();
    }

    public void playVimeo(){
        getDriver().switchTo().frame(1);
       
    }





}
