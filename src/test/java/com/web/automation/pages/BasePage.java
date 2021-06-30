package com.web.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author morma.losada
 */
public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	public Logger log = Logger.getLogger(BasePage.class);
	private HomePage homePage;
	
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
	public WebDriver getDriver() {
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
	 * Wait element to be visible. Explicit wait
	 * @param element, timeout
	 */
	public void explicitWait(WebElement element, int timeout){
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait element to be invisible. Explicit wait
	 * @param element, timeout
	 */
	public void explicitElementInvisible(WebElement element, int timeout){
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Click on a web element
	 * @param element
	 */
	public void clickOnElement(WebElement element){
		waitElementVisibility(element);
		element.click();
	}

    /**
     * Click type on a web element
     * @param element
     */
    public void typeOnElement(WebElement element, String text){
        waitElementVisibility(element);
        element.sendKeys(text);
    }

	/**
	 * Reload page
	 * @param url
	 */
	public void reload(String url){
		this.driver.get(url);
	}

	/**
	 * Close page
	 */
	public void closePage(){
		this.driver.close();
	}

}
