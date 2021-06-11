package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;


/**
 * Class for Select a friend in Facebook.
 * @author silvana.perez
 */

public class SelectFriend {

    public Logger log = Logger.getLogger(SelectFriend.class);

    @BeforeSuite
    public void beforeSuite(){log.info("Execute chrome driver");}

    @BeforeTest
    public void beforeTest(){log.info("In the browser go to www.facebook.com");}

    @BeforeClass
    public void beforeClass(){log.info("Log in to my account");}

    @BeforeMethod()
    public void  createAccount() { log.info("Go to 'My profile' option");}

    @Test(description = "Test case 1")
    public void testCaseSelectFriend() {
        log.info("Select and delete a friend");
    }

    @AfterMethod()
    public void  afterMethod() { log.info("Go out from 'My profile' option");}

    @AfterClass()
    public void  afterClass() { log.info("Log out from my account");}

    @AfterTest
    public void afterTest(){log.info("Close Browser");}

    @AfterSuite
    public void afterSuite(){log.info("Close Chrome Driver");}

}
