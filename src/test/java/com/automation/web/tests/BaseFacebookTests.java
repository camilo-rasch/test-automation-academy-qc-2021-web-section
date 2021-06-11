package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;

/**
 * Class for facebook test.
 * @author norma.losada
 */
public class BaseFacebookTests {

    public Logger log = Logger.getLogger(BaseFacebookTests.class);

    @BeforeSuite()
    public void beforeSuite() {
        log.info("Suite: Tener una cuenta de facebook activa");
    }


    @BeforeTest()
    public void beforeTestB() {
        log.info("Before Test: Set up driver");
        log.info("              Open Browser");
    }

    @AfterTest()
    public void afterTestB() { log.info("After Test: Close Browser");
    }
}
