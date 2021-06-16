package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookMyProfile extends BasePage {

    @FindBy(css = "a[href*=\"profile.php\"]")
    private WebElement profileOption;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FacebookMyProfile(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }
}
