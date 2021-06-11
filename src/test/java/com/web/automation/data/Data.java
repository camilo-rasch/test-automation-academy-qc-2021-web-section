package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author camilo.mogollon
 */
public class Data {

    @DataProvider(name = "countries")
    public Object[][] inputData() {
        return new Object[][] {{"Colombia"}, {"Brazil"}, {"Peru"}};
    }
}
