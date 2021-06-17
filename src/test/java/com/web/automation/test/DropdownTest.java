package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Dropdown Test.
 *
 * @author jonathan.triana
 */
public class DropdownTest extends BaseTest {

    @Test(description = "Select a day in a dropdown an verify the label ")
    public void select_test() {
        log.info("Opening Selenium Easy Home Page");
        HomePage homePage = getHomePage();
        HomePage homePage2 = homePage.selectDropdownValue("Wednesday");
        Assert.assertEquals(homePage.getTextLabelDropdownValue(),"Day selected :- Wednesday");

    }
}
