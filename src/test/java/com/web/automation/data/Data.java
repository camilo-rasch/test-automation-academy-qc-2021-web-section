package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author Jonathan.Triana
 */
public class Data {

    @DataProvider(name = "dataBookingFlight")
    public Object[][] inputData() {
        return new Object[][] {{
        // Departure and arrival city (Las Vegas, Los Angeles)
        "LAS","LAX",
        //Flight departure option and flight return option
        1,3,
        //Name and lastname of the first adult
        "John","Test",
        //Phone country code (Colombia) and the phone number
        "57","3123423455",
        //Date of birth MM/DD/YY of the first adult
        "10","30","1987",
        //Name and lastname of the second adult
        "Ana","Test",
        //Date of birth MM/DD/YY of the second adult
        "07","17","1994"}};
    }
}
