package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
/**
 * Class for the Delete friend on facebook.
 * @author jonathan.triana
 */
public class DeleteFriend {
    public Logger log = Logger.getLogger(DeleteFriend.class);
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
    }
    @BeforeMethod()
    public void inputEmail() {
        log.info("Input right email");
    }
    @BeforeMethod()
    public void inputPassword() {
        log.info("Input right password");
    }
    @BeforeMethod()
    public void logIn() {
        log.info("Click login button");
    }
    @Test(description = "Open my profile") public void testCaseOpenMyProfile () {
        log.info("Open my profile");
    }
    @Test(description = "Open the friends section") public void testCaseOpenFriendsSection () {
        log.info("Open the friends section");
    }
    @Test(description = "Select a friend") public void testCaseSelectFriend () {
        log.info("Select a friend");
    }
    @Test(description = "Delete from my friends") public void testCaseDeleteFriends () {
        log.info("Delete from my friends");
    }
    @AfterMethod()
    public void logOut() {
        log.info("Log out");
    }
    @AfterTest()
    public void afterTest() {
        log.info("Close Browser");
    }
    @AfterSuite()
    public void afterSuite() {
        log.info("End the chrome driver");
    }
}
