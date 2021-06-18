package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

/**
 * Class for interact with the home page.
 * @author juancarlos.ortiz
 */
public class HomePage extends BasePage {

    @FindBy(css = "input[name='cusid']")
    private WebElement customerIdField;

    @FindBy(css = "input[name='submit']")
    private WebElement submitButton;

    public WebElement getCustomerIdField() {
        return this.customerIdField;
    }

    public WebElement getSubmitButton() {
        return this.submitButton;
    }




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
     * Method to switch to alert
     * @return the switch to the alert
     */
    public Alert switchToAlert() {
        return getDriver().switchTo().alert();
    }





}
