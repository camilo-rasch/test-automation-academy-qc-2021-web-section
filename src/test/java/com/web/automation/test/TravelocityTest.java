package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.automation.pages.CustomerPaymentPage;
import com.web.automation.pages.FlightConfirmationPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.ResultsSearchFlight;

public class TravelocityTest extends BaseTest {
	
	private HomePage homePage;
	
	@BeforeMethod(description = "Search a flight in Travelocity")
	public void searchAFlight() {
		
		homePage = getHomePage();
		Assert.assertTrue(homePage.isSearchButtonPresent());
        log.info("Searching flight");
        ResultsSearchFlight resultSearchPage = homePage.searchFlight("LAS","LAX", 30, 5);
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
	}
	
	@AfterMethod(description = "Back to home page")
	public void backToHomePage() {
		log.info("Get Home page");
		homePage = getHomePage();
		homePage.clickOnTravelocityHeaderHomePage();
		Assert.assertTrue(homePage.isSearchButtonPresent());
	}

    @Test(description = "Verify the Flights Result page in Travelocity")
    public void verifyResultPage(){
       
        log.info("Verify the Result Page");
        ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
        log.info("Verify is sort by drop down is visible on page");
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
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
    	
    	log.info("Verify the Result Page");
        ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
        resultSearchPage.selectDepartureFlight(0);
        log.info("Assert departure time matches on emergent window");
        Assert.assertTrue(resultSearchPage.departureTimeMatchesFromSelectedFlight(),"Assert departure time matches");
        log.info("Click on continue button");
        resultSearchPage.clickOnContinueButton();
        log.info("Click on no thanks link");
    }
    
    @Test(description = "Verify if estimated and arrival time matches with sidebar flight review - third result")
    public void verifyArrivalTimeWithSidebarFlight(){
    	
    	log.info("Verify the Result Page");
        ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
    	resultSearchPage.selectDepartureFlight(0);
        log.info("Assert departure time matches on emergent window");
        Assert.assertTrue(resultSearchPage.departureTimeMatchesFromSelectedFlight(),"Assert departure time matches");
        log.info("Click on continue button");
        resultSearchPage.clickOnContinueButton();
        log.info("Verify is sort by drop down is visible on page");
        Assert.assertTrue(resultSearchPage.isSortByDropDownPresent());
        resultSearchPage.selectDepartureFlight(2);
        log.info("Assert departure time matches on emergent window");
        Assert.assertTrue(resultSearchPage.departureTimeMatchesFromSelectedFlight(),"Assert departure time matches");
        log.info("Click on continue button");
        resultSearchPage.clickOnContinueButton();     
    }
    
    @Test(description = "Booking a flight in Travelocity")
    public void bookAFlight(){
        
    	log.info("Verify the Result Page");
        ResultsSearchFlight resultSearchPage = homePage.giveControlToResultPage();
        log.info("Select a flight from flights result list");
        resultSearchPage.selectDepartureFlight(0);
        log.info("Assert departure time matches on emergent window");
        Assert.assertTrue(resultSearchPage.departureTimeMatchesFromSelectedFlight(),"Assert departure time matches");
        log.info("Click on continue button");
        resultSearchPage.clickOnContinueButton();
        log.info("Click on no thanks link");
        FlightConfirmationPage flightConfirmationPage = resultSearchPage.clickOnNoThanksLink();
        log.info("Assert CheckOut button is displayed");
        Assert.assertTrue(flightConfirmationPage.isCheckOutButtonPresent(), "Assert CheckOut button is displayed");
        log.info("Click on CheckOut button");
        CustomerPaymentPage customerPaymentPage = flightConfirmationPage.clickOnCheckOutButton();
        log.info("Select by index on Customer title Select");
        customerPaymentPage.selectOptionInCustomerTitleSelectByIndex(2);
    }

}
