package com.web.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookUserProfile_FriendsOptions {
	
	public FacebookUserProfile_FriendsOptions(WebDriver driver, String url) {
        super();
        driver.get(url);
    }
	
	 @FindBy(css = " div[data-pagelet = \"ProfileAppSection_0\"] div.sjgh65i0:nth-child(2) + div")
	 private List<WebElement> friendsList;

}
