package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for facebook test.
 * @author norma.losada
 */
public class FacebookDeleteFriendTests extends BaseFacebookTests{

    public Logger log = Logger.getLogger(FacebookDeleteFriendTests.class);

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

    @Test(description = "Go to my friends and search one")
    public void testBgoToMyFriendsAndSearch() {
        log.info("Go to my friends and Search one friend Test Case");
    }

    @Test(description = "Select a friend")
    public void testCaseSelectFriend() {
        log.info("Select a friend");
    }

    @Test(description = "Remove a Friend")
    public void testRemoveFriend() {
        log.info("Remove a Friend");
    }

    @AfterClass()
    public void afterClass() { log.info("After Class: Logout from Faceboook page");
    }

    @AfterTest()
    public void afterTest() { log.info("After Test: Close Faceboook page");
    }
}
