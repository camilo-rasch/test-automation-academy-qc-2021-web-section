package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the out user test.
 * @author juandaniel.castano
 */
public class EditProfileOnFacebook {

    public Logger log = Logger.getLogger(EditProfileOnFacebook.class);

    @BeforeTest()
    public void AnOpenBrowser() { log.info("Open the Browser"); }

    @BeforeTest()
    public void getFacebookWebPage() { log.info("Get 'https://www.facebook.com'"); }

    @BeforeMethod()
    public void  loginAccount() { log.info("Sign in Type the credentials");}

    @BeforeMethod()
    public void personalProfile() {
        log.info("Personal Profile is displayed");
    }

    @BeforeMethod()
    public void photoProfile() {
        log.info("Photo editing is displayed");
    }

    @BeforeMethod()
    public void selectPhotoProfile() {
        log.info("Search for a photo");
    }

    @Test(description = "Select a photo from the gallery")
    public void setPhotoProfile() {
        log.info("Click on set image as photo profile");
    }

    @AfterMethod
    public void savingNewPhotoProfile() {
        log.info("The new photo profile is changed");
    }

    @AfterMethod
    public void  signOutTheAccount() { log.info("Sign out from Facebook account");}

    @AfterTest()
    public void closeBrowser() {
        log.info("Close the Browser");
    }
}
