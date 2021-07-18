package com.web.automation.test;

import com.web.automation.pages.CustomerPaymentPage;
import com.web.automation.pages.FlightConfirmationPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.ResultsSearchFlight;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest{

    private HomePage homePage;

    @Test(description = "Booking a flight in Travelocity")
    public void bookAFlight(){
        homePage = getHomePage();
        log.info("Searching flight");
        homePage.selectOriginAndDestination("LAS", "LAX");
        homePage.selectTravelers();
        ResultsSearchFlight resultsSearchFlight = homePage.searchFlight(15);
        log.info("Click on one stop checkbox");
        resultsSearchFlight.clickOnOneStopCheckBox();
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

