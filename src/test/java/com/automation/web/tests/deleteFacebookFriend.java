package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class deleteFacebookFriend {

    public Logger log = Logger.getLogger(deleteFacebookFriend.class);

    @BeforeTest()
    public void openBrowser() { log.info("Open the Browser"); }

    @BeforeTest()
    public void openFacebookUrl() { log.info("Open url: www.facebook.com"); }

    @BeforeMethod()
    public void inputEmail() { log.info("Input the correct email"); }

    @BeforeMethod()
    public void inputPassword() { log.info("Input the correct password"); }

    @Test()
    public void loginFacebook() { log.info("Click on the login button and the content page is display"); }

    @BeforeMethod()
    public void goProfile() { log.info("Click on the profile name"); }

    @BeforeMethod()
    public void goFriends() { log.info("Click on the Friends option"); }

    @BeforeMethod()
    public void selectFriend() { log.info("Select a friend"); }

    @Test()
    public void deleteFriend() { log.info("Click on the option friend delete and the friend is not displayed in the friends list"); }

    @Test()
    public void singOutFacebook() { log.info("Click on the sign out button"); }

    @AfterTest()
    public void closeFacebook() { log.info("Click on the x button in the facebook tab"); }

}
