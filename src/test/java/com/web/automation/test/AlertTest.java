package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    @Test(description = "Test that captures an alert and print the message in cosole")
    public void testCaseDropdown(){
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Capture an alert");
        homePage.capturingAlerts("123");
        log.info("Capture and alert message");
        homePage.capturingAlertMessages();
    }
}
