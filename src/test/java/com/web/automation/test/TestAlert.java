package com.web.automation.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.web.automation.pages.HomePage;


/**
 * Class for interact with the home page.
 * @author alejandro.giraldo
 */
public class TestAlert extends BaseTest{

    public Logger log = Logger.getLogger(BaseTest.class);
    HomePage homePage;

    @Test(description = "Test to switch to a Alert Message")
    public void testAlert(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Select and text CustomerId");
        homePage.selectCostumerIdInput();
        homePage.fillCostumeridInput("1234");
        log.info("Click on SubmitButton");
        homePage.clickOnSubmitButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Change to Alert Focus");
        Alert alert = homePage.changeAlertFocus();
        log.info("Print Alert Message");
        log.info("The Alert Message is: " + alert.getText());
        log.info("Alert Accept");
        alert.accept();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("The Alert Message is: " + alert.getText());
        log.info("Alert Ok");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.accept();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Verify Return to Home Page");
        Assert.assertTrue(homePage.verifyHomePage());

    }

}
