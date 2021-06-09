package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteFacebookFriend {
	
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
	    
	    @Test(priority = 5, description = "Click on Friends option")
	    public void testCaseFacebookFriends() {
	        log.info("Click on Friends option");
	    }
	    
	    @Test(priority = 6, description = "Search friend")
	    public void testCaseSearchFriend() {
	        log.info("Search the friend you want to delete");
	    }
	    
	    @Test(priority = 7, description = "Click on Friend Profile")
	    public void testCaseFriendProfile() {
	        log.info("Click on your Friend Profile");
	    }
	    
	    @Test(priority = 8, description = "Click on Friends option")
	    public void testCaseFriendOption() {
	        log.info("In your Friend Profile, click on Friends option");
	    }
	    
	    @Test(priority = 9, description = "Click on delete Friend option")
	    public void testCaseDeleteFriend() {
	        log.info("Click on delete Friend option");
	    }
	    
	    @Test(priority = 10, description = "Click on confirm option")
	    public void testCaseConfirmDeleteFriend() {
	        log.info("Click on confirm delete friend");
	    }
	    
	    @Test(priority = 11, description = "Log out Facebook")
	    public void testCaseLogOutFacebook() {
	        log.info("Log out Facebook");
	    }
}
