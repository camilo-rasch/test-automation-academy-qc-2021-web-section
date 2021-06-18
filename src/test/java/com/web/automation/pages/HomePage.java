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

    public void deleteCustomer(String customer){


        clickOnElement(getCustomerIdField());
        getCustomerIdField().sendKeys(customer);
        log.info("entering customerId: "+customer);
        clickOnElement(getSubmitButton());
        log.info("click on submit button");
        Alert alert= getDriver().switchTo().alert();
        log.info("switch to alert");
        log.info("printing in console the alert text");
        log.info(alert.getText());
        alert.accept();
        log.info("Accept in alert button");
        log.info("print alert response");
        log.info(alert.getText());
        alert.accept();
        log.info("Accept on the alert");
        Assert.assertTrue(getCustomerIdField().isDisplayed(),"The home page loaded as expected");



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





}
