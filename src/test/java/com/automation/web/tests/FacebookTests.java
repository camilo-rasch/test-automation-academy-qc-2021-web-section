package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
/**
 * Class for the Delete friend and change photo on facebook.
 * @author jonathan.triana
 */
public class FacebookTests {
    public Logger log = Logger.getLogger(FacebookTests.class);

    @BeforeSuite()
    public void initiateDriver() {
        log.info("Initiate the chrome driver");
    }

    @BeforeTest()
    public void openBrowser() {
        log.info("Open Browser");
    }

    @BeforeClass()
    public void openFacebook() {
        log.info("Open Facebook page with this url: https://www.facebook.com/");
        log.info("If you do not have facebook, create a new account with friends and photo");
    }
    @BeforeMethod()
    public void logIn() {
        log.info("Go to facebook login");
        log.info("Input right user");
        log.info("Input right password");
        log.info("Click login button");
    }
    @Test(description = "Open my profile") public void testCaseDeleteFriend() {
        log.info("Open my profile");
        log.info("Open the friends section");
        log.info("Select a friend");
        log.info("Delete friend from my friends");
    }
    @Test(description = "Open my profile") public void testCaseChangeMyProfile() {
        log.info("Open my profile");
        log.info("In the photo choose the 'update profile picture' option");
        log.info("Select a photo");
        log.info("Save the new picture");
    }
    @AfterMethod()
    public void logOut() {
        log.info("Log out");
    }

    @AfterTest()
    public void closeBrowser() {
        log.info("Close Browser");
    }

    @AfterSuite()
    public void endDriver() {
        log.info("End the chrome driver");
    }
}