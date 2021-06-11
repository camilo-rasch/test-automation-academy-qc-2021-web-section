package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='session[username_or_email]'")
    private WebElement username;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String email) {
        // Missing Wait or method
        username.sendKeys(email);
    }
}
