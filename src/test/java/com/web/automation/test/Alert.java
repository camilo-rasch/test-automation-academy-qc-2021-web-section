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
    public void checkWebPagebehaviour(){
        homePage = getHomePage();
        homePage.clickInTheTextBox();
        homePage.insertData("Something");
        homePage.clickOnSubmitButton();
        log.info(homePage.getTextOfAlert());
        homePage.clickOkInTheAlertButton();
        log.info(homePage.getTextOfAlert());
        homePage.clickOkInTheAlertButton();
        Assert.assertTrue(homePage.isSubmitButtonAvailable().isEnabled());
    }

}