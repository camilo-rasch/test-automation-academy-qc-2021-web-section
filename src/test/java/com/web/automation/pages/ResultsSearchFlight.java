package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class ResultsSearchFlight extends BasePage{

    @FindBy(css = "select[data-test-id=\"sortDropdown\"]")
    private WebElement boxToOrder;

    @FindBy(css = "span[class=\"uitk-lockup-price\"]")
    private List<WebElement> flightPrice;

    @FindBy(css = "div[data-test-id=\"journey-duration\"]")
    private List<WebElement> flightDuration;

    @FindBy(css = "div[data-test-id=\"flight-operated\"]")
    private List<WebElement> flightAirline;

    @FindBy(css = "div[data-test-id=\"arrival-departure\"]")
    private List<WebElement> flightRoute;

    @FindBy(css = "button[aria-label*=\"Show details\"]")
    private WebElement flightDetail;


    //Hotel search Pop UP selectors
    @FindBy(css = "a[data-test-id='forcedChoiceNoThanks']")
    private WebElement noThanksLink;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultsSearchFlight(WebDriver pDriver) {
        super(pDriver);
    }

    public boolean confirmationOfOrderButton(){
        waitElementVisibility(this.boxToOrder);
        return this.boxToOrder.isDisplayed();
    }

    public boolean confirmationFlightPriceInResults(){
        return !this.flightPrice.isEmpty();
    }

    public boolean confirmationOfFlightDuration(){
        return !this.flightDuration.isEmpty();
    }

    public boolean confirmationOfFlightAirline(){
        return !this.flightAirline.isEmpty();
    }
//Combino los 2 methods?
    public boolean confirmationOfFlightRoute(){
        return !this.flightRoute.isEmpty();
    }


    public SelectingFlights selectSortBy(String option){
        dropDown(this.boxToOrder,option);
        return new SelectingFlights(getDriver());
    }

//    public boolean afterSort(){
//        getDriver().navigate().refresh();
//        waitElementsVisibility(this.flightDuration);
//        List<WebElement> orderAfter = this.flightDuration;
//
//        String previous = "";
//        for (WebElement current: orderAfter) {
//            if (current.compareTo(previous) < 0)
//                return false;
//            previous = current;ws
//        }
//        return false;
//    }

//        String previous = "";
//        for (final WebElement current: orderAfter) {
//            if (current.compareTo(previous) < 0)
//                return false;
//            previous = current;
//        }
//        return false;


//    public boolean checkTheFlightsTimeOrder(){
//        String previous = ""; // empty string
//
//        for (final String current: product_names) {
//            if (current.compareTo(previous) < 0)
//                return false;
//            previous = current;
//        }
//
//        return true;
//    }



}