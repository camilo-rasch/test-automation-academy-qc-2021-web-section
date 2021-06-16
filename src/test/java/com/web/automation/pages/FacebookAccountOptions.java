package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookAccountOptions extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FacebookAccountOptions(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }

    @FindBy(css = "div[aria-label=\"\\\"Cuenta\\\"\"] > i")
    private WebElement accountButton;

    @FindBy(css = "div[aria-label =\"\\\"Cuenta\\\"\"] div:nth-child(4) div:nth-child(2)")
    private WebElement logoutButton;

}
