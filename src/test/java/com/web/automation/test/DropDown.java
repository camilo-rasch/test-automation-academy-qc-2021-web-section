package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test.
 * @author fabio.alarcon
 */

public class DropDown extends BaseTest{

    private HomePage homePage;

    @Test(description = "Testing dropdown")
    public void test(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on the dropdown and select an option");
        homePage.clickDropDown();
        log.info("Assert");
        Assert.assertTrue(homePage.isTuesdayVisible(),"Verify if 'Tuesday' was selected");
    }

}
