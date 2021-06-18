package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author jessica.cardona
 */
public class HomePage extends BasePage {
	
	@FindBy(css = "input[name=\"cusid\"]")
	private WebElement customerIdField;
	
	@FindBy(css = "input[name=\"submit\"]")
	private WebElement submitButton;

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
     * Click on Customer ID field
     */
    public void clickOnCustomerIdField() {
    	
    	clickOnElement(customerIdField);    	
    }
    
    /**
     * Send user on Customer ID Field
     * @param data
     */
    public void sendkeysCustomerIdField(String data) {
    	
    	sendKeysOnElement(customerIdField, data);
    }
    
    /**
     * Click on Submit button
     */
    public void clickOnSubmitButton() {
    	
    	clickOnElement(submitButton);    	
    }
    
    /**
     * Switch to browser Alert
     * @return 
     */
    public Alert switchToAlert(){
    	
    	return getDriver().switchTo().alert();
    	
    }
        
    /**
     * Verify if CustomerID field is displayed
     * @return boolean
     */
    public boolean isCustomerIdFieldDisplayed(){
        waitElementVisibility(this.customerIdField);
        return this.customerIdField.isDisplayed();
    }
}
