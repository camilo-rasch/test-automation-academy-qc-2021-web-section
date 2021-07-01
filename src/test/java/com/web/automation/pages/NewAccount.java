package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Create new account methods
 * @author fabio.alarcon
 */
public class NewAccount extends BasePage{

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public NewAccount(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "input[name=\"firstName\"]")
    private WebElement firstNameText;

    @FindBy(css = "input[name=\"lastName\"]")
    private WebElement lastNameText;

    @FindBy(css = "input[name=\"email\"]")
    private WebElement emailText;

    @FindBy(css = "input[name=\"newPassword\"]")
    private WebElement passwordText;

    @FindBy(css = "button[ng-if=\"!vm.isSetPassword()\"]")
    private  WebElement clickToFinishRegistration;

    @FindBy(css = "h2[did-translate=\"create.TITLE\"]")
    private WebElement visibilityOfTitle;

    /**
     * Method to receive the data to create a new account
     * @param firstNameText
     * @param lastNameText
     * @param emailText
     * @param passwordText
     */
    public void signUpData(String firstNameText, String lastNameText, String emailText, String passwordText) {
        dataKeys(this.firstNameText,firstNameText);
        dataKeys(this.lastNameText,lastNameText);
        dataKeys(this.emailText,emailText);
        dataKeys(this.passwordText,passwordText);
    }

    /**
     * Method to conclude the registration
     */
    public void clickToFinishRegistration(){
        clickOnElement(this.clickToFinishRegistration);
    }

    /**
     * Method to validate that the account was successfully created
     * @return
     */
    public boolean isCreateAccountTitleVisible (){
        waitElementVisibility(this.visibilityOfTitle);
        return this.visibilityOfTitle.isDisplayed();
    }
}