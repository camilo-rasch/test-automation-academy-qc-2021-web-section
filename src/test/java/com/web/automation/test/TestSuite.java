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
        log.info("1) Search for a flight from LAS to LAX. Selecting Flight and roundtrip. Select 2\n" +
                "adults in the travelers link. Dates should be at least two months in the future and\n" +
                "MUST be selected using the datepicker calendar.");
        ResultsSearchFlight resultsSearchFlight = homePage.searchFlight("LAS","LAX", 30);
        log.info("2. Verify the result page using the following:");
        log.info("2a Assert: There is a box that allow you to order by Price, Departure, Arrival and Duration.");
        Assert.assertTrue(resultsSearchFlight.isSortByPresent(), "The 'Sort by' element was not found");
        log.info("2b Assert : The flight price is present on every result.");
        log.info("2c Assert: Flight duration is present on every result.");
        log.info("2d Assert: Flight airline and flight route (Departure and Destination) are present on every result.");
        log.info("3 Sort by duration > shorter. Verify the list was correctly sorted.");
        resultsSearchFlight.selectDropdownValue("DURATION_INCREASING");
        log.info("4. Select your departure to Los Angeles first flight result.");
        resultsSearchFlight.selectAFlightByAirlineLambda("Airlines");
        log.info("4a. Assert: Verify selected flight estimated departure time and arrival time matches in sidebar flight review.");
        log.info("4b. Accept flight.");
        resultsSearchFlight.clickOnContinueButton();
        log.info("5. In the new page (Select your departure to Las Vegas), select the third result.");
        resultsSearchFlight.selectAFlightByAirlineLambda("Airlines");
        log.info("5a. Assert: Verify selected flight estimated departure time and arrival time matches in sidebar flight review.");
        log.info("5b. Accept flight.");
        resultsSearchFlight.clickOnContinueButton();
        log.info("6 If a “Search for Hotels” card pops up, select “No thanks”.");
        FlightConfirmationPage flightConfirmationPage = resultsSearchFlight.clickOnNoThanksLink();
        log.info("7. Verify trip details in the new page, by:");
        log.info("7a Assert: Trip total price is present");
        Assert.assertTrue(flightConfirmationPage.isTripTotalPresent(), "The 'Trip total' element was not found");
        log.info("7b Assert: Departure information is present");
        Assert.assertTrue(flightConfirmationPage.isDepartureInfoPresent(), "The 'Departure information' element was not found");
        log.info("7b Assert: return information is present");
        Assert.assertTrue(flightConfirmationPage.isReturnInfoPresent(), "The 'Return information' element was not found");
        log.info("7c Assert: Selected Fare is Economy.");
        Assert.assertEquals(flightConfirmationPage.matchFareEconomyText(), "Fare: Economy");
        log.info("8. Press Checkout.");
        log.info("Assert CheckOut button is displayed");
        Assert.assertTrue(flightConfirmationPage.isCheckOutButtonPresent(), "Assert CheckOut button is displayed");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        log.info("9. Complete passenger basic information.");
        log.info("10. Choose and apply at least 5 validations to be performed in this page (Be clear in the code which validations you have chosen)");
        log.info("Assert 1: country input is displayed");
        Assert.assertTrue(customerPaymentPage.isCountryPresent(), "The 'field country' element was not found");
        log.info("Assert 2: input name on card is displayed");
        Assert.assertTrue(customerPaymentPage.isNameOnCardPresent(), "The 'field of the name's card' element was not found");
        log.info("Assert 3: security code field is displayed");
        Assert.assertTrue(customerPaymentPage.isPhoneNumberPresent(), "The 'field of the phone number' element was not found");
        log.info("Assert 4: validate if 'who is traveling' label is present");
        Assert.assertEquals(customerPaymentPage.matchWhoIsTravelingText(), "Who's traveling?");
        log.info("Assert 5: validate if is a round trip flight");
        Assert.assertEquals(customerPaymentPage.matchRoundTripText(), "Roundtrip flight");
    }
}
