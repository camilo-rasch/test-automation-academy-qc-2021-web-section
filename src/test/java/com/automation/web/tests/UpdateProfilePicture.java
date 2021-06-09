package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateProfilePicture {
	
	 public Logger log = Logger.getLogger(InUserSuite.class);
		
	 @BeforeTest()
	    public void beforeTest() {
	        log.info("Open Browser");
	    }

	    @AfterTest()
	    public void afterTest() {
	        log.info("Close Browser");
	    }

	    @BeforeClass()
	    public void  existingAccount() { log.info("Existing and active Facebook account");}
	    
	    @Test(priority = 1, description = "Write a correct email or phone number")
	    public void testCaseEmailField() {
	        log.info("Write a correct email or phone number");
	    }

	    @Test(priority = 2, description = "Write a correct password")
	    public void testCasePasswordField() {
	        log.info("Write a correct password");
	    }
	    
	    @Test(priority = 3, description = "Click on Login Button")
	    public void testCaseFacebookLogin() {
	        log.info("Click on Login Button");
	    }
	    
	    @Test(priority = 4, description = "Click on your profile")
	    public void testCaseFacebookProfile() {
	        log.info("Click on your profile");
	    }
	    
	    @Test(priority = 5, description = "Click on Camera icon")
	    public void testCaseFacebookProfilePicture() {
	        log.info("Click on Camera icon");
	    }
	    
	    @Test(priority = 6, description = "Select a new profile picture")
	    public void testCaseSelectPicture() {
	        log.info("Select a new profile picture");
	    }
	    
	    @Test(priority = 7, description = "Arrange new profile picture")
	    public void testCaseArrangePicture() {
	        log.info("Arrange new profile picture");
	    }
	    
	    @Test(priority = 8, description = "Click on save option")
	    public void testCaseSavePictureOption() {
	        log.info("Click on save option");
	    }
	    
	    @Test(priority = 9, description = "Click on confirm option")
	    public void testCaseConfirmNewPicture() {
	        log.info("Click on confirm change picture profile");
	    }
	    
	    @Test(priority = 10, description = "Log out Facebook")
	    public void testCaseLogOutFacebook() {
	        log.info("Log out Facebook");
	    }

	
}
