package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VimeoIframe extends BasePage {
	
	@FindBy(css = "#player > div.vp-controls-wrapper > div.vp-controls > button")
	private WebElement vimeoPlayButton;
	
	@FindBy(css = "[aria-valuetext*=\"04\"]")
	private WebElement vimeoVideoProgressBar;

	/**
	 * constructor
	 * @param pDriver
	 */
	public VimeoIframe(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * Click on play Vimeo video
	 */
	public void clickOnPlayVimeoButton() {
		
		waitElementVisibility(vimeoPlayButton);
		clickOnElement(this.vimeoPlayButton);
	}
	
	/**
	 * Get progress bar attributes
	 * @return
	 */
	public String getProgressBarAttributes() {
		
		waitElementVisibility(vimeoVideoProgressBar);
		String VimeovideoProgress = vimeoVideoProgressBar.getAttribute("aria-valuenow").toString();
		return VimeovideoProgress;
	}
	
	/**
     * Switch to default content
     */
    public void switchToDefaultContent() {
    	
    	getDriver().switchTo().defaultContent();
    	
    }
	
	

}
