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
	
	Driver driver;

	HomePage homepage;



	@Test(description = "Delete customerid", dataProviderClass = Data.class, dataProvider = "customerID")
	public void executeTest(String data){
		log.info("Open homePage");
		homepage = getHomePage();
		homepage.deleteCustomer(data);
	}



}
