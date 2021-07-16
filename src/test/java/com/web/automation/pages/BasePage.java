package com.web.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author camilo.mogollon / fabio.alarcon
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
		wait = new WebDriverWait(pDriver, 30);
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
	 * Click on element with a wait
	 * @param element webElement
	 */
	public void clickOnElement(WebElement element){
		waitElementVisibility(element);
		element.click();
	}

	/**
	 * Select one option in a drop down
	 * @param webElement webElement
	 * @param option String
	 */
	public void dropDown(WebElement webElement, String option){
		waitElementVisibility(webElement);
		Select dropDown = new Select(webElement);
		dropDown.selectByVisibleText(option);
	}

	/**
	 * Input traveler basic information
	 * @param webElement webElement
	 * @param index integer
	 * @param infoText String
	 */
	public void travelerBasicInformation(List<WebElement> webElement, int index, String infoText){
		WebElement travelerInformation = webElement.get(index);
		travelerInformation.click();
		travelerInformation.sendKeys(infoText);
	}

}
