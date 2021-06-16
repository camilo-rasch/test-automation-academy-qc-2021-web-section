package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement userName;

    @FindBy(css = "#pass")
    private WebElement password;

    @FindBy(css = "button[name=\"login\"]")
    private WebElement login_button;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }
}
