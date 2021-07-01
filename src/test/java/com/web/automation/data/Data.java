package com.web.automation.data;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * Data provider class.
 * @author fabio.alarcon
 */
public class Data {

    @DataProvider(name = "Credentials")
    public Object[][] credentialsOriginal() {

        UserInfo userInfo = new UserInfo("Fabio",
                "Alarcon",
                "test" + randomNumber() + "@aol.com",
                "1231abc32");
        return new Object[][] {{userInfo}};
    }

    /**
     * Method to create random numbers
     * @return
     * Used to create the email
     */
    public int randomNumber (){
        Random random = new Random();
        int number = random.nextInt(5000);
        return number;
    }
}