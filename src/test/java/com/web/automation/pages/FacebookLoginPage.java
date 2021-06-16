package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FacebookLoginPage extends BasePage{
        @FindBy(css = "input#email")
        private WebElement email;

        @FindBy(css = "input#pass")
        private WebElement password;

        @FindBy(css = "button[name='login']")
        private WebElement loginButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FacebookLoginPage(WebDriver pDriver,String url) {
        super(pDriver);
        pDriver.get(url);
    }
}
