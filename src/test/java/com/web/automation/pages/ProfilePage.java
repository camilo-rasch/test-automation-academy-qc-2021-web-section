package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    //goFriendsList
    @FindBy(css = "a[href='https://www.facebook.com/profile.php?id=100069071001305&sk=friends']")
    private WebElement friendsLabelButton;

    //FriendProfile
    @FindBy(css = "a[href='https://www.facebook.com/juanpa0108bookface']")
    private WebElement friendsList;

    //MessageButton
    @FindBy(xpath="//div[@role='button' and @aria-label='Mensaje']")
    private WebElement friendsProfileButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ProfilePage(WebDriver pDriver) {
        super(pDriver);
    }
}
