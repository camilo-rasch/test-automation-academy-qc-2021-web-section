package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DropdownTest extends BaseTest{

    HomePage homePage;

    @Test(description = "Test to select a option in the Dropdown and evaluate the text")
    public void test1(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on Dropdown");
        homePage.selectDropdownOption();
        Assert.assertEquals(homePage.isTheCorrectOptionSelected(), "Day selected :- Saturday");
    }
}
