package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightConfirmationPage extends BasePage{

    /**
     * locators
     */
    @FindBy(css = "button[data-test-id='goto-checkout-button']")
    private WebElement checkOutButton;

    @FindBy(css = "div[data-test-id=\"flight-review-0\"]")
    private WebElement departureFlightInformationCard;

    @FindBy(css = "div[data-test-id=\"flight-review-1\"]")
    private WebElement returningFlightInformationCard;

    @FindBy(css = "table[data-test-id=\"trip-total\"] span")
    private WebElement tripTotalPriceLabel;


    /**
     * String locators
     */
    private String routeInformation = "h2";
    private String fareLabel = "div[data-test-id=\"fare-summary\"] h3";
    private String priceSummaryCard = "div[data-test-id=\"price-summary-card\"]";



    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FlightConfirmationPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify Trip total price is present
     * @return boolean
     */
    public boolean isTripTotalPresent(){
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.priceSummaryCard)));
        waitElementVisibility(this.tripTotalPriceLabel);
        log.info("Trip total: " + this.tripTotalPriceLabel.getText());
        return this.tripTotalPriceLabel.isDisplayed();
    }


    /**
     * Verify Departure information is present
     * @return boolean
     */
    public String isDeparturePresent(){
        waitElementVisibility(this.departureFlightInformationCard);
        return this.departureFlightInformationCard.findElement(By.cssSelector(this.routeInformation)).getText();
    }


    /**
     * Verify Destination information is present
     * @return boolean
     */
    public String isDestinationPresent(){
        waitElementVisibility(this.returningFlightInformationCard);
        return this.returningFlightInformationCard.findElement(By.cssSelector(this.routeInformation)).getText();
    }


    /**
     * Verify Selected Fare is Economy for Departure flight
     * @return boolean
     */
    public String departureFareIsEconomy(){
        waitElementVisibility(this.departureFlightInformationCard);
        return this.departureFlightInformationCard.findElement(By.cssSelector(this.fareLabel)).getText();
    }

    /**
     * Verify Selected Fare is Economy for Returning flight
     * @return boolean
     */
    public String returningFareIsEconomy(){
        waitElementVisibility(this.returningFlightInformationCard);
        return this.returningFlightInformationCard.findElement(By.cssSelector(this.fareLabel)).getText();
    }


    /**
     * Verify Checkout button presence
     * @return boolean
     */
    public boolean isCheckOutButtonPresent(){
        waitElementVisibility(this.checkOutButton);
        return this.checkOutButton.isDisplayed();
    }

    /**
     * Method to click on Checkout button
     * @return driver
     */
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
}
