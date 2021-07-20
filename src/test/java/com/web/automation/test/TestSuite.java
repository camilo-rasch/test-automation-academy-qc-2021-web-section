package com.web.automation.test;

import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest{

    private HomePage homePage;

    @Test(description = "Search for a flight from LAS to LAX in Travelocity", priority = 0)
    public void searchAFlight(){
        homePage = getHomePage();
        log.info("Searching flight");
        homePage.selectOriginDestinationAndTravelers("LAS", "LAX",2);
        log.info("Select 2 adults in the travelers link");
        Assert.assertEquals(homePage.confirmTravelersSelected(),"2 Adults travelers selected","You must select 2 adults travelers");
        log.info("Select the travel dates in the calendar, departing within 2 months and returning 10 days later.");
        ResultsSearchFlight resultsSearchFlight = homePage.searchFlight(2,10);
        log.info("There is a combobox that allows you to order by: ");
        Assert.assertTrue(resultsSearchFlight.sortDropdownIsDisplayed(),"The combobox is not displayed");
        Assert.assertNotNull(resultsSearchFlight.optionsToSortDropdown(),"The combobox is null");
        log.info("The flight price is present on every result.");
        Assert.assertTrue(resultsSearchFlight.flightPriceIsPresentOnEveryResult(), "Missing at least one flight price");
        log.info("Flight duration is present on every result.");
        Assert.assertTrue(resultsSearchFlight.flightDurationIsPresentOnEveryResult(), "Missing at least one flight duration");
        log.info("Flight airline and flight route (Departure and Destination) are present on\n" +
                "every result.");
        Assert.assertTrue(resultsSearchFlight.airlineAndRouteArePresentOnEveryResult(), "Missing at least one flight airline or route");

        log.info("Select a flight from flights result list by Airline");
        resultsSearchFlight.selectAFlightByAirlineLambda("Air France");
        log.info("Assert departure time matches on emergent window");
        Assert.assertTrue(resultsSearchFlight.departureTimeMatchesFromSelectedFlight(),"Assert departure time matches");
        log.info("Click on continue button");
        resultsSearchFlight.clickOnContinueButton();
        log.info("Click on no thanks link");
        FlightConfirmationPage flightConfirmationPage = resultsSearchFlight.clickOnNoThanksLink();
        log.info("Assert CheckOut button is displayed");
        Assert.assertTrue(flightConfirmationPage.isCheckOutButtonPresent(), "Assert CheckOut button is displayed");
        log.info("Click on CheckOut button");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        log.info("Select by index on Customer title Select");
        customerPaymentPage.selectOptionInCustomerTitleSelectByIndex(2);
    }
}

