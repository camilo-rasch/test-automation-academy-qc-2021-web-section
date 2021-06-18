package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homePage;

    @Test(description = "This test select one option on the dropdown list")
    public void selectOption(){
        log.info("Open the url already given");
        homePage = getHomePage();
        log.info("Select a option on the dropdown");
        homePage.selectOptionDropdown();
    }

    @Test(description = "This test validate if the option was selected")
    public void validateOptionSelected() {
        log.info("Validate if the option was select on the dropdown");
        Assert.assertTrue(homePage.isElementSelected());
    }
}
