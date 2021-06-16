package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfile {

    //My Friends option tab
    @FindBy(css = "[role='tab']:nth-child(4) [data-visualcompletion]")
    private WebElement myFriendsTab;

    //My List of friends
    @FindBy(xpath = "//DIV[@class='j83agx80 btwxx1t3 lhclo0ds i1fnvgqd']")
    private WebElement myFriendsList;

    //My friend profile icon Jhon Cuervo from Friends list
    //span[@class and @style]
    @FindBy(css = "[href='https://www.facebook.com/johnf.cuervo'][aria-hidden]>span")
    private WebElement myFriendProfileIconFromList;

}
