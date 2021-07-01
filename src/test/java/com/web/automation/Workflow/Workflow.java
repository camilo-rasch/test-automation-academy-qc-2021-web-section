package com.web.automation.Workflow;

import com.web.automation.data.UserInfo;
import com.web.automation.pages.*;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * General workflow  of the test cases.
 * @author fabio.alarcon
 */

public class Workflow {

    public Logger log = Logger.getLogger(Workflow.class);


    /**
     * Steps to create a new Account
     */
    public void creatingOneAccount(HomePage homePage, UserInfo userInfo) {
        log.info("Click to Sign Up button");
        NewAccount newAccount = homePage.clickToSignUp();
        log.info("Insert data to registration");
        newAccount.signUpData(userInfo.getFirstNameText(), userInfo.getLastNameText(), userInfo.getEmailText(), userInfo.getPasswordText());
        log.info("Check if the drive is in the right iframe");
        Assert.assertTrue(newAccount.isCreateAccountTitleVisible(), "Checking the iframe title");
        log.info("Click to create the new account");
        newAccount.clickToFinishRegistration();
        log.info("Confirmation of the account created");
        Assert.assertTrue(homePage.confirmationOfTheAccount(),"Checking the account profile");
    }

    /**
     * Steps to login the account
     * @param homePage Get the driver into the webpage
     * @param userInfo Get credentials
     */
    public void logInMethod(HomePage homePage, UserInfo userInfo){
        log.info("Click to general banner");
        homePage.clickOnGeneralBanner();
        log.info("Click to Log In button");
        LogIn login = homePage.clickToLogInbutton();
        log.info("Check if the drive is in the right iframe");
        Assert.assertTrue(login.isTheDriverInTheRightIframe(),"Checking the 'need help' button");
        log.info("Insert log in data");
        login.logInData(userInfo.getEmailText(), userInfo.getPasswordText());
        log.info("Click to Log in");
        login.clickToLogInWithCredentials();
        log.info("Confirmation of the log in account");
        Assert.assertTrue(homePage.confirmationOfTheAccount(),"Checking the account profile");
    }

    /**
     * Steps to logout the account
     * @param homePage Get the driver into the webpage
     */
    public void logOutMethod(HomePage homePage){
        log.info("Click on the banner");
        homePage.clickOnGeneralBanner();
        log.info("Click to log out");
        homePage.clickToSignOut();
        log.info("Confirmation of the log out");
        Assert.assertTrue(homePage.confirmationOfTheLogOut(),"Checking the sign up button");
    }

    /**
     * Steps to cancel the account
     * @param homePage Get the driver into the webpage
     */
    public void cancelAccountMethod(HomePage homePage){
        log.info("Click on the banner");
        homePage.clickOnGeneralBanner();
        log.info("Go to profile and delete account");
        CancelAccount cancelAccount = homePage.clickToProfile();
        log.info("First cancel");
        cancelAccount.cancelAccount1();
        log.info("Check the first cancel");
        Assert.assertTrue(cancelAccount.assertfirstcancel(),"Check the second button in the current iframe");
        log.info("Confirm that was canceled");
        cancelAccount.confirmCancelAccount();
        log.info("Last confirmation of the account cancel");
        cancelAccount.lastCancelConfirmation();
        log.info("Check the deactivated");
        Assert.assertEquals("ESPN: Serving sports fans. Anytime. Anywhere.",cancelAccount.cancelDeactivated());
    }
}
