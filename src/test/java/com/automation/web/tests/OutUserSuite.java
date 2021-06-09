package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Class for the out user test.
 * @author juan.montes
 */
public class OutUserSuite {

    public Logger log = Logger.getLogger(InUserSuite.class);

    @BeforeTest()
    public void beforeTest() {
        log.info("Open Browser");
    }

    @AfterTest()
    public void afterTest() {
        log.info("Close Browser");
    }

    @BeforeMethod
    public void  createAccount() { log.info("Create account and log out");}

    @AfterMethod
    public void logOut() {
        log.info("Log Out");
    }

    @Test(description = "Log In Test Case")
    public void testCaseLogIn() {
        log.info("Log In Test Case");
    }

}
