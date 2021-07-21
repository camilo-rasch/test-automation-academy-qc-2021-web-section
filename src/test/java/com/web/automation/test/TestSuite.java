package com.web.automation.test;

import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest{

    private HomePage homePage;

    @Test(description = "Search for a flight from LAS to LAX in Travelocity\n" +
            "Selecting Flight and roundtrip. Select 2 adults in the travelers link", priority = 0)
    public void selectRoundtripAndTravelers() {
        homePage = getHomePage();
        System.out.println("*********************************************************************************************************************");
        log.info("1. Search for a flight from LAS to LAX. Selecting Flight and roundtrip");
        System.out.println("*********************************************************************************************************************");
        homePage.selectOriginDestinationAndTravelers("LAS", "LAX", 2);
        System.out.println("*********************************************************************************************************************");
        log.info("Select 2 adults in the travelers link");
        Assert.assertEquals(homePage.confirmTravelersSelected(), "2 Adults travelers selected", "You must select 2 adults travelers");
        System.out.println("*********************************************************************************************************************");
    }

    @Test(description = "Dates should be at least two months in the future and\n" +
            "MUST be selected using the datepicker calendar", priority = 1)
    public void searchAFlight(){
        log.info("Select the travel dates in the calendar, departing within 2 months and returning 10 days later.");
        ResultsSearchFlight resultsSearchFlight = homePage.searchFlight(2,10);
        System.out.println("*********************************************************************************************************************");
        log.info("2. Verify the result page using the following\n" +
                "                                        a. There is a combobox that allows you to order by: ");
        Assert.assertTrue(resultsSearchFlight.sortDropdownIsDisplayed(),"The combobox is not displayed");
        Assert.assertNotNull(resultsSearchFlight.optionsToSortDropdown(),"The combobox is null");
        System.out.println("*********************************************************************************************************************");
        log.info("b. The flight price is present on every result.");
        Assert.assertTrue(resultsSearchFlight.flightPriceIsPresentOnEveryResult(), "Missing at least one flight price");
        System.out.println("*********************************************************************************************************************");
        log.info("c. Flight duration is present on every result.");
        Assert.assertTrue(resultsSearchFlight.flightDurationIsPresentOnEveryResult(), "Missing at least one flight duration");
        System.out.println("*********************************************************************************************************************");
        log.info("d. Flight airline and flight route (Departure and Destination) are present on\n" +
                "every result.");
        Assert.assertTrue(resultsSearchFlight.airlineAndRouteArePresentOnEveryResult(), "Missing at least one flight airline or route");
        System.out.println("*********************************************************************************************************************");
        log.info("3. Sort by duration > shorter. The flight’s result list is correctly sorted");
        Assert.assertTrue(resultsSearchFlight.flightResultsListIsSortedByDurationShortest(2), "The list is not sorted by Duration (Shortest)");
        System.out.println("*********************************************************************************************************************");
        log.info("4. Select your departure to Los Angeles first flight result.");
        Assert.assertTrue(resultsSearchFlight.selectAFlightByIndex(0),"Departure Flight not found");
        Assert.assertTrue(resultsSearchFlight.departureTimeMatchesFromSelectedFlight(), "The times do not match, the flight is not the correct");
        log.info("Flight accepted");
        resultsSearchFlight.clickOnContinueButton();
        Assert.assertTrue(resultsSearchFlight.selectedDepartureFlightIsDisplayed(),"The departure flight has not been selected");
        System.out.println("*********************************************************************************************************************");
        log.info("5. Select your departure to Las Vegas third flight result");
        Assert.assertTrue(resultsSearchFlight.selectAFlightByIndex(2),"Departure Flight not found");
        Assert.assertTrue(resultsSearchFlight.departureTimeMatchesFromSelectedFlight(), "The times do not match, the flight is not the correct");
        log.info("Flight accepted");
        resultsSearchFlight.clickOnContinueButton();
        Assert.assertTrue(resultsSearchFlight.selectedReturningFlightIsDisplayed(),"The returning flight has not been selected");
        System.out.println("*********************************************************************************************************************");


        log.info("6. If a “Search for Hotels” card pops up, select “No thanks”.");
        FlightConfirmationPage flightConfirmationPage = resultsSearchFlight.clickOnNoThanksLink();
        System.out.println("*********************************************************************************************************************");
        log.info("7. Verify trip details in the new page, as follows:\n" +
                "                                         a. Trip total price is present.");
        Assert.assertTrue(flightConfirmationPage.isTripTotalPresent(),"The trip total is not displayed");
        System.out.println("*********************************************************************************************************************");
        log.info("b. Departure and Destination information is present.");
        log.info("Departure:" + flightConfirmationPage.isDeparturePresent());
        Assert.assertEquals(flightConfirmationPage.isDeparturePresent(),"Las Vegas to Los Angeles", "The " +
                "departure flight does not match");
        log.info("Destination:" + flightConfirmationPage.isDestinationPresent());
        Assert.assertEquals(flightConfirmationPage.isDestinationPresent(), "Los Angeles to Las Vegas", "The " +
                "returning flight does not match");
        System.out.println("*********************************************************************************************************************");
        log.info("c. Selected Fare is Economy.");
        log.info("Departure fare is: " + flightConfirmationPage.departureFareIsEconomy());
        Assert.assertEquals(flightConfirmationPage.departureFareIsEconomy(), "Economy", "The selected fare " +
                "is not \"Economy\"");
        log.info("Returning fare is: " + flightConfirmationPage.returningFareIsEconomy());
        Assert.assertEquals(flightConfirmationPage.returningFareIsEconomy(), "Economy", "The selected fare " +
                "is not \"Economy\"");
        System.out.println("*********************************************************************************************************************");
        log.info("8. Press the “Check out” button.");
        log.info("Assert CheckOut button is displayed");
        Assert.assertTrue(flightConfirmationPage.isCheckOutButtonPresent(), "The CheckOut button is not displayed");
        System.out.println("*********************************************************************************************************************");
        log.info("Click on CheckOut button");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        System.out.println("*********************************************************************************************************************");

    }

}


