package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.CustomerPaymentPage;
import com.web.automation.pages.FlightConfirmationPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.ResultsSearchFlight;

public class TravelocityTest extends BaseTest {
	
	private HomePage homePage;
	
	@BeforeMethod(description = "Search a flight in Travelocity")
	public void searchFlight() {
		
		homePage = getHomePage();
		Assert.assertTrue(homePage.isSearchButtonPresent());
        log.info("Searching flight");
        ResultsSearchFlight resultSearchPage = homePage.searchFlight("LAS","LAX", 20, 5);
        log.info("Verify if sort by drop dowm in results search flight is present");
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
	}
	
	@AfterMethod(description = "Back to home page")
	public void backToHomePage() {
		log.info("Get Home page");
		homePage = getHomePage();
		homePage.clickOnTravelocityHeaderHomePage();
		log.info("Verify if Home page is displayed looking for search button");
		Assert.assertTrue(homePage.isSearchButtonPresent());
	}

    @Test(description = "Verify the Flights Result page in Travelocity")
    public void verifyResultPage(){
       
        ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
        log.info("Verify is all flight information displayed on page");
        Assert.assertTrue(resultSearchPage.isFlightListInformationPresent());
        log.info("Verify is all flight price displayed on page");
        Assert.assertTrue(resultSearchPage.isFlightPriceInfoPresent());
        log.info("Verify is all flight duration displayed on page");
        Assert.assertTrue(resultSearchPage.isFlightDurationInfoPresent());
        log.info("Verify is all flight airline information is displayed on page");
        Assert.assertTrue(resultSearchPage.isFlightAirLineInfoPresent());
        log.info("Verify is all flight route information is displayed on page");
        Assert.assertTrue(resultSearchPage.isFlightRouteInfoPresent());        
    }
    
    @Test(description = "Verify if estimated and arrival departure time matches with sidebar flight review - first result")
    public void verifyDepartureTimeWithSidebarFlight(){
    	
    	ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
    	log.info("Select a departure flight result");
        resultSearchPage.selectDepartureFlight(1);
        log.info("Assert departure time matches on emergent window");
        Assert.assertTrue(resultSearchPage.departureTimeMatchesFromSelectedFlight(),"Assert departure time matches");
        log.info("is continue button present?");
        Assert.assertTrue(resultSearchPage.isContinueButtonPresent());
        log.info("Click on continue button");
        resultSearchPage.clickOnContinueButton();
        log.info("Verify is sort by drop down is visible on page");
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
     }
    
    @Test(description = "Verify if estimated and arrival time matches with sidebar flight review - third result")
    public void verifyArrivalTimeWithSidebarFlight(){
    	
    	ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();    	
        resultSearchPage.selectDepartureArrivalFlight(1);
        log.info("Verify is sort by drop down is visible on page");
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
        resultSearchPage.selectDepartureFlight(3);
        log.info("Assert departure time matches on emergent window");
        Assert.assertTrue(resultSearchPage.departureTimeMatchesFromSelectedFlight(),"Assert departure time matches");
        log.info("is continue button present?");
        Assert.assertTrue(resultSearchPage.isContinueButtonPresent());
        log.info("Click on continue button");
        resultSearchPage.clickOnContinueButton();     
    }
    
    @Test(description = "Booking a flight in Travelocity")
    public void bookAFlight(){
        
    	ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
        log.info("Select departure flight from flights result list");
        resultSearchPage.selectDepartureArrivalFlight(1);
        log.info("Verify is sort by drop down is visible on page");
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
        log.info("Select Arrival flight from flights result list");
        resultSearchPage.selectDepartureArrivalFlight(3);
        log.info("Click on No thanks link");
        FlightConfirmationPage flightConfirmationPage = resultSearchPage.clickOnNoThanksLink();
        log.info("Assert Trip Total Price is displayed");
        Assert.assertTrue(flightConfirmationPage.isTripTotalPricePresent(), "Assert Trip Total Prices is displayed");
        log.info("Assert flight departure and destination information is displayed");
        Assert.assertTrue(flightConfirmationPage.isFlightReviewHeaderPresent(), "Assert flight departure and destination information is displayed");
        log.info("Assert flight fire information is displayed");
        Assert.assertTrue(flightConfirmationPage.isflightFarePresent(), "Assert flight fire information is displayed");
        log.info("is flight fare Economy");
        Assert.assertEquals(flightConfirmationPage.isFlightFareEconomy(), "Fare: Economy");
        log.info("Assert CheckOut button is displayed");        
        Assert.assertTrue(flightConfirmationPage.isCheckOutButtonPresent(), "Assert CheckOut button is displayed");
        log.info("Click on CheckOut button");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        log.info("is Who is traveling information displayed");
        Assert.assertTrue(customerPaymentPage.isWhoIsTravelingSectionPresent(), "Assert Who is traveling section displayed");
    }
    
    @Test(description = "Check out Process - complete passenger basic information", dataProviderClass = Data.class, dataProvider = "user")
    public void fillCheckOutInformation(Object[] data) {
    	
    	User user = (User) data[0];
    	ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
        log.info("Select departure flight from flights result list");
        resultSearchPage.selectDepartureArrivalFlight(1);
        log.info("Verify is sort by drop down is visible on page");
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
        log.info("Select Arrival flight from flights result list");
        resultSearchPage.selectDepartureArrivalFlight(3);
        log.info("Click on No thanks link");
        FlightConfirmationPage flightConfirmationPage = resultSearchPage.clickOnNoThanksLink();
        log.info("Assert CheckOut button is displayed");        
        Assert.assertTrue(flightConfirmationPage.isCheckOutButtonPresent(), "Assert CheckOut button is displayed");
        log.info("Click on CheckOut button");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        log.info("Verify if all Flight Check Out sections are displayed");
        log.info("is Who is traveling section displayed");
        Assert.assertTrue(customerPaymentPage.isWhoIsTravelingSectionPresent(), "Assert Who is traveling section displayed");
        log.info("is protect your flight section displayed");
        Assert.assertTrue(customerPaymentPage.isProtectYourFlightSectionPresent(), "Assert protect flight section displayed");
        log.info("is payment traveling section displayed");
        Assert.assertTrue(customerPaymentPage.isCustomerPaymentSectionPresent(), "Assert payment section displayed");
        log.info("is send traveling information section displayed");
        Assert.assertTrue(customerPaymentPage.isCustomerSendConfirmationSectionPresent(), "Assert send traveling information section displayed");
        log.info("is confirm booking section displayed");
        Assert.assertTrue(customerPaymentPage.isCustomerCompleteBookingSectionPresent(), "Assert confirm booking section displayed");
        log.info("Verify if all required fields are displayed");
        log.info("is first name field displayed");
        Assert.assertTrue(customerPaymentPage.isFirstNamePresent(), "Assert first name field displayed");
        log.info("is last name field displayed");
        Assert.assertTrue(customerPaymentPage.isLastNamePresent(), "Assert last name field displayed");
        log.info("is phoneNumber field displayed");
        Assert.assertTrue(customerPaymentPage.isPhoneNumberPresent(), "Assert phone number field displayed");
        log.info("is female gender option displayed");
        Assert.assertTrue(customerPaymentPage.isFemaleGenderPresent(), "Assert female gender option displayed");
        customerPaymentPage.completeCustomerBasicInformation(user.getFirstName(), user.getLastName(), 7, user.getPhoneNumber(), 4, 22, 20);
    }

}
