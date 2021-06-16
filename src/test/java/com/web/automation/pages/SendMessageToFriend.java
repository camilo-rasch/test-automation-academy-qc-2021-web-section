package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendMessageToFriend  extends BasePage{

    @FindBy (css = "li div[data-visualcompletion] a[href=\"https://www.facebook.com/friends/\"]")
    private WebElement optionFriendsLeftMenu;

    @FindBy (css = "div a[href=\"/friends/list/\"]")
    private WebElement allMyFriendsOption;

    @FindBy (css = "div a[role=\"link\"] div div svg mask[id=\"jsc_c_2qe\"]")
    private WebElement pictureFriendOnTheList;

    @FindBy (css = "div div[class=\"k4urcfbm\"] img[src=\"https://static.xx.fbcdn.net/rsrc.php/v3/yg/r/111xWLHJ_6m.png\"]")
    private WebElement buttonSendMessage;
    
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public SendMessageToFriend(WebDriver pDriver) {
        super(pDriver);
    }
}
