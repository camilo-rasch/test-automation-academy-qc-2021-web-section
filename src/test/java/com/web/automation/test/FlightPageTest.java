package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.pages.*;
import com.web.automation.pojo.Flight;
import org.testng.annotations.Test;


public class FlightPageTest extends BaseTest{
    HomePage homePage;

    @Test(description = "Open the HomePage", dataProviderClass = Data.class, dataProvider = "flights")
    public void searchForAFlight(Flight flight){
        homePage = getHomePage();
        log.info("Travelocity webpage is succeeded displayed");
        homePage.clickOnFlightButton();
        homePage.clickONRoundTripButton();
        homePage.selectDepartureAirport(flight);
        homePage.selectDestinationAirport(flight);
        homePage.pickOnDateOfDepartingCalendar();
        //homePage.pickOnDateOfDestinationCalendar();
        DepartingFlightPage departingFlightPage = homePage.clickOnSearchButton();
        departingFlightPage.sortByPriceDropDown();
        DepartureDetailPage departureDetailPage = departingFlightPage.clickOnDepartureFlight();
        ReturningFlightPage returningFlightPage = departureDetailPage.clickOnContinueButton();
        returningFlightPage.sortByPriceDropDown();
        ReturningDetailPage returningDetailPage = returningFlightPage.clickOnReturningFlight();
        ReviewTripPage reviewTripPage = returningDetailPage.clickOnContinueButton();
        BookingFlightPage bookingFlightPage = reviewTripPage.clickOnGoToCheckOutButton();

    }

}
