package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginPage;
import com.web.automation.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {


    private HomePage homePage;
    private WebDriver loginDriver;
    private LoginPage loginpage;

    @BeforeTest(alwaysRun=true)
    public void logIn(){

    }

    @Test(description = "LogOut Test", dataProvider = "user", dataProviderClass = Data.class)
    public void logOutTest(User user){
        homePage = getHomePage();
        log.info("Focus on User Label Options");
        homePage.waitImplicit(2);
        homePage.selectUserOptionsLabel();
        log.info("Click on LogOut Label Button");
        homePage.clickOnLogOutLabel();
        log.info("Focus on User Label Options");
        homePage.selectUserOptionsLabel();
        Assert.assertFalse(homePage.isUserNameDisplayed(), "Verify if User has loggedIn Succesfully");

    }

}
