package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.jws.soap.SOAPBinding;

/**
 * Class for tests.
 * @author norma.losada
 */

public class TestSuite extends BaseTest{

    private HomePage homePage;

    @Test(description = "Booking a roundtrip flight in Travelocity", dataProviderClass = Data.class, dataProvider = "user")
    public void bookAFlight(User user){
        homePage = getHomePage();
        log.info("Searching flight");
        ResultsSearchFlight resultsSearchFlight = homePage.searchFlight("LAS","LAX", 52, 58);
        log.info("Sort by box is displayed");
        Assert.assertTrue(resultsSearchFlight.isTheSortBoxFlightsDisplayed(), "Sort by is displayed");
        log.info("Flight price is present on every result");
        Assert.assertTrue(resultsSearchFlight.isTheFlightPriceDisplayed(), "Flight price is displayed");
        log.info("Flight duration is present on every result");
        Assert.assertTrue(resultsSearchFlight.isTheFlightDurationDisplayed(), "Flight duration is displayed");
        log.info("Flight airline and route is present on every result");
        Assert.assertTrue(resultsSearchFlight.isTheAirlineAndRouteDisplayed(), "Flight airline and route is displayed on every result");
        log.info("Click on Duration (shortest) option to order Flights result");
        resultsSearchFlight.clickOnShortestDurationSortBy();
        log.info("Verify if the flights are sorted by shortest duration");
        Assert.assertTrue(resultsSearchFlight.verifyFlightListWasSortedByShortestDuration(), "Flights are sorted by shortest duration");
        log.info("Click on first flight option");
        resultsSearchFlight.clickOnFirstFlightOption();
        log.info("Verify if the departure and arrival time from selected flight match with sidebar");
        Assert.assertTrue(resultsSearchFlight.verifyDepartureAndArrivalTimeMatch(0), "Departure and arrival time match");
        log.info("Click on Continue button");
        ChooseReturningFlightPage choose = resultsSearchFlight.clickOnContinueButton();
        log.info("Verify if choose returning page is displayed");
        Assert.assertTrue(choose.isChooseReturningPageDisplayed(), "Choose returning page is displayed");
        log.info("Click on third option");
        choose.clickOnThirdFlightOption();
        log.info("Verify if the departure and arrival time from selected flight match with sidebar");
        Assert.assertTrue(choose.verifyDepartureAndArrivalTimeMatch(2), "Departure and arrival time match");
        log.info("Click on Continue button");
        choose.clickOnContinueButton();
        log.info("Click on No thanks option");
        FlightConfirmationPage flightConfirmationPage = choose.clickOnNoThanksOption();
        log.info("Verify if price summary is present");
        Assert.assertTrue(flightConfirmationPage.isPriceSummaryPresent(), "Price summary is displayed");
        log.info("Verify if Total Price is displayed");
        Assert.assertTrue(flightConfirmationPage.isTotalPricePresent(), "Total Price is displayed");
        log.info("Verify if Departure and Destination is displayed for both flights");
        Assert.assertTrue(flightConfirmationPage.isTheDepartureAndDestinationDisplayed(), "Departure and Destination is displayed");
        log.info("Verify if selected fare is Economy for both flights");
        Assert.assertTrue(flightConfirmationPage.isTheSelectedFareEconomy(), "Selected fare is Economy");
        log.info("Click on Check out button");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        log.info("Fill First traveler basic information");
        customerPaymentPage.setFirstTravelersBasicInformation(user.getFirstName(), user.getLastName(), user.getPhoneNumber());
        log.info("Fill Second traveler basic information");
        customerPaymentPage.setSecondTravelersBasicInformation(user.getFirstNameSecondTraveler(), user.getLastNameSecondTraveler());
        log.info("Verify if page title is displayed");
        Assert.assertTrue(customerPaymentPage.isTheTitlePageDisplayed(), "Page title is displayed");
        log.info("Verify if Who's traveling? title is correct");
        Assert.assertEquals(customerPaymentPage.getTravelerDetailTitle(), "Who's traveling?");
        log.info("Verify if Traveler information is displayed for both travelers");
        Assert.assertTrue(customerPaymentPage.isTheTravelerOneAndTravelerSecondInformationDisplayed(), "Traveler information displayed for both travelers");
        log.info("Verify if Payment details is displayed");
        Assert.assertTrue(customerPaymentPage.isPaymentDetailsDisplayed(), "Payment details is displayed");
        log.info("Verify if Confirmation details is displayed");
        Assert.assertTrue(customerPaymentPage.isConfirmationDetailsDisplayed(), "Confirmation details is displayed");
        log.info("Verify if Review and Book details is displayed");
        Assert.assertTrue(customerPaymentPage.isReviewAndBookDisplayed(), "Review and Book  details is displayed");
        log.info("Verify if Summary details is displayed");
        Assert.assertTrue(customerPaymentPage.isSummaryDetailsDisplayed(), "Summary details details is displayed");
    }
}
