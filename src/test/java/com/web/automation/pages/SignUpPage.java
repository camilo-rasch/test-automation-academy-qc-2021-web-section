package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage{

    @FindBy(css = "h2[did-translate='create.TITLE']")
    private WebElement createAccounTitle;

    @FindBy(css = "input[name='firstName']")
    private WebElement firstNameField;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastNameField;

    @FindBy(css = "input[name='email'")
    private WebElement emailField;

    @FindBy(css = "input[name='newPassword'")
    private WebElement passwordField;

    @FindBy(css = "button[class='btn btn-primary ng-scope ng-isolate-scope']")
    private WebElement signUpButton;

    @FindBy(css = "#did-ui-view")
    private WebElement signInModal;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public SignUpPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if the Create Account container is displayed
     * @return boolean
     */
    public boolean isTheSignUpDisplayed(){
        log.info("This is the Sign Up container");
        waitElementVisibility(this.createAccounTitle);
        return this.createAccounTitle.isDisplayed();
    }

    /**
     * Click on web elements and set the data
     * @param webElement, data
     */
    public void setInput(WebElement webElement, String data){
        clickOnElement(webElement);
        typeOnElement(webElement, data);
    }

    /**
     * Sign up The Espn page
     * @param pName, pLastName, pPassword
     *
     */
    public void signUpEspnPage( String pName, String pLastName, String pPassword){
        log.info("SignUp");
        setInput(this.firstNameField, pName);
        setInput(this.lastNameField, pLastName);
        setInput(this.emailField, createRandomEmail());
        setInput(this.passwordField, pPassword);
        clickOnElement(this.signUpButton);
    }

    /**
     * Create random email
     * @param
     *
     */
    public String createRandomEmail(){
        String email;
        int rand = (int)(Math.random() * ((3000 - 2000) + 1) + 2000);
        email = "norma@losada" + rand + ".com";
        return email;
    }
}
