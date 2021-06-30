package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.*;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Parent of the other classes of test.
 * @author juancarlos.ortiz
 */
public class CancelAccountTest extends BaseTest{
	
	Driver driver = getDriver();

	HomePage homepage;

	@Test(description = "Cancel user", dataProvider = "user",dataProviderClass = Data.class)
	public void cancelAccount(Object[] data) {
		homepage = getHomePage();
		User user = (User) data[0];
		homepage.clickOnElement(getHomePage().getGlobalUserButton());
		log.info("Click on global User Button");
		LogInPage logInPage = homepage.clickOnLoginButton();



		log.info("Click on Log In Button");
		SignUpPage signUpPage = logInPage.clickOnSignUpButton();

		log.info("Click on SignUp Button");

		signUpPage.createUser(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
		log.info("Fields filled out");
		AccountPage accountPage = signUpPage.clickOnNewSignInButton();
		log.info("Click on SignUp Button");
		accountPage.clickOnElement(accountPage.getGlobalUserButton());


		Assert.assertEquals(accountPage.getDisplayNameText().getText(), "Welcome" + user.getFirstName() + "!");
		log.info("Account Created successfully");

		ProfilePage profilePage = accountPage.clickOnProfileButton();
		profilePage.waitElementVisibility(profilePage.getEmailText());
		Assert.assertEquals(profilePage.getEmailText().getText(), user.getEmail());
		profilePage.deleteAccount();
		log.info("Click on Delete Account Confirmation Button");


		homepage.clickOnElement(getHomePage().getGlobalUserButton());
		log.info("Click on global User Button");
		logInPage = homepage.clickOnLoginButton();
		log.info("Click on LogIn Button");
		logInPage.checkDeactivatedAccount(user.getEmail(),user.getPassword());
		Assert.assertTrue(logInPage.assertDeactivatedAccount(), "Account Deactivated");
		log.info("Account cancelled successfully");

	}





}
