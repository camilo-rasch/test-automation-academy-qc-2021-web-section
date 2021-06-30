package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.AccountPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LogInPage;
import com.web.automation.pages.SignUpPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Parent of the other classes of test.
 * @author juancarlos.ortiz
 */
public class LogInTest extends BaseTest{
	
	Driver driver = getDriver();

	HomePage homepage;

	@Test(description = "LogIn User in ESPN Page", dataProvider = "user",dataProviderClass = Data.class)
	public void createAccount(Object[] data) {
		homepage = getHomePage();
		User  user = (User) data[0];
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

		accountPage.logOutUser();
		log.info("Click on LogOut Button");

		homepage.clickOnElement(getHomePage().getGlobalUserButton());
		Assert.assertTrue(getHomePage().assertLogOut(),"Log out correctly");


		log.info("Click on global User Button");
		logInPage = homepage.clickOnLoginButton();
		log.info("Click on LogIn Button");
		logInPage.fillLogInFields(user.getEmail(), user.getPassword());
		log.info("Enter Username and password");
		accountPage = logInPage.clickOnLogInButton();
		log.info("Click on LogIn Button");
		accountPage.clickOnElement(accountPage.getGlobalUserButton());
		Assert.assertEquals(accountPage.getDisplayNameText().getText(),"Welcome"+user.getFirstName()+"!");
		log.info("User logged in correctly");
		accountPage.logOutUser();
		homepage.clickOnElement(getHomePage().getGlobalUserButton());
		Assert.assertTrue(getHomePage().assertLogOut(),"The user logged out correctly");
	}











}
