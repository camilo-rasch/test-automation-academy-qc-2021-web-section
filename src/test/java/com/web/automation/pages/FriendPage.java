package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement email_label;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public FriendPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
}
