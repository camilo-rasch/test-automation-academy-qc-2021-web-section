package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for facebook test.
 * @author norma.losada
 */
public class FacebookTests extends BaseFacebookTests{

    public Logger log = Logger.getLogger(FacebookTests.class);

    @BeforeTest()
    public void beforeTest() { log.info("Before Test: Search Facebook page and Open it");
    }

    @BeforeClass()
    public void beforeClass() { log.info("Before Class: Login Facebook page");
    }

    @BeforeMethod()
    public void beforeMethod() { log.info("Before Method: Go to my Facebook Profile");
    }


    @Test(description = "Update profile picture")
    public void testAUpdateProfile() {
        log.info("Step 1: Edit profile");
        log.info("Step 2: Update profile picture");
    }

    @Test(description = "Remove a Friend")
    public void testBgoToMyFriendsAndSearch() {
        log.info("Step 1: Go to my friends and Search one friend");
        log.info("Step 2: Select a friend");
        log.info("Step 3: Remove a Friend");
    }

    @AfterClass()
    public void afterClass() { log.info("After Class: Logout from Faceboook page");
    }

    @AfterTest()
    public void afterTest() { log.info("After Test: Close Faceboook page");
    }

}
