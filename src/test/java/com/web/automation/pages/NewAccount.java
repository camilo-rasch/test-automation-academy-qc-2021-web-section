package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void signUpData() {
        dataKeys(this.firstNameText,"Fabio");
        dataKeys(this.lastNameText,"Alarcon");
        dataKeys(this.emailText,"testing4581@aol.com");
        dataKeys(this.passwordText,"13a1efhGRB");
    }

    //testing4577@aol.com
    // testing4577@aol.com
    // testing4575@aol.com
    // testing4574@aol.com
    //testing4573@aol.com
    // testing4572@aol.com
    // testing4571@aol.com
    //testing4570@aol.com
    //testing4568@aol.com
    //testing4566@aol.com
    //testing4565@aol.com
    //testing4564@aol.com
    //testing4563@aol.com
    //testing4562@aol.com
    //testing4561@aol.com
    //testing1239@aol.com
    //testing1237@aol.com
    //testing1236@aol.com
    //testing1235@aol.com
    //holatesting4573@aol.com
    //testing4863@aol.com
    //testing4631@aol.com
    //testing357@aol.com
    //testing753@aol.com
    //testing159@aol.com
    //testing951@aol.com
    //testing789@aol.com
    //testingchockbetead456@aol.com
    //13a1fghGRB

    public void clickToFinishRegistration(){
        clickOnElement(this.clickToFinishRegistration);
    }

    public boolean isCreateAccountTitleVisible (){
        waitElementVisibility(this.visibilityOfTitle);
        return this.visibilityOfTitle.isDisplayed();
    }



}
