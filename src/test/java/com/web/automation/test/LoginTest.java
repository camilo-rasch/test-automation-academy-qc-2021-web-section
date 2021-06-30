package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Parent of the other classes of test.
 * @author juancarlos.ortiz
 */
public class LoginTest extends BaseTest{
	
	Driver driver = getDriver();

	HomePage homepage;



	@Test(description = "LogIn User in ESPN Page", dataProvider = "user",dataProviderClass = Data.class)
	public void logInAccount(Object[] data) {
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
		accountPage.logOutUser();
		getHomePage().clickOnglobalButton();


		Assert.assertTrue(getHomePage().assertLogOut(),"Log out successful");
	}

}
