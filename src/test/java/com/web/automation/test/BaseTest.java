package com.web.automation.test;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * TestNG Taller
 * @author `lina.gallego`
 */
public class BaseTest {

	public Logger log = Logger.getLogger(BaseTest.class);
	
	
	@BeforeSuite(description = "Before Suite")
	public void beforeTest() {
		log.info("****BeforeSuite****");
		log.info("Open browser");

	}

	@BeforeMethod()
	public void facebookLogin() {
		log.info("***** Before Method Log In*************************");
		log.info("Select and enter the Email/Phone Number field");
		log.info("Select and enter the Password");
		log.info(" click on the button 'Log In'");
		log.info("Change to Facebook Main Page");
		log.info("******User Logged in******************");
		log.info("******My Profile******************");
		log.info("Find and click on my Name icon to change to profile page");

	}

	@Test(priority = 1)
	public void DeleteAFriend(){
		log.info("*****Test 1********************");
		log.info("Find and click on Friends option");
		log.info("Find the friend will be deleted");
		log.info("Find and click on the 3 points inline block option");
		log.info("Find and  click on the 'Unfriend' option in the list");
		log.info("Change to the modal popup ");
		log.info("Find and  click on 'Confirm' button ");

	}
	@Test(priority = 2)
	public void changeProfilePicture(){
		log.info("*****Test 2********************");
		log.info("Find and click on The camera icon to change the picture");
		log.info("Change to the 'Update Profile Picture' popup ");
		log.info("Find and click on a picture ");
		log.info("Change to the Modal to update picture size ");
		log.info("Find and click on 'Save' button ");
		log.info("Change to the Modal to confirm ");
		log.info("Find and click on 'OK' button ");

	}

	@AfterMethod()
	public void Logout() {
		log.info("After Method********************");
		log.info("Find and click on the down arrow ");
		log.info("Change to the iframe ");
		log.info("Find and click on 'Log Out' option from the list ");

	}

	@AfterSuite()
	public void closingBrowser() {
		log.info("*****After Suite********************");
		log.info("Close browser");

	}
	


}
