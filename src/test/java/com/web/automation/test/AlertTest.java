package com.web.automation.test;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.web.automation.data.Data;
import com.web.automation.pages.HomePage;

public class AlertTest extends BaseTest{
	
	HomePage homePage;
	
	@Test(description = "Test to browser alerts", dataProviderClass = Data.class, dataProvider = "user")
	public void test1(String data) {
		
		log.info("Opening homePage");
        homePage = getHomePage();
        homePage.clickOnCustomerIdField();
        homePage.sendkeysCustomerIdField(data);
        homePage.clickOnSubmitButton();
        log.info("Switch to browser Alert");
        Alert alert = homePage.switchToAlert();
        log.info("Get and display Alert text");
        log.info(alert.getText());
        log.info("Click on OK alert button");
        alert.accept();
        log.info("Get and display Alert text");
        log.info(alert.getText());
        log.info("Click on OK alert button");
        alert.accept();
        Assert.assertTrue(homePage.isCustomerIdFieldDisplayed(), "Verify Customer ID field is present");

	}

}
