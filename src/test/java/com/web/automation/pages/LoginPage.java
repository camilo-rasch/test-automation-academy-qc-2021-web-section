package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='session[username_or_email]'")
    private WebElement username;

    @FindBy(name = "session[password]")
    private WebElement password;

    @FindBy(css = "div[data-testid='LoginForm_Login_Button']")
    private WebElement login_button;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        waitElementVisibility(this.username);
        this.username.sendKeys(email);

        waitElementVisibility(this.password);
        this.password.sendKeys(password);

        getWait().until(ExpectedConditions.elementToBeClickable(this.login_button));
        this.login_button.click();


    }
}
