package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
		homepage.clickOnElement(getHomePage().getGlobalUserButton());
		log.info("Click on global User Button");

		LogInPage logInPage = homepage.clickOnLoginButton();
		log.info("Click on LogIn Button");
		logInPage.fillLogInFields(getAccountEmail(), getAccountPassword());
		log.info("Enter Username and password");
		AccountPage accountPage = logInPage.clickOnLogInButton();
		log.info("Click on LogIn Button");
		accountPage.clickOnElement(accountPage.getGlobalUserButton());
		Assert.assertEquals(accountPage.getDisplayNameText().getText(),"Welcome"+getAccountFirstName()+"!");
		log.info("User logged in correctly");

		ProfilePage profilePage = accountPage.clickOnProfileButton();
		profilePage.waitElementVisibility(profilePage.getEmailText());
		Assert.assertEquals(profilePage.getEmailText().getText(), getAccountEmail());
		profilePage.deleteAccount();
		log.info("Click on Delete Account Confirmation Button");


		homepage.clickOnElement(getHomePage().getGlobalUserButton());
		log.info("Click on global User Button");
		logInPage = homepage.clickOnLoginButton();
		log.info("Click on LogIn Button");
		logInPage.checkDeactivatedAccount(getAccountEmail(),getAccountPassword());
		Assert.assertTrue(logInPage.assertDeactivatedAccount(), "Account Deactivated");
		log.info("Account cancelled successfully");
		logInPage.backToHomePage();



	}









}
