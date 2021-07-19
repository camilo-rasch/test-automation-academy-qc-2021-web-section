package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.*;

/**
 * Methods to work the results of the search
 * @author fabio.alarcon
 */
public class ResultsSearchFlight extends BasePage{

    @FindBy(css = "select[data-test-id=\"sortDropdown\"]")
    private WebElement boxToOrder;

    @FindBy(css = "span[class=\"uitk-lockup-price\"]")
    private List<WebElement> flightPrice;

    @FindBy(css = "[data-test-id=\"journey-duration\"]")
    private List<WebElement> flightDuration;

    @FindBy(css = "div[data-test-id=\"flight-operated\"]")
    private List<WebElement> flightAirline;

    @FindBy(css = "div[data-test-id=\"arrival-departure\"]")
    private List<WebElement> flightRoute;

    @FindBy(css = "button[aria-label*=\"Show details\"]")
    private WebElement flightDetail;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultsSearchFlight(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Confirm if dropdown button is displayed
     * @return boolean
     */
    public boolean confirmationOfOrderButton(){
        waitElementVisibility(this.boxToOrder);
        return this.boxToOrder.isDisplayed();
    }

    /**
     * Confirm if the webpage display the flight prices
     * @return boolean
     */
    public boolean confirmationFlightPriceInResults(){
        return !this.flightPrice.isEmpty();
    }

    /**
     * Confirm if the webpage display the flight durations
     * @return boolean
     */
    public boolean confirmationOfFlightDuration(){
        return !this.flightDuration.isEmpty();
    }

    /**
     * Confirm if the webpage display the flight airlines
     * @return boolean
     */
    public boolean confirmationOfFlightAirline(){
        return !this.flightAirline.isEmpty();
    }

    /**
     * Confirm if the webpage display the fight routes
     * @return boolean
     */
    public boolean confirmationOfFlightRoute(){
        return !this.flightRoute.isEmpty();
    }

    /**
     * Sort flights
     * @param option String
     * @return boolean
     */
    public SelectingFlights selectSortBy(String option){
        dropDown(this.boxToOrder,option);
        return new SelectingFlights(getDriver());
    }
}