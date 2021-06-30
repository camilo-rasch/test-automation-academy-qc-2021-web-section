package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Class for interact with the home page.
 * @author jessica.cardona
 */
public class HomePage extends BasePage {
	
	@FindBy(id = "global-user-trigger")
	private WebElement globalUserButton;
	
		
    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    
    /**
     * Click on Global User button - top right navigation bar
     */
    public void clickGlobalUserButton() {
    	
    	clickOnElement(this.globalUserButton);
    	
    }
    
    /**
     * Wait until Global User Button be clickeable
     */
    public void waitGloberUserButton() {
    	
    	waitElementClickable(globalUserButton);
    }
       
    /**
     * Switch to user pop up options
     */
    public UserPopUpOptions switchToUserPopUpOptions() {
    	
    	String windowHandle= getDriver().getWindowHandle();
    	getDriver().switchTo().window(windowHandle);
    	return new UserPopUpOptions(getDriver());
    }
    
    /**
     * Switch to Log In or Sign Up Iframe
     */
    public LogInSignUpIframe switchToLogInSignUpIframe() {
    	
    	getDriver().switchTo().frame("disneyid-iframe");
    	return  new LogInSignUpIframe(getDriver());
    }
    
    /**
     * Switch to create account Iframe
     */
    public CreateAccountIframe switchToCreateAccountIframe() {
    	
    	getDriver().switchTo().frame("disneyid-iframe");
    	return  new CreateAccountIframe(getDriver());
    }
    
    /**
     * Switch to manage account Iframe
     */
    public AccountManagementIframe switchToAccountManagementIframe() {
    	
    	getDriver().switchTo().frame("disneyid-iframe");
    	return new AccountManagementIframe(getDriver());
    }
    
    /**
     * Switch to confirm delete account Iframe
     */
    public ConfirmDeleteAccountIframe switchToConfirmDeleteAccountIframe() {
    	
    	getDriver().switchTo().frame("disneyid-iframe");
    	return new ConfirmDeleteAccountIframe(getDriver());
    }
    
    /**
     * Switch to delete confirmation message Iframe
     */
    public DeleteMessageConfirmation switchToDeleteMessageConfirmationIframe() {
    	
    	getDriver().switchTo().frame("disneyid-iframe");
    	return new DeleteMessageConfirmation(getDriver());
    }
}
