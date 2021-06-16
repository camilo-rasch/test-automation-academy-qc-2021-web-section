package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFacebook extends BasePage{
    @FindBy (id = "#email")
    private WebElement inputEmail;

    @FindBy (id = "#pass")
    private WebElement inputPassword;

    @FindBy (css = "button[data-testid='royal_login_button']")
    private WebElement buttonLogin;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginFacebook(WebDriver pDriver, String url) {
        super(pDriver);
        getDriver().get(url);
    }
}
