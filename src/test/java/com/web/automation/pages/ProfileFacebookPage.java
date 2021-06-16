package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileFacebookPage extends BasePage{

    @FindBy (css = ".buofh1pr:nth-child(1) li:nth-child(1) div a[href='https://www.facebook.com/norma.losada1']")
    private WebElement profileOption;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ProfileFacebookPage(WebDriver pDriver) {
        super(pDriver);
    }
}
