package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


/**
 * Class for interact with the flight confirmation page.
 * @author norma.losada
 */
public class FlightConfirmationPage extends BasePage{

    @FindBy(css = "div[data-test-id=\"price-summary\"]")
    private WebElement priceSummaryGrid;

    @FindBy(css = "button[data-test-id='goto-checkout-button']")
    private WebElement checkOutButton;

    @FindBy(css = "table[data-test-id=\"trip-total\"]")
    private WebElement totalPriceFlights;

    @FindBy(css = "div[data-test-id=\"flight-review-header\"] h2")
    private List<WebElement> departureAndDestinationInformation;

    @FindBy(css = "div[data-test-id=\"fare-summary\"] h3")
    private List<WebElement> fareInformation;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FlightConfirmationPage(WebDriver pDriver) {
        super(pDriver);
    }


    /**
     * Verify if price summary is displayed.
     * @return boolean
     */
    public boolean isPriceSummaryPresent(){
        waitElementVisibility(this.priceSummaryGrid);
        return this.priceSummaryGrid.isDisplayed();
    }

    /**
     * Verify if total price is displayed.
     * @return boolean
     */
    public boolean isTotalPricePresent(){
        waitElementVisibility(this.totalPriceFlights);
        return this.totalPriceFlights.isDisplayed();
    }

    /**
     *Verify if the Departure and Destination is displayed for both flights
     *@return boolean
     */
    public boolean isTheDepartureAndDestinationDisplayed() {
        waitElementsVisibility(departureAndDestinationInformation);
        int DepartureAndDestinationList = departureAndDestinationInformation.size();
        boolean isPresent = false;
        int count = 0;
        for (int i = 0; i < DepartureAndDestinationList; i++) {
            count++;
        } if (count == DepartureAndDestinationList) {
            isPresent = true;
        }else{
            isPresent = false;
        }
        System.out.println("Departure and destination: " + count);
        System.out.println(DepartureAndDestinationList);
        System.out.println(isPresent);
        return isPresent;
    }

    /**
     *Verify if the fare is economy for both flights
     *@return boolean
     */
    public boolean isTheSelectedFareEconomy() {
        waitElementsVisibility(fareInformation);
        int fare = fareInformation.size();
        boolean isEconomy = false;
        for (int i = 0; i < fare; i++) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(fareInformation.get(i));
            actions.perform();
            waitElementVisibility(fareInformation.get(i));
            if (fareInformation.get(i).getText().contains("Economy")) {
                isEconomy = true;
            } else {
                isEconomy = false;
            }
        }
        System.out.println(fare);
        System.out.println(isEconomy);
        return isEconomy;
    }

    /**
     * Click on Continue button
     * @return CustomerPaymentPage
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
