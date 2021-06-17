package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author jessica.cardona
 */
public class Data {

    @DataProvider(name = "days")
    public Object[][] inputData() {
        return new Object[][] {{"Sunday"}, {"Monday"}, {"Tuesday"}, {"Wednesday"}, {"Thursday"}, {"Friday"}, {"Saturday"}};
    }
}
