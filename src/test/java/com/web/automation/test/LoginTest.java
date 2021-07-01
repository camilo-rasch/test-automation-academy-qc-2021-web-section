package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.web.automation.pages.LoginPage;
import com.web.automation.test.LogOutTest;

public class LoginTest extends BaseTest{

    private HomePage homePage;
    private WebDriver loginDriver;
    private LoginPage loginpage;

    @Test(description = "LogIn Test", dataProvider = "user", dataProviderClass = Data.class)
    public void loginTest(User user){
        homePage = getHomePage();
        log.info("Focus on User Label Options");
        homePage.selectUserOptionsLabel();
        log.info("Click on Login Label Button");
        homePage.clickOnLoginLabel();
        log.info("Change to login Iframe");
        loginDriver= homePage.changeToIframe();
        loginpage = new LoginPage(loginDriver);
        log.info("Type User Name");
        loginpage.userNameSendKeys(user.getEmail());
        log.info("Type User Password");
        loginpage.userPassSendKeys();
        log.info("Click on Login Button");
        loginpage.clickOnLoginButton();
        log.info("Change to HomePage Focus");
        homePage.changeToHomeFocus();
        log.info("Focus on User Label Options");
        homePage.selectUserOptionsLabel();
        log.info("Assert User Name label Displayed");
        Assert.assertTrue(homePage.isUserNameDisplayed(), "Verify if User has loggedIn Succesfully");
    }

    @AfterMethod(alwaysRun=true)
    public void goToHomePageFocus(){

        homePage.changeToHomeFocus();


    }

}
