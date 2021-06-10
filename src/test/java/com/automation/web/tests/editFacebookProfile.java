package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class editFacebookProfile {

    public Logger log = Logger.getLogger(editFacebookProfile.class);

    @BeforeTest()
    public void openBrowser() { log.info("Open the Browser"); }

    @BeforeTest()
    public void openFacebookUrl() { log.info("Open url: www.facebook.com"); }

    @Test()
    public void inputEmail() { log.info("Input the correct email"); }

    @Test()
    public void inputPassword() { log.info("Input the correct password"); }

    @Test()
    public void loginFacebook() { log.info("Click on the loguin button"); }

    @Test()
    public void goProfile() { log.info("Click on the profile name"); }

    @Test()
    public void editprofile() { log.info("Click on the Edit Profile button"); }

    @Test()
    public void changePhotoProfile() { log.info("Click on the Edit link to change the photo"); }

    @Test()
    public void singOutFacebook() { log.info("Click on the sign out button"); }

    @AfterTest()
    public void closeFacebook() { log.info("Click on the x button in the facebook tab"); }

}
