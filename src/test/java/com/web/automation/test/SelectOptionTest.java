package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Parent of the other classes of test.
 * @author juancarlos.ortiz
 */
public class SelectOptionTest extends BaseTest{
	
	Driver driver ;

	HomePage homepage;



	@Test(description = "Select option in the dropdown", dataProviderClass = Data.class, dataProvider = "dropDownDays")

	public void executeTest(String option){
		log.info("Open homePage");
		homepage = getHomePage();

		log.info("Selecting option from dropdown: "+option);
		homepage.getDropdownValue(option);

		log.info("the option from the dropdown is selected: "+option);
		Assert.assertEquals("Day selected :- "+option,homepage.getSelectedValue().getText());



	}





}
