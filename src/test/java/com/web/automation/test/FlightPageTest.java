package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.pages.*;
import com.web.automation.pojo.Flight;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Class to define the test
 * @author juandaniel.castano@globant.com
 */

public class FlightPageTest extends BaseTest{
    HomePage homePage;

    /**
     * Flight object data is provided and the 'Book For A Flight' Test method implemented
     * @param flight Object
     */

    @Test(description = "Book A Flight", dataProviderClass = Data.class, dataProvider = "flights")
    public void bookForAFlight(Flight flight) {
        homePage = getHomePage();
        log.info("Travelocity webpage is succeeded displayed");
        homePage.clickOnFlightButton();
        log.info("Click On 'Flights' button");
        homePage.clickOnRoundTripButton();
        log.info("Click On RoundTrip flight button");
        homePage.clickOnTravelerNumberButton();
        log.info("Click On number of travelers");
        homePage.selectDepartureAirport(flight);
        log.info("Type departing airport");
        homePage.selectDestinationAirport(flight);
        log.info("Type destination airport");
        homePage.pickOnDateOfDepartingCalendar();
        log.info("Pick On calendar departure day");
        homePage.pickOnDateOfDestinationCalendar();
        log.info("Pick On calendar return day");
        DepartingFlightPage departingFlightPage = homePage.clickOnSearchButton();

        log.info("Departing Flight webpage is succeeded displayed");
        Assert.assertTrue(departingFlightPage.sortByDropDownFieldIsDisplayed(),"Sort By DropDown Field is not displayed");
        departingFlightPage.sortByDropDown();
        log.info("Sort By Duration(shortest) flights");
        Assert.assertTrue(departingFlightPage.selectButtonIsDisplayed(), "Select Button is not displayed");
        Assert.assertTrue(departingFlightPage.flightPriceIsDisplayed(), "Flight price is not displayed");
        Assert.assertTrue(departingFlightPage.journeyDurationIsDisplayed(),"Journey Duration is not displayed");
        Assert.assertTrue(departingFlightPage.routeAndAirLineFlightIsDisplayed(), "Route and AirLine Operator are not displayed");
        Assert.assertTrue(departingFlightPage.listCorrectlySortedValidation(), "Flights are not sorted by duration");
        DepartureDetailPage departureDetailPage = departingFlightPage.clickOnDepartureFlight();

        log.info("Departing Detail Flight webpage is succeeded displayed");
        Assert.assertEquals(departingFlightPage.departureEstimatedTime(), departureDetailPage.departureEstimatedTime(), "Departing Times are not matching");
        ReturningFlightPage returningFlightPage = departureDetailPage.clickOnContinueButton();

        log.info("Returning Flight webpage is succeeded displayed");
        ReturningDetailPage returningDetailPage = returningFlightPage.clickOnReturningFlight();

        log.info("Returning Detail Flight webpage is succeeded displayed");
        Assert.assertEquals(returningFlightPage.returnEstimatedTime(), returningDetailPage.returnEstimatedTime(), "Returning Times are not matching");
        ReviewTripPage reviewTripPage = returningDetailPage.clickOnContinueButton();

        log.info("Review Trip webpage is succeeded displayed");
        Assert.assertTrue(reviewTripPage.priceSummarySectionIsDisplayed(), "Price Summary section is not displayed");
        Assert.assertTrue(reviewTripPage.tripTotalPriceTextIsDisplayed(), "Trip total price is not displayed");
        Assert.assertTrue(reviewTripPage.departureReviewSectionIsDisplayed(), "Departing trip review section is not displayed");
        Assert.assertTrue(reviewTripPage.departingFlightFareIsSelected(), "Departing flight fare is not economic");
        Assert.assertTrue(reviewTripPage.returnReviewSectionIsDisplayed(), "Returning trip review section is not displayed");
        BookingFlightPage bookingFlightPage = reviewTripPage.clickOnGoToCheckOutButton();
        
        log.info("Booking Flight webpage is succeeded displayed");
        bookingFlightPage.enterFirstNameTraveler();
        bookingFlightPage.enterMiddleNameTraveler();
        bookingFlightPage.enterLastNameTraveler();
        bookingFlightPage.enterPhoneNumberTraveler();
        Assert.assertTrue(bookingFlightPage.preferencesSectionIsDisplayed(), "Traveler preferences section is not displayed");
        Assert.assertTrue(bookingFlightPage.insuranceSectionIsDisplayed(), "Insurance coverage section is not displayed");
        Assert.assertTrue(bookingFlightPage.paymentsSectionIsDisplayed(), "Payment methods section are not displayed");
        Assert.assertTrue(bookingFlightPage.emailSectionIsDisplayed(), "Email confirmation section is not displayed");
        Assert.assertTrue(bookingFlightPage.completeSectionIsDisplayed(), "Review and book section is not displayed");
        Assert.assertTrue(bookingFlightPage.summarySectionIsDisplayed(), "Summary section is not displayed");

    }

}
