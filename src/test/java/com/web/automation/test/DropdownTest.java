package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.Assert;
import com.web.automation.data.Data;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

/**
 * Dropdown Test.
 *
 * @author jonathan.triana
 */
public class DropdownTest extends BaseTest {
    HomePage homePage;
    String assertLabel="Day selected :- Wednesday";

    @Test(description = "Select a day in a dropdown an verify the label ",dataProviderClass = Data.class, dataProvider = "day")
    public void select_test(String data) {
        log.info("Opening Selenium Easy Home Page");
        homePage = getHomePage();
        log.info("Selecting dropdown and choose a day");
        homePage.selectDropdownValue(data);
    }
    @Test(description = "Select a day in a dropdown an verify the label ")
    public void validate_text() throws InterruptedException {
        log.info("Assert to compare the value selected");
        Assert.assertEquals(homePage.getTextLabelDropdownValue(),assertLabel);
        log.info("A sleep to see the value selected before close the page");
        sleep(2000);
    }
}
