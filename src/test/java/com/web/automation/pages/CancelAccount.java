package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CancelAccount extends BasePage{

    HomePage homePage;
    LogIn logIn;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CancelAccount(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "a[id=\"cancel-account\"]")
    private WebElement deleteAccountButton;

    @FindBy(css = "button[ng-click=\"vm.confirm()\"]")
    private WebElement confirmDeleteAccount;

    @FindBy(css = "iframe[name=disneyid-iframe]")
    private WebElement iframeDelete;

    @FindBy(css = "button[ng-click=\"vm.close()\"]")
    private WebElement lastConfirmation;

//    @FindBy(css = "h2[class=\"title title-primary ng-isolate-scope\"]")
//    private WebElement accountDeleted;


    public void cancelAccount1(){
        try {
            clickOnElement(this.deleteAccountButton);
        }catch (org.openqa.selenium.StaleElementReferenceException ex){
            clickOnElement(this.deleteAccountButton);
        }
    }

    public void confirmCancelAccount(){
        clickOnElement(this.confirmDeleteAccount);
    }

    public void lastCancelConfirmation(){
        clickOnElement(this.lastConfirmation);
    }

    public boolean confirmationOfTheAccountDeactivated (){
        waitElementVisibility(this.iframeDelete);
        return this.iframeDelete.isDisplayed();
    }
}