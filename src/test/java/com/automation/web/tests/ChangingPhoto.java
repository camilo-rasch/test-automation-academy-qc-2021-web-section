package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the out user test.
 * @author fabio.alarcon
 */
public class ChangingPhoto {

    public Logger log = Logger.getLogger(ChangingPhoto.class);

    @BeforeSuite
    public void validateAccount(){log.info("Validate that the facebook account has friends");}

    @BeforeTest()
    public void beforeTest() {
        log.info("Open Browser");
    }

    @BeforeTest()
    public void beforeTest2() {
        log.info("Open 'Facebook' app");
    }

    @BeforeMethod()
    public void  loginAccount() { log.info("Login the app \nType the username and password \nClick on 'Sing in session' button");}

    @BeforeMethod()
    public void  profile() { log.info("Click on Personal profile");}

    @Test(description = "Changing the profile photo")
    public void testChanchingPhoto() {
        log.info("Click on the 'camera' icon and select");
        log.info("Click on 'Select profile picture' option");
        log.info("Allow to the device access to the photos repository and select a photo");
    }

    @AfterMethod()
    public void signout(){log.info("Sign out the personal session");}

    @AfterTest()
    public void afterTest() {
        log.info("Close Browser");
    }

}
