package com.web.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author camilo.mogollon
 * @modified By alejandro.giraldo
 */
public class BasePage {

    public Logger log = Logger.getLogger(BasePage.class);
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
     * Wait Implicit way.
     *
     * @param time int
     */
    public void waitImplicit(int time) {
        driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
    }

    /**
     * Wait element to be visible.
     *
     * @param elements list WebElement
     */
    public void waitElementsVisibility(List<WebElement> elements) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Click on Element waiting visibility
     * @param element to click
     */
    public void clickOnElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Click on Element waiting Clickeable
     * @param element to click
     */
    public void clickOnElementClickeable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
