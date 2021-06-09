package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the in user test.
 * @author juandaniel.castano
 */
public class DeleteFriendOnFacebook {

    public Logger log = Logger.getLogger(DeleteFriendOnFacebook.class);

    @BeforeSuite()
    public void validateFacebookAccount(){ log.info("Having a Facebook account");}

    @BeforeTest()
    public void AnOpenBrowser() { log.info("Open the Browser"); }

    @BeforeTest()
    public void getFacebookWebPage() { log.info("Get 'https://www.facebook.com'"); }

    @BeforeMethod()
    public void  goToLoginAccount() { log.info("Sign in Type the credentials");}

    @BeforeMethod()
    public void goToPersonalProfile() {
        log.info("Personal Profile is displayed");
    }

    @BeforeMethod()
    public void openTheFriendsList() {
        log.info("The full list of friends is opened");
    }

    @Test(description = "Select a friend to be deleted")
    public void selectAFriendToDelete() {
        log.info("Clicking On 'Eliminate' button of friend to be deleted");
    }

    @AfterMethod
    public void deletingAFriend() {
        log.info("The Friend is deleted from friends list");
    }

    @AfterMethod
    public void  signOutTheAccount() { log.info("Sign out from Facebook account");}

    @AfterTest()
    public void closeBrowser() {
        log.info("Close the Browser");
    }
}
