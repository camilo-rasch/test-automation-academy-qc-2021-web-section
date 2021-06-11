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
    public void AnOpenBrowser() { log.info("Open the Browser"); log.info("Get 'https://www.facebook.com'");}

    @BeforeMethod()
    public void  goToLoginAccount() { log.info("Sign in bt typing the credentials"); log.info("Personal Profile is displayed");}

    @Test(description = "Select a friend to be deleted")
    public void selectAFriendToDelete() {
        log.info("Clicking on 'Friends' button to display the full list of friends");
        log.info("Clicking On 'Eliminate' button of friend to be deleted");
    }

    @AfterMethod
    public void  signOutTheAccount() { log.info("The Friend is deleted from friends list"); log.info("Sign out from Facebook account");}

    @AfterTest()
    public void closeBrowser() {
        log.info("Close the Browser");
    }
}
