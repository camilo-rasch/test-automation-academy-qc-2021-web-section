package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author jonathan.triana
 */
public class Data {

    @DataProvider(name = "day")
    public Object[][] inputData() {
        return new Object[][] {{"Wednesday"}};
    }
}
