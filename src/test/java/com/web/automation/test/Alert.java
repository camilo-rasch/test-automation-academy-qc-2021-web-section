package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Class for interact with Alert class
 * @author fabio.alarcon
 */

public class Alert extends BaseTest{

    private HomePage homePage;

    @Test(description = "Check the alerts functions")
    public void checkWebPageBehaviour(){
        homePage = getHomePage();
        homePage.clickInTheTextBox();
        log.info("Input some text");
        homePage.insertData("Something");
        log.info("Clicking on Submit button");
        homePage.clickOnSubmitButton();
        log.info("The text of the first alert is:");
        log.info(homePage.getTextOfAlert());
        homePage.clickOkInTheAlertButton();
        log.info("The text of the second alert is:");
        log.info(homePage.getTextOfAlert());
        homePage.clickOkInTheAlertButton();
        log.info("Assert");
        Assert.assertTrue(homePage.isSubmitButtonAvailable().isEnabled());
    }

}