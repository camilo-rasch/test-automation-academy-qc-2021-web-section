package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class UnfriendSomeone {

    public Logger log = Logger.getLogger(UnfriendSomeone.class);

    @BeforeSuite
    public void HaveFacebookAccount(){ log.info("Have a facebook account"); }

    @BeforeTest()
    public void beforeTest() {
        log.info("Open Browser");
    }

    @BeforeClass()
    public void  logIn() { log.info("Log in Facebook");}

    @BeforeMethod()
    public void  selectFriend() { log.info("Go to profile and select a friend");}

    @Test(description = "Eliminate friend")
    public void clickOnUnfriend() { log.info("Click on button Friends and click on Unfriend"); }

    @AfterMethod()
    public void logOutFacebook() {
        log.info("Log out Facebook");
    }

    @AfterTest()
    public void afterTest() {
        log.info("Close Browser");
    }


}
