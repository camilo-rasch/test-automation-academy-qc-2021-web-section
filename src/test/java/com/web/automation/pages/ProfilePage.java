package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the profile page.
 * @author jonathan.triana
 */
public class ProfilePage extends BasePage {

    // Friends option
    @FindBy(css = "div.soycq5t1.l9j0dhe7 div:nth-child(1) a:nth-child(4)")
    private WebElement friend_button;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public ProfilePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
}
