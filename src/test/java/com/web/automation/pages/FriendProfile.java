package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendProfile {

    //Send Message button
    @FindBy(css = "[aria-label='Message']")
    private WebElement SendMessageButton;

}
