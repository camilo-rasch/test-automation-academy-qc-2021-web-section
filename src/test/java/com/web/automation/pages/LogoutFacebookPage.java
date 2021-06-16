package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutFacebookPage extends BasePage{

    @FindBy (css = "div[data-nocookies='true'] div[role ='button']")
    private WebElement logoutOption;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LogoutFacebookPage(WebDriver pDriver) {
        super(pDriver);
    }
}

