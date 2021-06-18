package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    private HomePage homePage;

    @Test(description = "Validating the elements within the alert")
    public void inputData(){
        log.info("Get the URL");
        homePage = getHomePage();
        log.info("Click on Text-Box to validate Availability");
        homePage.clickOnTheTextBox();
        log.info("Insert Text");
        homePage.insertData("AlertTest");
        log.info("Click on Submit button");
        homePage.clickOnSubmitButton();
        log.info("Get the text from the Alert");
        log.info(homePage.popupGetText());
        log.info("Click on 'Accept' button from Alert");
        homePage.clickOnAcceptButtonAlert();
        log.info("Get the text from the Alert");
        log.info(homePage.popupGetText());
        log.info("Click on 'Ok' button from Alert");
        homePage.clickOnAcceptButtonAlert();
        log.info("Assertion to validate 'Default Content'");
        Assert.assertTrue(homePage.isSubmitButtonAvailable().isEnabled());
    }

}
