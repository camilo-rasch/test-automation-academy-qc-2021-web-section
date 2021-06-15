package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the friend profile.
 * @author jonathan.triana
 */
public class FriendProfile extends BasePage{

    //Message button
    @FindBy(css = "[data-pagelet='ProfileActions']>div>div>div:nth-child(2)")
    private WebElement message_button;

    //Field to send the message
    @FindBy(css = "[aria-label='Aa']")
    private WebElement message_field;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public FriendProfile(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
}
