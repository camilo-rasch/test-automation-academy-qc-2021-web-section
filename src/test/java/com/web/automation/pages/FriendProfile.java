package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendProfile {

    //Friend Picture profile from all friends list
    @FindBy(css = ".gfomwglr:nth-of-type(1) .oaz4zybt")
    private WebElement FriendPictureFromList;

    //Send Message button
    @FindBy(css = ".bkfpd7mw .s1i5eluu.tv7at329")
    private WebElement SendMessageButton;
}
