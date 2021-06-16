package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookFriendProfilePage {
	
	public FacebookFriendProfilePage(WebDriver driver, String url) {
        super();
        driver.get(url);
    }
	
	@FindBy (css = "div[aria-label= \"Mensaje\"]")
	private WebElement friendMessage; 

}
