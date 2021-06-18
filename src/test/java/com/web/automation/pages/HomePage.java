package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "input[type='text']")
    private WebElement customerIdField;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "form[onsubmit=\"return confirm('Do you really want to delete this Customer?');\"]")
    private WebElement customerIdForm;

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
     * wait element to be visible
     * @param element WebElement
     */
    public void waitElementVisibility(WebElement element){getWait().until(ExpectedConditions.visibilityOf(element));}

    /**
     * click on element
     * @param element
     */
    public void clickOnElement(WebElement element){
        waitElementVisibility(element);
        element.click();
    }

    /**
     * Capture an alert
     * @param customerId
     */
    public void capturingAlerts(String customerId){
        clickOnElement(this.customerIdField);
        this.customerIdField.sendKeys(customerId);
        clickOnElement(this.submitButton);
        driver.switchTo().alert();
    }

    /**
     * Capture an alert message
     */
    public void capturingAlertMessages(){
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(alert.getText());
        alert.accept();
        Assert.assertTrue(customerIdForm.isDisplayed());

    }

}
