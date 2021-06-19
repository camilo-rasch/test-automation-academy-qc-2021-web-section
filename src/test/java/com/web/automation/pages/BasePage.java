package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent of the other classes of pages.
 * @author camilo.mogollon
 */
public class BasePage {

	private final WebDriver driver;
	private final WebDriverWait wait;

	/**
	 * Constructor.
	 *
	 * @param pDriver WebDriver
	 */
	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 20);
		driver = pDriver;
	}

	/**
	 * Get the web driver wait.
	 *
	 * @return {@link WebDriverWait}
	 */
	protected WebDriverWait getWait() {
		return wait;
	}

	/**
	 * Get the  web driver.
	 *
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
	 *
	 * @param element WebElement
	 */
	public void waitElementVisibility(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Click on Element
	 * @param element to click
	 */
	public void clickOnElement(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
