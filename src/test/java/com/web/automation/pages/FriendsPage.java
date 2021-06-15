package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendsPage {

    //My Friends option tab
    @FindBy(xpath = "[data-pagelet='ProfileTabs'] .kr520xx4 .j1lvzwm4:nth-child(7)")
    private WebElement myFriendsTab;
}
