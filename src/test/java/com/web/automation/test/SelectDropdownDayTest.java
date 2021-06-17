package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.web.automation.data.Data;
import com.web.automation.pages.HomePage;

public class SelectDropdownDayTest extends BaseTest {
	
	HomePage homePage;
	
	@Test(description = "Select a day and validated the selected value", dataProviderClass = Data.class, dataProvider = "days")
	public void test1(String data) {
		
		log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Select a day from Dropdown list");
        homePage.selectDropDownDay(data);
        log.info("Validate selected dropdown value");
        Assert.assertEquals(data, (homePage.getDropdownSelectedDay()));
        
	}

}
