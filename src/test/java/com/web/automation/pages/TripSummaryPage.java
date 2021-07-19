package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class for interact with the trip summary page.
 *
 */
public class TripSummaryPage extends BasePage{

    @FindBy(css = "tbody[class=\"uitk-table-foot\"] span")
    private WebElement tripTotalPrice;

    @FindBy(css = "div[data-test-id=\"flight-review-0\"]")
    private WebElement departureInfo;

    @FindBy(css = "div[data-test-id=\"flight-review-1\"]")
    private WebElement destinationInfo;

    @FindBy(css = "div[data-test-id=\"fare-summary\"] h3")
    private WebElement fareSummary;

    @FindBy(css = "button[data-test-id=\"goto-checkout-button\"]")
    private WebElement checkOutButton;


    /**
     * Constructor.
     * @param pDriver WebDriver
     */
    public TripSummaryPage(WebDriver pDriver) {
        super(pDriver);
    }


    /**
     * Verify if Total price is displayed
     *
     */
    public boolean isTripTotalPriceDisplayed() {
        waitElementVisibility(tripTotalPrice);
        return tripTotalPrice.isDisplayed();
    }

    /**
     * Verify if departure information is displayed
     *
     */
    public boolean isDepartureInfoDisplayed() {
        waitElementVisibility(departureInfo);
        return departureInfo.isDisplayed();
    }

    /**
     * Verify if destination information is displayed
     *
     */
    public boolean isDestinationInfoDisplayed() {
        waitElementVisibility(destinationInfo);
        return destinationInfo.isDisplayed();
    }

    /**
     * Get the text of the fareSummary element
     * @return fare
     */
    public String getFareEconomy() {
        waitElementVisibility(fareSummary);
        String fare = fareSummary.getText();
        return fare;
    }

    /**
     * Get the text of the fareSummary element
     * @return PassengerInfoPage
     */
    public PassengerInfoPage clickOnCheckOutButton(){
        clickOnElement(checkOutButton);
        return new PassengerInfoPage(getDriver());
    }
}
