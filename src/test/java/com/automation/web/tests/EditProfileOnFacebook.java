package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the out user test.
 * @author juandaniel.castano
 */
public class EditProfileOnFacebook {

    public Logger log = Logger.getLogger(EditProfileOnFacebook.class);

    @BeforeSuite()
    public void validateFacebookAccount(){ log.info("Having a Facebook account");}

    @BeforeTest()
    public void AnOpenBrowser() { log.info("Open the Browser"); log.info("Get 'https://www.facebook.com'");}

    @BeforeMethod()
    public void  goToLoginAccount() { log.info("Sign in bt typing the credentials"); log.info("Personal Profile is displayed");}

    @Test(description = "Select a photo from the gallery")
    public void setPhotoProfile() {
        log.info("Clicking on 'Photo editing' button");
        log.info("Search for a photo");
        log.info("Click on set image as photo profile");
    }
    
    @AfterMethod
    public void  signOutTheAccount() { log.info("The new photo profile is changed"); log.info("Sign out from Facebook account");}

    @AfterTest()
    public void closeBrowser() {
        log.info("Close the Browser");
    }
}
