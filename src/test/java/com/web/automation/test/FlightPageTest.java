package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.pages.*;
import com.web.automation.pojo.Flight;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FlightPageTest extends BaseTest{
    HomePage homePage;

    @Test(description = "Book A Flight", dataProviderClass = Data.class, dataProvider = "flights")
    public void searchForAFlight(Flight flight) throws InterruptedException {
        homePage = getHomePage();
        log.info("Travelocity webpage is succeeded displayed");
        homePage.clickOnFlightButton();
        log.info("Click On 'Flights' button");
        homePage.clickOnRoundTripButton();
        log.info("Click On RoundTrip flight button");
        homePage.selectDepartureAirport(flight);
        log.info("Type departing airport");
        homePage.selectDestinationAirport(flight);
        log.info("Type destination airport");
        homePage.pickOnDateOfDepartingCalendar();
        log.info("Pick On calendar day");
        //homePage.pickOnDateOfDestinationCalendar();
        DepartingFlightPage departingFlightPage = homePage.clickOnSearchButton();
        log.info("Departing Flight webpage is succeeded displayed");
        Assert.assertTrue(departingFlightPage.sortByDropDownFieldIsDisplayed(),"Sort By DropDown Field is not displayed");
        departingFlightPage.sortByDropDown();
        log.info("Sort By Duration(shortest) flights");
        Assert.assertTrue(departingFlightPage.selectButtonIsDisplayed(), "Select Button is not displayed");
        Assert.assertTrue(departingFlightPage.journeyDurationIsDisplayed(),"Journey Duration is not displayed");
        Assert.assertTrue(departingFlightPage.listCorrectlySortedValidation(), "Flights are not sorted by duration");
        DepartureDetailPage departureDetailPage = departingFlightPage.clickOnDepartureFlight();
        log.info("Departing Detail Flight webpage is succeeded displayed");
        ReturningFlightPage returningFlightPage = departureDetailPage.clickOnContinueButton();
        log.info("Returning Flight webpage is succeeded displayed");
        returningFlightPage.sortByPriceDropDown();
        ReturningDetailPage returningDetailPage = returningFlightPage.clickOnReturningFlight();
        log.info("Returning Detail Flight webpage is succeeded displayed");
        returningDetailPage.clickOnShowDetailsButton();
        log.info("Show returning flight details");
        Assert.assertTrue(returningDetailPage.flightDetailsInfoSectionIsDisplayed(), "Flight Details section is not displayed");
        Assert.assertTrue(returningDetailPage.totalPriceIsDisplayed(), "Total Price is not displayed");
        Assert.assertTrue(returningDetailPage.priceGuaranteeTextIsDisplayed(), "Price Guarantee is not displayed");
        ReviewTripPage reviewTripPage = returningDetailPage.clickOnContinueButton();
        log.info("Review Trip webpage is succeeded displayed");
        Assert.assertTrue(reviewTripPage.priceSummarySectionIsDisplayed(), "Price Summary section is ot displayed");
        BookingFlightPage bookingFlightPage = reviewTripPage.clickOnGoToCheckOutButton();
        log.info("Booking Flight webpage is succeeded displayed");
        Assert.assertTrue(bookingFlightPage.preferencesSectionIsDisplayed(), "Traveler preferences section is not displayed");
        Assert.assertTrue(bookingFlightPage.insuranceSectionIsDisplayed(), "Insurance coverage section is not displayed");
        Assert.assertTrue(bookingFlightPage.paymentsSectionIsDisplayed(), "Payment methods section are not displayed");
        Assert.assertTrue(bookingFlightPage.emailSectionIsDisplayed(), "Email confirmation section is not displayed");
        Assert.assertTrue(bookingFlightPage.completeSectionIsDisplayed(), "Review and book section is not displayed");
        Assert.assertTrue(bookingFlightPage.summarySectionIsDisplayed(), "Summary section is not displayed");
    }

}
