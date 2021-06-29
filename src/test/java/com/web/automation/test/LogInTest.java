package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Parent of the other classes of test.
 * @author juancarlos.ortiz
 */
public class LogInTest extends BaseTest{
	
	Driver driver = getDriver();

	HomePage homepage;

	@BeforeMethod(alwaysRun = true)
	public void createAccount(Object[] data) {
		User user = (User) data[0];
	}

	@Test(description = "Delete customerid", dataProviderClass = Data.class, dataProvider = "customerID")

	public void executeTest(String data){
		log.info("Open homePage");
		homepage = getHomePage();

		homepage.clickOnElement(homepage.getCustomerIdField());
		homepage.getCustomerIdField().sendKeys(data);
		log.info("entering customerId: "+data);
		homepage.clickOnElement(homepage.getSubmitButton());
		log.info("click on submit button");
		Alert alert= homepage.switchToAlert();
		log.info("switch to alert");
		log.info("printing in console the alert text");
		log.info(alert.getText());
		alert.accept();
		log.info("Accept in alert button");
		log.info("print alert response");
		log.info(alert.getText());
		alert.accept();
		log.info("Accept on the alert");
		Assert.assertTrue(homepage.getCustomerIdField().isDisplayed(),"The home page loaded as expected");


	}





}
