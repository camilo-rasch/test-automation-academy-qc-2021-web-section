package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 */
public class Data {
    @DataProvider(name = "user")
    public Object[][] inputDataUser() {
        return new Object[][] {{new User()}};
    }
}
