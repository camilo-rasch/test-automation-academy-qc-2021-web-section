package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfileFacebook  extends BasePage{

    @FindBy (css = "By.css(a[href='/me/'])")
    private WebElement myProfileButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public MyProfileFacebook(WebDriver pDriver) {
        super(pDriver);
    }
}
