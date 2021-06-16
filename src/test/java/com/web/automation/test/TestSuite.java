package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest{

    private HomePage homePage;

    @Test(description = "Booking a flight in Travelocity")
    public void bookAFlight(){
        homePage = getHomePage();
        homePage.searchFlight("BOG","PAR", 5);
    }
}
