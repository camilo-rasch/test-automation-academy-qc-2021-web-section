package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginModal extends BasePage {

    @FindBy(css = "[placeholder ='Username or Email Address']")
    private WebElement username;

    @FindBy(css = "[placeholder ='Password (case sensitive)']")
    private WebElement password;

    @FindBy(css = "[class ='section section-primary'] [type ='submit']")
    private WebElement loginButton;

    @FindBy(css = "[class='section section-primary'] div:nth-child(6) a")
    private WebElement signUpButton;


    public LoginModal(WebDriver driver) {
        super(driver);
    }


    /**
     * Click on the Sign up button
     * @return new CreateAccountModal
     */
    public CreateAccountModal clickOnSignUpButton(){
     waitElementVisibility(signUpButton);
     signUpButton.click();
     return new CreateAccountModal(getDriver());
    }


    /**
     * Method Login is implemented.
     * @param email String
     * @param password String
     */
    public HomePage loginAccount(String email, String password) {
        waitElementVisibility(username);
        username.sendKeys(email);

        waitElementVisibility(this.password);
        this.password.sendKeys(password);

        clickOnElement(loginButton);

        return new HomePage(getDriver());
    }

}
