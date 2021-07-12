package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightConfirmationPage extends BasePage{

    @FindBy(css = "button[data-test-id='goto-checkout-button']")
    private WebElement checkOutButton;

    @FindBy(css = "table[data-test-id='trip-total']")
    private WebElement tripTotal;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FlightConfirmationPage(WebDriver pDriver) {
        super(pDriver);
    }

    public boolean isCheckOutButtonPresent(){
        waitElementVisibility(this.checkOutButton);
        return this.checkOutButton.isDisplayed();
    }

    public CustomerPaymentPage clickOnCheckOutButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getWait().until(ExpectedConditions.elementToBeClickable(this.checkOutButton));
        this.checkOutButton.click();
        return new CustomerPaymentPage(getDriver());
    }
    public boolean isTripTotalPresent(){
        waitElementVisibility(this.tripTotal);
        return this.tripTotal.isDisplayed();
    }
}