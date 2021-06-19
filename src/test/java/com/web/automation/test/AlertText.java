package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertText extends BaseTest {

    @Test(description = "Open the page, input the value an validate the alert")
    public void alert_test() {
        log.info("Opening Twitter Home Page");
        HomePage homePage = getHomePage();
        log.info("Click on customer id field");
        homePage.clickOnCustomerIdField();
        log.info("Input customer id");
        homePage.sendKeysCustomerIdField("34323");
        log.info("Click on submit button");
        homePage.clickOnSubmitButton();
        log.info("Switch to first alert popup");
        Alert alert = homePage.switchToAlert();
        log.info("* Alert first message * ----"+alert.getText());
        log.info("Accept in the alert");
        alert.accept();
        log.info("* Alert second message * ---"+alert.getText());
        log.info("Accept in the alert");
        alert.accept();
        log.info("Assert to verify that we are on the main context");
        homePage.getTextHomeLabel();
        Assert.assertEquals(homePage.getTextHomeLabel(),"Guru99 Bank");
    }
}

