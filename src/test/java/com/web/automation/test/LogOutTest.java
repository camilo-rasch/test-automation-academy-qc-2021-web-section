package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.AccountPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LogInPage;
import com.web.automation.pages.SignUpPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Parent of the other classes of test.
 * @author juancarlos.ortiz
 */
public class LogOutTest extends BaseTest{
	
	Driver driver = getDriver();

	HomePage homepage;

	@Test(description = "LogOut User in ESPN Page", dataProvider = "user",dataProviderClass = Data.class)
	public void LogOut(Object[] data) {
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


		Assert.assertEquals(accountPage.getDisplayNameText().getText(),"Welcome"+user.getFirstName()+"!");
		log.info("Account Created successfully");
		accountPage.logOutUser();
		log.info("Click on LogOut Button");
		homepage.clickOnElement(getHomePage().getGlobalUserButton());
		Assert.assertTrue(getHomePage().assertLogOut(),"The user logged out correctly");
		log.info("User logged out successfully");


	}







}
