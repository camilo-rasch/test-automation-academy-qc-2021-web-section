package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPopUpOptions extends BasePage{
	
	@FindBy(css = "ul.account-management > li:nth-child(7) > a")
	private WebElement logInOption;
	
	@FindBy(css = ".user li:nth-child(5) a")
	private WebElement espnProfileOption;
	
	@FindBy(css = ".user li:nth-child(9) a")
	private WebElement logOutOption;
	
	@FindBy(css = "ul.account-management > li.display-user > span")
	private WebElement userNameProfile;
	
	/**
	 * Constructor
	 * @param pDriver
	 */
	public UserPopUpOptions(WebDriver pDriver) {
		super(pDriver);
	}
	
	 /**
     * Click on Login option
     */
    public void clickLogInOption() {
    	waitElementClickable(logInOption);
    	clickOnElement(this.logInOption);
    }
    
    /**
     * Click on ESPN profile options
     */
    public void clickEspnProfileOption() {
    	waitElementClickable(espnProfileOption);
    	clickOnElement(this.espnProfileOption);
    }
    
    /**
     * Click on Logout option
     */
    public void clickLogOutOption() {
    	waitElementClickable(logOutOption);
    	clickOnElement(this.logOutOption);
    }
	
    /**
     * Switch driver control to Main Window
     * @return
     */
    public void switchToMainWindow() {
    	
    	getDriver().switchTo().window(getMainWindow());
    }
    
    /**
     * Get user profile name
     * @return
     */
    public String getUserProfileName() {
    	
    	String userName= userNameProfile.getText();
    	return userName;
    }
    
     /**
      * validate the visibility of login button
      * @return
      */
    public boolean displayLogInButton() {
    	
    	return logInOption.isDisplayed();
    	
    }
    
}
