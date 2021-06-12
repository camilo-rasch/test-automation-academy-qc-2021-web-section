package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the out user test.
 * @author camilo.mogollon
 */
public class OutUserSuite {

    public Logger log = Logger.getLogger(OutUserSuite.class);

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

    @BeforeSuite
    public void esteEsUnEjemplo(){
        log.info("BeforeSuite");
    }
}
