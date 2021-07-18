package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.pages.CustomerPaymentPage;
import com.web.automation.pages.FlightConfirmationPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.ResultsSearchFlight;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
/**
 * Test to book a flight.
 * @author Jonathan.Triana.
 */
public class TestBookingFlight extends BaseTest{

    private HomePage homePage;

    @Test(description = "Booking a flight",dataProvider="dataBookingFlight",dataProviderClass= Data.class)

    public void bookAFlight(String departure,String destination, int departureFlightOption,int arrivalFlightOption
    ,String nameAdult1,String lastnameAdult1, String codeAdult1, String phoneAdult1, String monthBirthAdult1
    ,String dayBirthAdult1,String yearBirthAdult1,String nameAdult2,String lastnameAdult2,String monthBirthAdult2
    ,String dayBirthAdult2,String yearBirthAdult2) throws InterruptedException {

        homePage = getHomePage();
        log.info("1) Search for a flight from LAS to LAX. Selecting Flight and roundtrip. Select 2 adults in the travelers link. Dates should be at least two months in the future and MUST be selected using the datepicker calendar.");
        ResultsSearchFlight resultsSearchFlight = homePage.searchFlight(departure,destination);

        log.info("2. Verify the result page using the following:");
        log.info("2a Assert: There is a box that allow you to order by Price, Departure, Arrival and Duration.");
        Assert.assertTrue(resultsSearchFlight.isSortByPresent(), "Verify if the 'Sort by' element is present");

        log.info("2b Assert : The flight price is present on every result.");
        log.info("2c Assert: Flight duration is present on every result.");
        log.info("2d Assert: Flight airline and flight route (Departure and Destination) are present on every result.");
        resultsSearchFlight.validationsInEachResult();

        log.info("3 Sort by duration > shorter. Verify the list was correctly sorted.");
        resultsSearchFlight.selectDropdownValue("DURATION_INCREASING");
        Assert.assertTrue(resultsSearchFlight.validateTheListDurationShorter(), "Verify if the 'list correctly sorted");

        log.info("4. Select your departure to Los Angeles first flight result.");
        log.info("4a. Assert: Verify selected flight estimated departure time and arrival time matches in sidebar flight review.");
        Assert.assertTrue(resultsSearchFlight.clickOnFlightAndValidateTheTime(departureFlightOption), "Verify if flight estimated departure time and arrival time matches with the option selected");

        log.info("4b. Accept flight.");
        resultsSearchFlight.clickOnContinueButton();

        log.info("Assert to be sure that the page finish to load");
        Assert.assertTrue(resultsSearchFlight.isSortByPresent(), "Verify if 'Sort by' element finish to load");

        log.info("5. In the new page (Select your departure to Las Vegas), select the third result.");
        log.info("5a. Assert: Verify selected flight estimated departure time and arrival time matches in sidebar flight review.");
        Assert.assertTrue(resultsSearchFlight.clickOnFlightAndValidateTheTime(arrivalFlightOption), "Verify if flight estimated departure time and arrival time matches with the option selected");

        log.info("5b. Accept flight.");
        resultsSearchFlight.clickOnContinueButton();

        log.info("6 If a “Search for Hotels” card pops up, select “No thanks”.");
        FlightConfirmationPage flightConfirmationPage = resultsSearchFlight.clickOnNoThanksLink();

        log.info("7. Verify trip details in the new page, by:");
        log.info("7a Assert: Trip total price is present");
        Assert.assertTrue(flightConfirmationPage.isTripTotalPresent(), "Verify if the 'Trip total' element is present");

        log.info("7b Assert: Departure information is present");
        Assert.assertTrue(flightConfirmationPage.isDepartureInfoPresent(), "Verify if the 'Departure information' element is present");

        log.info("7b Assert: return information is present");
        Assert.assertTrue(flightConfirmationPage.isReturnInfoPresent(), "Verify if the 'Return information' element is present");

        log.info("7c Assert: Selected Fare is Economy.");
        Assert.assertEquals(flightConfirmationPage.matchFareEconomyText(), "Fare: Economy");

        log.info("8. Press Checkout.");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();

        log.info("9. Choose and apply at least 5 validations to be performed in this page (Be clear in the code which validations you have chosen)");
        log.info("Assert 1: phone country code text is displayed (title of the input)");
        Assert.assertTrue(customerPaymentPage.isCountryPresent(), "verify if the phone country code text is displayed");
        log.info("Assert 2: input name on card is present");
        Assert.assertTrue(customerPaymentPage.isNameOnCardPresent(), "Validate if the field of the name's card element is present");
        log.info("Assert 3: validate if the number of tickets and number of adults is present and match with the correct text");
        Assert.assertEquals(customerPaymentPage.matchNumberOfTicketsAndAdultsText(), "2 tickets: 2 adults");
        log.info("Assert 4: validate if 'Who's traveling?' text is present and match with the correct text");
        Assert.assertEquals(customerPaymentPage.matchWhoIsTravelingText(), "Who's traveling?");
        log.info("Assert 5: validate if 'Roundtrip flight' text is present and match with the correct text");
        Assert.assertEquals(customerPaymentPage.matchRoundTripText(), "Roundtrip flight");

        log.info("10. Complete passenger basic information.");
        customerPaymentPage.informationAdult1(nameAdult1,lastnameAdult1,codeAdult1,phoneAdult1,monthBirthAdult1,dayBirthAdult1,yearBirthAdult1);
        customerPaymentPage.informationAdult2(nameAdult2,lastnameAdult2,monthBirthAdult2,dayBirthAdult2,yearBirthAdult2);
    }
}
