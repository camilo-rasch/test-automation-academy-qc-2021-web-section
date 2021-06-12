package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class ChangeProfilePictureSuite {

    public Logger log = Logger.getLogger(ChangeProfilePictureSuite.class);


    @BeforeTest()
    public void beforeTest() {
        log.info("Open Browser");
    }

    @BeforeClass()
    public void  logInFacebook() { log.info("Log in Facebook");}

    @BeforeMethod()
    public void  selectMyProfile() { log.info("Go to my profile");}

    @Test(description = "Change profile picture")
    public void changeProfilePicture() { log.info("Click on Edit Profile and change profile picture"); }

    @AfterMethod()
    public void logOutFacebook() {
        log.info("Log out Facebook");
    }

    @AfterTest()
    public void afterTest() {
        log.info("Close Browser");
    }

}
