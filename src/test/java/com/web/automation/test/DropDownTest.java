package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest{

    @Test(description = "Test that select an option from a DropDown")
    public void testCaseDropdown(){
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Sunday option selected from DropDown");
        homePage.selectDropDown();
    }
}
