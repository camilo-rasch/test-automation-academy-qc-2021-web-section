package com.web.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author camilo.mogollon
 */
public class Data {

    @DataProvider(name = "Credentials")
    public Object[][] credentials() {

        Object[][] credentials = new Object[1][1];

        credentials[0][0] = "testingtryfinal1@studying.com";
        credentials[0][1] = "13a1fghGRB";
        return credentials;
    }
}

//rows and columns
