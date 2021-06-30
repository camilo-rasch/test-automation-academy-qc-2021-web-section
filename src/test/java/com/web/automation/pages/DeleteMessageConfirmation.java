package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteMessageConfirmation extends BasePage{

	@FindBy (css = "h2[did-translate*=\"messages.header\"]")
	private WebElement messageDeleteAccount;
	
	/**
	 * constructor
	 * @param pDriver
	 */
	public DeleteMessageConfirmation(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * Get Delete confirmation message
	 * @return
	 */
	public String getDeleteMessage() {
		
		waitElementVisibility(messageDeleteAccount);
		return messageDeleteAccount.getText();
	}
	
	/**
     * Switch to default content
     */
    public void switchToDefaultContent() {
    	
    	getDriver().switchTo().defaultContent();
    	
    }		

}
