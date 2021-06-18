package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Parent of the other classes of test.
 * @author juancarlos.ortiz
 */
public class DeleteCustomerTest extends BaseTest{
	
	Driver driver = getDriver();

	HomePage homepage;



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
