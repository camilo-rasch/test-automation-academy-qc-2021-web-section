package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homePage;

    @Test(description = "Test to handle alerts on the browser")
    public void testAlerts() {
        log.info("Opening the url already given");
        homePage = getHomePage();
        homePage.clickOnTheCustomerIDInput();
        log.info("Send value to the input");
        homePage.sendValueToTheInput("testText");
        log.info("SUbmit the text already given to the input");
        homePage.clickOnButtonSubmit();
        log.info("Switch to the alert");
        Alert alert = homePage.switchToTheAlert();
        log.info("Get the text for the first alert displayed");
        log.info(alert.getText());
        alert.accept();
        log.info("Get the text for the second alert displayed");
        log.info(alert.getText());
        alert.accept();
        log.info("The alert is closed");
    }

    @Test(description = "Test to validate the assetion")
    public void validateIfTheWebReturnToHomePage() {
        Assert.assertTrue(homePage.isInputCustomerIDDisplayed());
        log.info("Validate if the website return to the home page");
    }
}
