package com.web.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author camilo.mogollon
 */
public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	public Logger log = Logger.getLogger(BasePage.class);
	
	/**
	 * Constructor.
	 * @param pDriver WebDriver
	 */
	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 20);
		driver = pDriver;

	}

	/**
	 * Get the web driver wait.
	 * @return {@link WebDriverWait}
	 */
	protected WebDriverWait getWait() {
		return wait;
	}

	/**
	 * Get the  web driver.
	 * @return {@link WebDriver}
	 */
	protected WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Close the web driver.
	 */
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Wait element to be visible.
	 * @param element WebElement
	 */
	public void waitElementVisibility(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait element to be visible.
	 * @param elements list WebElement
	 */
	public void waitElementsVisibility(List<WebElement> elements) {
		getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	/**
	 * Wait for element visibility and click on element
	 * @param element
	 */
	public void clickOnElement(WebElement element){
		waitElementVisibility(element);
		element.click();
	}
	
	/**
	 * Wait for element to be clickable 
	 * @param element
	 */
	public void waitElementClickable(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Get Main window handle
	 * @return
	 */
	public String getMainWindow() {
		
		return getDriver().getWindowHandle();

	}
	
	public void sendKeysField(WebElement element,String keysToSend) {
		
		element.sendKeys(keysToSend);
	}
	
	public void scrollDownPages() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
	}
	
}
