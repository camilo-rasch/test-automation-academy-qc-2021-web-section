package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTubeIframe extends BasePage {
	
	@FindBy(css = "#movie_player div.ytp-cued-thumbnail-overlay > button")
	private WebElement playYouTubeVideoButton;
	
	@FindBy(css = "div[aria-valuetext*=\"5 Minutes\"]")
	private WebElement videoProgressBar;
	
	/**
	 * Constructor
	 * @param pDriver
	 */

	public YouTubeIframe(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * Click on play youtube video
	 */
	public void clickOnPlayYouTubeButton() {
		
		waitElementVisibility(playYouTubeVideoButton);
		clickOnElement(this.playYouTubeVideoButton);
	}
	
	public String getProgressBarAttributes() {
		
		waitElementVisibility(videoProgressBar);
		String videoProgress = videoProgressBar.getAttribute("aria-valuenow").toString();
		return videoProgress;
	}
	
	/**
     * Switch to default content
     */
    public void switchToDefaultContent() {
    	
    	getDriver().switchTo().defaultContent();
    	
    }

}
