package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountIframe extends BasePage{
	
	@FindBy(name = "firstName")
	private WebElement firstNameField;
	
	@FindBy(name = "lastName")
	private WebElement lastNameField;
	
	@FindBy(name = "email")
	private WebElement emailField;
	
	@FindBy(name = "newPassword")
	private WebElement newPasswordField;
	
	@FindBy(css = "button[ng-if=\"!vm.isSetPassword()\"]")
	private WebElement signUpButton;

	/**
	 * Constructor
	 * @param pDriver
	 */
	public CreateAccountIframe(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * Click on First Name Field
	 */
	public void clickOnfirstNameField() {
		
		clickOnElement(firstNameField);
	}
	
	/**
	 * Send keys to First Name field
	 * @param keysToSend
	 */
	public void sendKeysfirstNameField(String keysToSend) {
		
		sendKeysField(firstNameField, keysToSend);
	}
	
	/**
	 * Click on Last Name Field
	 */
	public void clickOnlastNameField() {
		
		clickOnElement(lastNameField);
	}
	
	/**
	 * Send keys to last Name field
	 * @param keysToSend
	 */
	public void sendKeyslastNameField(String keysToSend) {
		
		sendKeysField(lastNameField, keysToSend);
	}
	
	/**
	 * Click on Email Field
	 */
	public void clickOnEmailField() {
		
		clickOnElement(emailField);
	}
	
	/**
	 * Send keys to Email field
	 * @param keysToSend
	 */
	public void sendKeysEmailField(String keysToSend) {
		
		sendKeysField(emailField, keysToSend);
	}
	
	/**
	 * Click on Password Field
	 */
	public void clickOnPasswordField() {
		
		clickOnElement(newPasswordField);
	}
	
	/**
	 * Send keys to Password field
	 * @param keysToSend
	 */
	public void sendKeysPasswordField(String keysToSend) {
		
		sendKeysField(newPasswordField, keysToSend);
	}
	
	/**
	 * Click on Sign Up Button
	 */
	public void clickOnSignUpButton() {
		
		clickOnElement(signUpButton);
	}
	
	/**
     * Switch to default content
     */
    public void switchToDefaultContent() {
    	
    	getDriver().switchTo().defaultContent();
    	
    }	

}
