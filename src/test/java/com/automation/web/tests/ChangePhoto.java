package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
/**
 * Class for the Change my profile picture on facebook.
 * @author jonathan.triana
 */
public class ChangePhoto {
    public Logger log = Logger.getLogger(ChangePhoto.class);
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
    @Test(description = "Open my profile") public void testCaseOpenMyProfile() {
        log.info("Open my profile");
    }
    @Test(description = "Update profile picture") public void testCaseUpdateProfilePicture() {
        log.info("In the photo choose the update profile picture option");
    }
    @Test(description = "Select a photo") public void testCaseSelectPhoto() {
        log.info("Select a photo");
    }
    @Test(description = "Save the new picture") public void testCaseSavePicture() {
        log.info("Save the new picture");
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
