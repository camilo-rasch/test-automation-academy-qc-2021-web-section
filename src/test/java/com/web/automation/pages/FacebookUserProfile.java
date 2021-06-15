package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookUserProfile {
	
	public FacebookUserProfile(WebDriver driver, String url) {
        super();
        driver.get(url);
    }
	
	@FindBy(css = "div div div a:nth-child(4) div.bp9cbjyn.rq0escxv.j83agx80.pfnyh3mw.frgo5egb.l9j0dhe7.cb02d2ww.hv4rvrfc.dati1w0a > span")
	private WebElement friendsButton;

}
