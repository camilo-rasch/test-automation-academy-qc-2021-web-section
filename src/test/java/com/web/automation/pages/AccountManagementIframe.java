package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountManagementIframe extends BasePage {

	@FindBy(id = "cancel-account")
	private WebElement deleteAccount;
	
	@FindBy(css = ".field-group > section[class *= \"cancel-account\"]")
	private WebElement sectionCancelAccountIframe;
	
	/**
	 * Constructor
	 * @param pDriver
	 */
	public AccountManagementIframe(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * Click on Delete Account option
	 */
	public void clickOnDeleteAccountOption() {
		
		clickOnElement(deleteAccount);
	}
	
	/**
     * Switch to default content
     */
    public void switchToDefaultContent() {
    	
    	getDriver().switchTo().defaultContent();
    	
    }	
    
    /**
     * Scroll Bottom iframe to obtain delete account button
     */
    public void scrollToBottomIframe() {
    	
    	scrollDownPages(sectionCancelAccountIframe);
    }
  
}
