package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendsFacebookPage extends BasePage{

    @FindBy (css = "div[role='tablist'] div a[href='https://www.facebook.com/norma.losada1/friends']")
    private WebElement friendsOption;

    @FindBy (css = "div[data-pagelet='ProfileAppSection_0'] div.lhclo0ds i")
    private WebElement friendsList;

    @FindBy (css = "div[data-pagelet='ProfileAppSection_0']  div.lhclo0ds > div:first-child img[referrerpolicy='origin-when-cross-origin']")
    private WebElement selectFriend;

    @FindBy (css = ".k4urcfbm div[aria-label='Mensaje']")
    private WebElement sendMessageButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FriendsFacebookPage(WebDriver pDriver) {
        super(pDriver);
    }

}
