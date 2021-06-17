package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTubeIframe extends BasePage {
	
	/**
	 * Constructor
	 * @param pDriver
	 */

	public YouTubeIframe(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(css = "#movie_player div.ytp-cued-thumbnail-overlay > button")
	private WebElement playYouTubeVideoButton;
	
	public void clickOnPlayYouTubeButton() {
		
		clickOnElement(this.playYouTubeVideoButton);
	}

}
