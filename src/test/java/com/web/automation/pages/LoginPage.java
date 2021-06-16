package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    //FaceBookLogin
    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "pass")
    private WebElement inputPass;

    @FindBy(id = "u_0_h_Pp")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        waitElementVisibility(this.inputEmail);
        this.inputEmail.sendKeys(email);

        waitElementVisibility(this.inputPass);
        this.inputPass.sendKeys(password);

        getWait().until(ExpectedConditions.elementToBeClickable(this.loginButton));
        this.loginButton.click();


    }
}
