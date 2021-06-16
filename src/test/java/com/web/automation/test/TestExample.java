package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample extends BaseTest {

    @Test()
    public void firstTest() {
        HomePage homePage = getHomePage();
        Assert.assertTrue(homePage.isLoginButtonDisplayed(), "The login button is not displayed");
        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.setUsername("something");
    }
}
