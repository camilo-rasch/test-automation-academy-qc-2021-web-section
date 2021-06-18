package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    HomePage homePage;

    @Test(description = "Insert a valid data in the Customer ID")
    public void aTestInsertvalidData(){
        log.info("Opening the HomePage url");
        homePage = getHomePage();
        log.info("Inserting text in Customer ID");
        homePage.insertDataCustomerID("something");

    }

    @Test(description = "Click on Submit button")
    public void bTestClickOnSubmit(){
        log.info("Doing click on Submit button");
        homePage.clickOnSubmitButton();
    }

    @Test(description = "Capture and print alert message")
    public void cTestCaptureAndPrintAlertMessage() {
        log.info("Capture and print alert message");
        homePage.CaptureAndPrintAlertMessage();
    }


    @Test(description = "Click on the Alert OK button")
    public void dtestClickAlertOkButton() {
        log.info("click on the OK button in the alert");
        homePage.ClickAlertOkButton();
    }

    @Test(description = "Capture and print second alert message")
    public void eTestCaptureAndPrintSecondAlertMessage() {
        log.info("Capture and print second alert message ");
        homePage.CaptureAndPrintSecondAlertMessage();
    }
    @Test(description = "Click on the Alert OK button")
    public void ftestClickSecondAlerOktButton() {
        log.info("click on the second OK button in the alert");
        homePage.ClickSecondAlertOkButton();
    }

    @Test(description = "Verify the page return to the main page")
    public void gtestReturnMainPage() {
        log.info("Return to the main page");
        Assert.assertTrue(homePage.isSubmitDisplayed());
    }
}
