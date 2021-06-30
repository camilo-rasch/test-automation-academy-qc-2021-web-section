package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmDeleteAccountIframe extends BasePage {

	@FindBy (css = "button[ng-click*=\"confirm\"]")
	private WebElement confirmDeleteAccount;
	
	/**
	 * constructor
	 * @param pDriver
	 */
	public ConfirmDeleteAccountIframe(WebDriver pDriver) {
		super(pDriver);
	}
	
	public void clickOnConfirmDeleteAccount() {
		
		waitElementClickable(confirmDeleteAccount);
		clickOnElement(confirmDeleteAccount);
	}
	
	/**
     * Switch to default content
     */
    public void switchToDefaultContent() {
    	
    	getDriver().switchTo().defaultContent();
    	
    }		

}
