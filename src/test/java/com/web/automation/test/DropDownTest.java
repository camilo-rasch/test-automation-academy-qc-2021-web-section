package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest{

    HomePage homePage;

    @Test(description = "Test to select a value from DropDown field")
    public void test1(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on DropDown");
        Select selectDay = homePage.pickUpOption();
        log.info("Select the specific value");
        selectDay.selectByIndex(5);
        log.info("Value is selected");
        log.info("Initialize assert value");
        WebElement dropDown = homePage.dropDownAssert();
        log.info("Final Assert");
        Assert.assertEquals(true, dropDown.isDisplayed());

    }

}
