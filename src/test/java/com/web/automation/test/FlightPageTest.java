package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.pages.*;
import com.web.automation.pojo.Flight;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FlightPageTest extends BaseTest{
    HomePage homePage;

    @Test(description = "Open the HomePage", dataProviderClass = Data.class, dataProvider = "flights")
    public void searchForAFlight(Flight flight) throws InterruptedException {
        homePage = getHomePage();
        log.info("Travelocity webpage is succeeded displayed");
        homePage.clickOnFlightButton();
        homePage.clickONRoundTripButton();
        homePage.selectDepartureAirport(flight);
        homePage.selectDestinationAirport(flight);
        homePage.pickOnDateOfDepartingCalendar();
        //homePage.pickOnDateOfDestinationCalendar();
        DepartingFlightPage departingFlightPage = homePage.clickOnSearchButton();
        Assert.assertTrue(departingFlightPage.sortByDropDownFieldIsDisplayed(),"Sort By DropDown Field is not displayed");
        departingFlightPage.sortByPriceDropDown();
        Assert.assertTrue(departingFlightPage.selectButtonIsDisplayed(), "Select Button is not displayed");
        Assert.assertTrue(departingFlightPage.journeyDurationIsDisplayed(),"Journey Duration is not displayed");
        DepartureDetailPage departureDetailPage = departingFlightPage.clickOnDepartureFlight();
        ReturningFlightPage returningFlightPage = departureDetailPage.clickOnContinueButton();
        returningFlightPage.sortByPriceDropDown();
        ReturningDetailPage returningDetailPage = returningFlightPage.clickOnReturningFlight();
        returningDetailPage.clickOnShowDetailsButton();
        Assert.assertTrue(returningDetailPage.flightDetailsInfoSectionIsDisplayed(), "Flight Details section is not displayed");
        Assert.assertTrue(returningDetailPage.totalPriceIsDisplayed(), "Total Price is not displayed");
        Assert.assertTrue(returningDetailPage.priceGuaranteeTextIsDisplayed(), "Price Guarantee is not displayed");
        ReviewTripPage reviewTripPage = returningDetailPage.clickOnContinueButton();
        Assert.assertTrue(reviewTripPage.priceSummarySectionIsDisplayed(), "Price Summary section is ot displayed");
        BookingFlightPage bookingFlightPage = reviewTripPage.clickOnGoToCheckOutButton();
    }

}
