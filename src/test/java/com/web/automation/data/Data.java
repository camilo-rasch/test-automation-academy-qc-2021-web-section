package com.web.automation.data;

import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Data provider class.
 * @author Jonathan.Triana
 */
public class Data {
    //I really tried to use this data provider in the before method but it was not possible :(
    @DataProvider(name="data")
    public static Object[][] getData() {

        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HHmmss", Locale.ENGLISH));
        String randomEmail="jonathantest"+time+"email"+"@mail.com";

        return new Object[][]{{"Jonathan", "Triana",randomEmail,"pass"}
        };
    }
    
    // Data provider to use in the log in @Test
    @DataProvider(name="data1")
    public static Object[][] getData1() {
        return new Object[][]{{"Userespn@espnespnespn.com","User123"}
        };
    }
}