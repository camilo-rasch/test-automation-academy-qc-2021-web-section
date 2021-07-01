package com.web.automation.data;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * Data provider class.
 * @author juandaniel.castano
 */
public class Data {

    /**
     *
     * @return new Object[][] of new User object
     */
    @DataProvider(name = "ESPNUser")
    public Object[][] inputData() {
        return new Object[][] {{new User("Daniel", "Test", ("dani.castano"+assignNumber()+"@taeboot.com"), "P@Tst062321")} };
    }

    /**
     *
     * @return Random number among 1 and 1000
     */
    public int assignNumber(){
        Random rand = new Random();
        return rand.nextInt(1000);
    }

}
