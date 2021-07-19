package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.Passenger;
import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest{

    private HomePage homePage;
    private ResultDeparturePage resultDeparturePage;
    private ResultReturnPage resultReturnPage;
    private TripSummaryPage tripSummaryPage;
    private PassengerInfoPage passengerInfoPage;


    @Test(description = "Booking a round trip flight", dataProviderClass = Data.class, dataProvider = "passengerBasicInfo")
    public void bookAFlight(Passenger passenger) {

        homePage = getHomePage();
        log.info("Searching flight");
        resultDeparturePage = homePage.searchFlight("LAS", "LAX", 5);
        log.info("Check if sort button is displayed");
        Assert.assertTrue(resultDeparturePage.isSortButtonDisplayed(), "Sort button is not displayed");
        log.info("Check if flight price is displayed");
        Assert.assertTrue(resultDeparturePage.isFlightPriceDisplayed(), "Price is not displayed");
        log.info("Check if flight duration is displayed");
        Assert.assertTrue(resultDeparturePage.isFlightDurationDisplayed(), "Flight duration is not displayed");
        log.info("Check if flight airline is displayed");
        Assert.assertTrue(resultDeparturePage.isFlightAirlineDisplayed(), "Airline is not displayed");
        log.info("Check if flight route is displayed");
        Assert.assertTrue(resultDeparturePage.isFlightRouteDisplayed(), "Flight route is not displayed");
        log.info("Order the list by duration");
        resultDeparturePage.sortByDuration();
        log.info("Check if the list is sorted");
        Assert.assertTrue(resultDeparturePage.isSortedList(), "the list is not sorted");
        log.info("Click on first result");
        resultDeparturePage.clickOnFirstResultList();
        log.info("Compare departure and arrival times");
        Assert.assertTrue(resultDeparturePage.timeMatchesWithTimeDetail(),"Times don't match");
        log.info("Click on continue button");
        resultReturnPage = resultDeparturePage.clickOnContinueButton();
        log.info("Click on the third result");
        resultReturnPage.clickOnThirdResultList();
        log.info("Compare departure and arrival times");
        Assert.assertTrue(resultReturnPage.timeMatchesWithTimeDetail(),"Times don't match");
        log.info("Click on continue button");
        resultReturnPage.clickOnContinueButton();
        log.info("Click on NoThanks button");
        tripSummaryPage = resultReturnPage.clickOnNoThanksButton();
        log.info("Check if total price is displayed");
        Assert.assertTrue(tripSummaryPage.isTripTotalPriceDisplayed(),"Total price is not displayed");
        log.info("Check if departure info is displayed");
        Assert.assertTrue(tripSummaryPage.isDepartureInfoDisplayed(),"Departure information is not displayed");
        log.info("Check if destination info is displayed");
        Assert.assertTrue(tripSummaryPage.isDestinationInfoDisplayed(),"Destination information is not displayed");
        log.info("Check if fare: Economy is displayed");
        Assert.assertEquals("Fare: Economy",tripSummaryPage.getFareEconomy(),"Selected Fare is not Economy");
        log.info("Click on Checkout button");
        passengerInfoPage = tripSummaryPage.clickOnCheckOutButton();
        log.info("Input information for the passenger 1");
        passengerInfoPage.completePassengerBasicInfo(passenger.getFirstNamePassenger1(), passenger.getMiddleNamePassenger1(),
                passenger.getLastNamePassenger1(), passenger.getPhoneNumberPassenger1());
        log.info("Input information for the passenger 2");
        passengerInfoPage.completePassenger2BasicInfo(passenger.getFirstNamePassenger2(), passenger.getMiddleNamePassenger2(),
                passenger.getLastNamePassenger2());
        log.info("Check if info for the passenger 1 is displayed");
        Assert.assertTrue(passengerInfoPage.isTraveler1InfoDisplayed(),"Traveler1 Info is not displayed");
        log.info("Check if info for the passenger 2 is displayed");
        Assert.assertTrue(passengerInfoPage.isTraveler2InfoDisplayed(),"Traveler2 info is not displayed");
        log.info("Check if flight insurance is displayed");
        Assert.assertTrue(passengerInfoPage.isFlightInsuranceDisplayed(),"Flight insurance is not displayed");
        log.info("Check if payment mode info is displayed");
        Assert.assertTrue(passengerInfoPage.isPaymentModeInfoDisplayed(),"Payment mode is not displayed");
        log.info("Check if complete booking button is displayed");
        Assert.assertTrue(passengerInfoPage.isCompleteBookingButtonDisplayed(),"Complete booking button is not displayed");

    }

}
