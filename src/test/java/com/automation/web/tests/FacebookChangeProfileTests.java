package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for facebook test.
 * @author norma.losada
 */
public class FacebookChangeProfileTests extends BaseFacebookTests{

    public Logger log = Logger.getLogger(FacebookChangeProfileTests.class);

    @BeforeTest()
    public void beforeTest() { log.info("Before Test: Search Facebook page and Open it");
    }

    @BeforeClass()
    public void beforeClass() { log.info("Class: Login Facebook page");
    }

    @Test(description = "Go to my profile")
    public void testAgoToMyProfile() {
        log.info("Go to my Profile Test Case");
    }

    @Test(description = "Edit profile")
    public void testBEditProfile() {
        log.info("Edit profile Test Case");
    }

    @Test(description = "Update profile picture")
    public void testCUpdateProfilePicture() {
        log.info("Update profile picture Test Case");
    }

    @AfterClass()
    public void afterClass() { log.info("After Class: Logout from Faceboook page");
    }

    @AfterTest()
    public void afterTest() { log.info("After Test: Close Faceboook page");
    }

}
