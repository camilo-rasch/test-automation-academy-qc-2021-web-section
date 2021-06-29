package com.web.automation.test;

import com.web.automation.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test.
 * @author fabio.alarcon
 */

public class AccountManagement extends BaseTest{

    private HomePage homePage;


//    @Test(description = "Sign up")
//    public void testFirstSingUp(){
//        log.info("Opening homePage");
//        homePage = getHomePage();
//        log.info("Click to Sign Up button");
//        NewAccount newAccount = homePage.clickToSignUp();
//        log.info("Insert data to registration");
//        newAccount.signUpData();
//        log.info("Check if the drive is in the right iframe");
//        Assert.assertTrue(newAccount.isCreateAccountTitleVisible(), "Checking the iframe title");
//        log.info("Click to create the new account");
//        newAccount.clickToFinishRegistration();
//        log.info("Confirmation of the account created");
//        Assert.assertTrue(homePage.confirmationOfTheAccount(),"Checking the account profile");
//    }


    @Test(description = "Log In the session", groups = {"Log In Test", "Log Out Test", "Cancel Account"})
    public void testLogIn(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click to general banner");
        homePage.clickOnGeneralBanner();
        log.info("Click to Log In button");
        LogIn login = homePage.clickToLogInbutton();
        log.info("Check if the drive is in the right iframe");
        Assert.assertTrue(login.isTheDriverInTheRightIframe(),"Checking the 'need help' button");
        log.info("Insert log in data");
        login.logInData();
        log.info("Click to Log in");
        login.clickToLogInWithCredentials();
        log.info("Confirmation of the log in account");
        Assert.assertTrue(homePage.confirmationOfTheAccount(),"Checking the account profile");
    }


    @Test(description = "Log Out the session", groups = {"Log In Test", "Log Out Test"})
    public void testLogOut(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on the banner");
        homePage.clickOnGeneralBanner();
        log.info("Click to log out");
        homePage.clickToSignOut();
        log.info("Confirmation of the log out");
        Assert.assertTrue(homePage.confirmationOfTheLogOut(),"Checking the sign up button");
    }


    @Test(description = "Cancel Account", groups = {"Cancel Account"})
    public void testZzCancelAccount(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on the banner");
        homePage.clickOnGeneralBanner();
        log.info("Go to profile and delete account");
        CancelAccount cancelAccount = homePage.clickToProfile();
        log.info("First cancel");
        cancelAccount.cancelAccount1();
        log.info("Confirm that was canceled");
        cancelAccount.confirmCancelAccount();
        log.info("Last confirmation of the account cancel");
        cancelAccount.lastCancelConfirmation();
        log.info("Check the deactivated");
        Assert.assertTrue(cancelAccount.confirmationOfTheAccountDeactivated(),"Check that the account is deactivated");
    }
}
