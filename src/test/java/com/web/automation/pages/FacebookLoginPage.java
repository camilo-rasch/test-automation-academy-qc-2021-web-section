package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasePage {
	
	public FacebookLoginPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "pass")
	private WebElement password;
	
	@FindBy(id = "u_0_d_lm")
	private WebElement loginButton;

}
