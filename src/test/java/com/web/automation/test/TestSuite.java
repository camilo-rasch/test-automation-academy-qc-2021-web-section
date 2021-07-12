package com.web.automation.test;

import com.web.automation.pages.CustomerPaymentPage;
import com.web.automation.pages.FlightConfirmationPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.ResultsSearchFlight;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestSuite extends BaseTest{

    private HomePage homePage;

    @Test(description = "Booking a flight")
    public void bookAFlight() throws InterruptedException {
        homePage = getHomePage();
        log.info("1) Search for a flight from LAS to LAX, 1 adult (clicking on Flight/Roundtrip).");
        log.info("Dates should be at least two month in the future and MUST be selected using the datepicker calendar");
        ResultsSearchFlight resultsSearchFlight = homePage.searchFlight("LAS","LAX", 2);
        sleep(8000);
        log.info("2. Verify the result page using the following:");
        log.info("2a Assert: There is a box that allow you to order by Price, Departure, Arrival and Duration.");
        Assert.assertTrue(resultsSearchFlight.isSortByPresent(), "Assert Sort by is displayed");
        log.info("2b Assert: The select button is present on every result");
        log.info("2c Assert: Flight duration is present on every result");
        log.info("2d Assert: The flight detail and baggage fees is present on every result");
        sleep(2000);
        log.info("3 Sort by duration > shorter. Verify the list was correctly sorted.");
        resultsSearchFlight.selectDropdownValue("DURATION_INCREASING");
        log.info("3a Assert: From this step select elements on the list using the button Select (don’t use the elements with Hotel Select Flight + Hotel )");
        log.info("4. In the page (Select your departure to Los Angeles), select the first result.");

        resultsSearchFlight.selectAFlightByAirlineLambda("Airlines");
        resultsSearchFlight.clickOnContinueButton();

        log.info("5. In the new page (Select your departure to Las Vegas), select the third result.");
        resultsSearchFlight.selectAFlightByAirlineLambda("Airlines");
        resultsSearchFlight.clickOnContinueButton();

        log.info("5a Assert: if exists the pop-up asking for “flight with a Hotel”, select “no, thanks, maybe later”");
        FlightConfirmationPage flightConfirmationPage = resultsSearchFlight.clickOnNoThanksLink();

        log.info("6. Verify trip details in the new page, by:");
        log.info("6a Assert: Trip total price is present");
        Assert.assertTrue(flightConfirmationPage.isTripTotalPresent(), "Assert Trip Total is displayed");
        log.info("6b Assert: Departure and return information is present");

        log.info("6c Assert: Price guarantee text is present");

        log.info("7. Press Checkout.");
        log.info("Assert CheckOut button is displayed");
        Assert.assertTrue(flightConfirmationPage.isCheckOutButtonPresent(), "Assert CheckOut button is displayed");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        sleep(10000);
        log.info("8. Verify the “Who’s travelling” page is opened by choosing at least 5 validations to be performed.");
        log.info("Assert country input is displayed");
        Assert.assertTrue(customerPaymentPage.isCountryPresent(), "Assert Trip Total is displayed");
        log.info("Assert country input is displayed");
        Assert.assertTrue(customerPaymentPage.isNameOnCardPresent(), "Assert Trip Total is displayed");
        log.info("Assert security code field is displayed");
        Assert.assertTrue(customerPaymentPage.isPhoneNumberPresent(), "Assert Trip Total is displayed");
        log.info("Assert who is traveling label is displayed");
        Assert.assertTrue(customerPaymentPage.isWhoIsTravelingPresent(), "Assert Trip Total is displayed");
        log.info("Assert round trip label is displayed");
        Assert.assertTrue(customerPaymentPage.isRoundTripPresent(), "Assert Trip Total is displayed");









    /*  log.info("Click on one stop checkbox");
        resultsSearchFlight.clickOnOneStopCheckBox();
        log.info("Select a flight from flights result list by Airline");
        resultsSearchFlight.selectAFlightByAirlineLambda("Air Europa");
        sleep(4000);
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
  */
    }
}
