package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author hernan.barroso
 */
public class Data {

    @DataProvider(name = "passengerBasicInfo")
    public Object[][] inputData() {
        Passenger passenger = new Passenger("Hernan","Enrique","Barroso","3127341111",
                "Paula","Andrea","Hernandez");
        return new Object[][] {{passenger}};
    }

}
