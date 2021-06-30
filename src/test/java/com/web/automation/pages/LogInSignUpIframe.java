package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInSignUpIframe extends BasePage{
	
	@FindBy(css = "input[aria-label*=\"Username or Email\"]")
	private WebElement emailField;
	
	@FindBy(css = "input[placeholder*=\"Password\"]")
	private WebElement passwordField;
	
	@FindBy(css = "button[ng-click=\"vm.submitLogin()\"]")
	private WebElement loginButton;
	
	@FindBy(css = "a[ng-click=\"vm.createAccount()\"]")
	private WebElement signUpButton;
	
	/**
	 * Constructor
	 * @param pDriver
	 */
	public LogInSignUpIframe(WebDriver pDriver) {
		super(pDriver);
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
		
		waitElementClickable(passwordField);
		clickOnElement(passwordField);
	}
	
	/**
	 * Send keys to Password field
	 * @param keysToSend
	 */
	public void sendKeysPasswordField(String keysToSend) {
		
		sendKeysField(passwordField, keysToSend);
	}
	
	/**
	 * Click on Log In Button
	 */
	public void clickOnLogInButton() {
		
		clickOnElement(loginButton);
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
