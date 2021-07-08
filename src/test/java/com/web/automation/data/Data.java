package com.web.automation.data;

import com.web.automation.pojo.Flight;
import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author camilo.mogollon
 */
public class Data {

    @DataProvider(name = "flights")
    public Object[][] inputData() {
        Flight flight = new Flight("LAS",
                "LAX",
                "00:00 hrs",
                "800",
                "USA AirLine");
        return new Object[][] {{flight}};
    }
}
