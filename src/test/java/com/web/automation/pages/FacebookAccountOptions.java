package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookAccountOptions {
	
	public FacebookAccountOptions(WebDriver driver, String url) {
        super();
        driver.get(url);
    }
	
	@FindBy(css = "By.css(div.a8nywdso.sj5x9vvc.rz4wbd8a.ecm0bbzt > div > div:nth-child(4))")
	private WebElement logOutButton;
	
	

}
