package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertText extends BaseTest {

    @Test(description = "Open the page, input the value an validate the alert")
    public void login_test() {
        log.info("Opening Twitter Home Page");
        HomePage homePage = getHomePage();
        HomePage clickOnCustomerIdField = homePage.clickOnCustomerIdField();
        HomePage sendKeysCustomerIdField = homePage.sendKeysCustomerIdField("34323");
        HomePage clickOnSubmitButton = homePage.clickOnSubmitButton();
        Alert alert = homePage.switchToAlert();
        String alert_text=alert.getText();
        System.out.print(alert_text);
        alert.accept();
        String alert_text2=alert.getText();
        System.out.print(alert_text2);
        alert.accept();
        homePage.getTextHomeLabel();
        Assert.assertEquals(homePage.getTextHomeLabel(),"Guru99 Bank");
    }
}

