package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookTopBarNavigation {
	
	public FacebookTopBarNavigation(WebDriver driver, String url) {
        super();
        driver.get(url);
    }
	
	@FindBy(css = "g[mask='url(#jsc_c_m)'] > image")
	private WebElement userProfile;
	
	@FindBy(css = "div[aria-label*=\\\"Cuenta\\\"]")
	private WebElement userAccountButton;

}
