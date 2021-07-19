package com.web.automation.test;

import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TravelocityTests extends BaseTest{

    private HomePage homePage;

    @Test(description = "Booking a flight in Travelocity")
    public void bookAFlight() throws InterruptedException {
        homePage = getHomePage();
        log.info("Select the type of Flight");
        homePage.selectFlightType();
        log.info("Select the number of travellers");
        homePage.selectNumberOfTravelers();
        log.info("Search for a Flight from Las vegas to Los Angeles");
        ResultSearchFlightPage resultSearchFlightPage = homePage.searchFlight("LAS","LAX", 2);
        log.info("Assert that a box that allow to order by Price, Departure, Arrival and Duration is present");
        Assert.assertTrue(resultSearchFlightPage.isSortByDurationPresent(), "Box that allow to order by Price, Departure, Arrival and Duration isn't present");
        log.info("Assert That the flight price, duration, airline and route are present on every result.");
        Assert.assertTrue(resultSearchFlightPage.isElementPresent(), "The flight price, duration, airline and route aren't present on every result");
        log.info("Sort By shorter duration flight");
        resultSearchFlightPage.sortByDuration("DURATION_INCREASING");
        log.info("Assert the flight's result list was correctly sorted");
        Assert.assertTrue(resultSearchFlightPage.isFlightResultSorted(), "the flight's result list wasn't correctly sorted");
        log.info("Select the first departure option from Los Angeles");
        String firstTimeFlight = resultSearchFlightPage.selectFirstDepartureFlight();
        log.info("Assert departure time and arrival time matches in sidebar flight review");
        Assert.assertEquals(resultSearchFlightPage.flightTimeMatches(), firstTimeFlight,"The flight time doesn't match");
        log.info("Click continue button");
        resultSearchFlightPage.continueButton();
        log.info("Select the third departure option from Las vegas");
        String secondTimeFlight = resultSearchFlightPage.selectThirdDepartureFlight();
        log.info("Assert departure time and arrival time matches in sidebar flight review");
        Assert.assertEquals(resultSearchFlightPage.flightTimeMatches(), secondTimeFlight,"The flight time doesn't match");
        log.info("Click continue button");
        resultSearchFlightPage.continueButton();
        log.info("Handling the pop up window");
        ReviewTripPage reviewTripPage = resultSearchFlightPage.handlePopupWindow();
        log.info("Assert trip total price is present");
        Assert.assertTrue(reviewTripPage.isTripTotalPricePresent(), "Trip total price isn't present");
        log.info("Assert departure details are present");
        Assert.assertTrue(reviewTripPage.isDepartureDetailsPresent(), "Departure details aren't present");
        log.info("Assert return details are present");
        Assert.assertTrue(reviewTripPage.isReturnDetailsPresent(), "Return details aren't present");
        log.info("Assert Fare field is equal to Economy");
        Assert.assertEquals(reviewTripPage.isChangeFeesInformationPresent(), "Fare: Economy");
        log.info("Click on checkout button to continue booking ");
        WhosTravellingPage whosTravellingPage = reviewTripPage.clickOnCheckOutButton();
        log.info("First Passenger information is fulfilled");
        whosTravellingPage.firstPassengerInfo("Silvana", "Perez", "2258936", 57,10,3,"1988");
        log.info("Second Passenger information is fulfilled");
        whosTravellingPage.secondPassengerInfo("David", "Goez", 10,4,"1974");
        log.info("Assert the page title is present");
        Assert.assertTrue(whosTravellingPage.isTitlePresent(), "The page title isn't present");
        log.info("Assert the presence form is present");
        Assert.assertTrue(whosTravellingPage.isPresenceFormPresent(), "The presence form isn't present");
        log.info("Assert the insurance flight form is present");
        Assert.assertTrue(whosTravellingPage.isInsuranceFlightFormPresent(), "The insurance flight form isn't present");
        log.info("Assert the payment form is present");
        Assert.assertTrue(whosTravellingPage.isPaymentFormPresent(), "The payment form isn't present");
        log.info("Assert the flight summary is present");
        Assert.assertTrue(whosTravellingPage.isFlightSummaryPresent(), "The flight summary isn't present");

    }
}
