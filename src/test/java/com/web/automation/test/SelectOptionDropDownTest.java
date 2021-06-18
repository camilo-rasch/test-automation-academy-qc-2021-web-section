package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectOptionDropDownTest extends BaseTest{

    HomePage homePage;


    @Test(description = "Test to select an option from DropDown")
    public void testSelectOption(){
        log.info("Open the url and select the dropdown option");
        homePage = getHomePage();
        homePage.selectOptionFromDropDown();
    }

    @Test(description = "Test to validate the option was selected")
    public void testValidateSelectedOption(){
        log.info("Verify the option was selected");
        Assert.assertTrue(homePage.isSelectedDayDisplayed());
    }

}
