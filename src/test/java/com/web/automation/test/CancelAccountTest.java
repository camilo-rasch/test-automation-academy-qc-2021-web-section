package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CancelAccountTest extends BaseTest{

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
        log.info("Click on Espn Profile Label Button");
        homePage.clickOnProfileLabel();
        log.info("Focus to Profile Iframe");
        homePage.changeToIframe();
        log.info("Click on Delete Account label");
        homePage.clickOnDeleteAccount();
        log.info("Click on Confirm Delete Account label");
        homePage.clickOnConfirmDeleteAccount();
        Assert.assertFalse(homePage.isLabelDeletedAccountDisplayed(), "Verify if User has loggedIn Succesfully");
    }

}
