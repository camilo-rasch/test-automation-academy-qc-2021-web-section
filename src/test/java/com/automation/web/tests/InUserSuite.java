package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Class for the in user test.
 * @author camilo.mogollon
 */
public class InUserSuite {

    public Logger log = Logger.getLogger(InUserSuite.class);

    @BeforeTest()
    public void beforeTest() {
        log.info("Open Browser");
    }

    @AfterTest()
    public void afterTest() {
        log.info("Close Browser");
    }

    @BeforeMethod()
    public void  createAccount() { log.info("Create account");}

    @Test(description = "Cancel Account Test Case")
    public void testCaseCancelAccount() {
        log.info("Cancel Account Test Case");
    }

    @Test(description = "Log Out Test Case")
    public void testCaseLogOut() {
        log.info("Log Out Test Case");
    }

}
