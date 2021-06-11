package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the in user test.
 * @author fabio.alarcon
 */
public class DeleteFriends {

    public Logger log = Logger.getLogger(DeleteFriends.class);

    @BeforeSuite
    public void validateAccount(){log.info("Validate that the facebook account has friends");}

    @BeforeTest()
    public void beforeTest() {
        log.info("Open Browser");
        log.info("Open 'Facebook' app 'https://www.facebook.com'");
    }

    @BeforeMethod()
    public void  loginAccount() { log.info("Login the app \nType the username and password");}


    @Test(description = "Delete a friend")
    public void testDeleteAFriend() {
        log.info("Click on Personal profile");
        log.info("Click on 'friends' and open the full list of friends");
        log.info("Seek for a specific friend and click on 'Friends' button to eliminate as friend");
    }

    @AfterMethod()
    public void signout(){log.info("Sign out the personal session");}

    @AfterTest()
    public void afterTest() {
        log.info("Close Browser");
    }

}
