package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author hernan.barroso
 */
public class Data {

    @DataProvider(name = "userAccount")
    public Object[][] createAccount() {
        return new Object[][] {{new User()}};
    }

}
