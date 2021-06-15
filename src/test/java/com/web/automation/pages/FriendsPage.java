package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the friends page.
 * @author jonathan.triana
 */
public class FriendsPage extends BasePage {

    //Search friend field to input the friend that you want to send message
    @FindBy(css = ".aahdfvyu.buofh1pr ~div >div:nth-child(1)")
    private WebElement search_friend_field;

    // Select friend
    @FindBy(css = "[data-pagelet='ProfileAppSection_0']>div>div>div>div>div:nth-child(3)>div>div:nth-child(2")
    private WebElement select_friend;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public FriendsPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
}
