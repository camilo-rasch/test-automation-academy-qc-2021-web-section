package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFacebookPage extends BasePage {

    @FindBy (css = "#email")
    private WebElement loginUsername;

    @FindBy (css = "#pass")
    private WebElement loginPassword;

    @FindBy (css = "#u_0_h_jV")
    private WebElement loginButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginFacebookPage(WebDriver pDriver, String url) {
        super(pDriver);
        getDriver().get(url);
    }
}
