package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.*;
import com.web.automation.steps.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Parent of the other classes of test.
 * @author juandaniel.castano
 */

public class ESPNTest extends BaseTest{

     private HomePage homePage;
     private Step steps = new Step();

    /**
     * Method to create a new ESPN account
     * @param data received by @DataProvider
     */

    @BeforeMethod(alwaysRun = true)
    public void createESPNAccount(Object[] data){

        User user = (User) data[0];
        homePage = getHomePage();
        steps.signUpProcess(homePage, user);
        steps.signOutProcess(homePage);
    }

    /**
     * Method to logIn to ESPN webpage
     * @param user To get values of the User object's variables
     */

    @Test(description = "Login To ESPN Webpage", dataProvider = "ESPNUser", dataProviderClass = Data.class)
    public void logInToESPN(User user){

        homePage = getHomePage();
        steps.signInProcess(homePage, user);
        steps.signOutProcess(homePage);

    }

    /**
     * Method to logOut to ESPN webpage
     * @param user To get values of the User object's variables
     */

    @Test(description = "LogOut From ESPN Webpage", dataProvider = "ESPNUser", dataProviderClass = Data.class)
    public void logOutFromESPN(User user){

        homePage = getHomePage();
        steps.signInProcess(homePage, user);
        steps.signOutProcess(homePage);

    }

    /**
     * Method to delete ESPN webpage
     * @param user To get values of the User object's variables
     */

    @Test(description = "Delete the ESPN account", dataProvider = "ESPNUser", dataProviderClass = Data.class)
    public void tryToDeleteESPNAccount(User user){

        homePage = getHomePage();
        steps.signInProcess(homePage, user);
        steps.deleteESPNAccountProcess(homePage);

    }

}
