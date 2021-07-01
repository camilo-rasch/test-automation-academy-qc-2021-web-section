package com.web.automation.pages;

import com.web.automation.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public RegisterPage(WebDriver pDriver) {
        super(pDriver);
    }

    // User First name Input
    @FindBy(css="input[name='firstName']")
    private WebElement userNameInput;

    // User last name Input
    @FindBy(css="input[name='lastName']")
    private WebElement lastNameInput;

    // User Email Input
    @FindBy(css="input[name='email']")
    private WebElement emailInput;

    // User Password Input
    @FindBy(css="input[name='newPassword']")
    private WebElement newPassInput;

    // Page confirm SignUp Button
    @FindBy(css="button.btn.btn-primary.ng-scope.ng-isolate-scope")
    private WebElement confirmRegisterButton;

    /**
     * Fills User Name Input
     */
    public void fillNameInput(){
        this.waitImplicit(2);
        userNameInput.click();
        userNameInput.sendKeys("Alejo");
    }

    /**
     * Fills User Last Name Input
     */
    public void fillLastNameInput(){
        this.waitImplicit(2);
        lastNameInput.click();
        lastNameInput.sendKeys("Giraldo");
    }

    /**
     * Fills User Email Input
     */
    public void fillEmailInput(){
        this.waitImplicit(2);
        emailInput.click();
        emailInput.sendKeys("99877@ddf.com");
    }

    /**
     * Fills User Password Input
     */
    public void fillPassInput(){
        this.waitImplicit(2);
        newPassInput.click();
        newPassInput.sendKeys("Losangeles1020");
    }

    /**
     * Clicks On Confirm Register
     */
    public void clickOnConfirmRegister(){
        this.waitImplicit(2);
        confirmRegisterButton.click();
    }


}
