package com.web.automation.test;

import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class EspnTest extends BaseTest {
/*
    @Test(description = "Open Espn page")
    public void espn_test() throws InterruptedException {
        log.info("Click on user option to log in");
        getHomePage().clickOnUserIcon();
        log.info("Click on Log in option");
        getHomePage().clickOnLogIn();
        log.info("Switch to Log in - Iframe");
        getLogInIframePage().switchToIframeLogIn();
        log.info("Click on email field");
        getLogInIframePage().clickEmailField();
        log.info("Input the email on email field");
        getLogInIframePage().inputEmail();
        log.info("Click on password field");
        getLogInIframePage().clickPasswordField();
        log.info("Input the password on password field");
        getLogInIframePage().inputPassword();
        log.info("Click on Log in button");
        getLogInIframePage().clickSubmitButton();
        log.info("");
        sleep(5000);
        log.info("Click on user option to log out");
        getHomePage().clickOnUserIcon();
        log.info("Click on log out option");
        getLogInIframePage().clickOnLogOut();
    }
*/
    @Test(description = "Open Espn page")
    public void crate_user() throws InterruptedException {
        log.info("Click on user option to log in");
        getHomePage().clickOnUserIcon();
        log.info("Click on Log in option");
        getHomePage().clickOnLogIn();
        log.info("Switch to Log in - Iframe");
        getLogInIframePage().switchToIframeLogIn();
        log.info("");
        sleep(3000);
        log.info("Click on sign up button");
        getCreateUserPage().clickOnSignUp();
        log.info("Click on first name (Create Account)");
        getCreateUserPage().clickOnFirstNameField();
        log.info("Input the first name (Create Account) ");
        getCreateUserPage().inputOnFirstNameField();
        log.info("Click on last name (Create Account)");
        getCreateUserPage().clickOnLastNameField();
        log.info("Input the last name (Create Account) ");
        getCreateUserPage().inputOnLastNameField();
        log.info("Click on email (Create Account)");
        getCreateUserPage().clickOnEmailField();
        log.info("Input the email (Create Account) ");
        getCreateUserPage().inputOnEmailField();
        log.info("Click on password (Create Account)");
        getCreateUserPage().clickOnPasswordField();
        log.info("Input the password (Create Account) ");
        getCreateUserPage().inputOnPasswordField();
        log.info("Click on sign up button (Create Account)");
        getCreateUserPage().clickOnSignUpButton();
        sleep(7000);
        //--------------------------------------------------
        log.info("Click on user option to log in");
        getHomePage().clickOnUserIcon();
        log.info("Click on ESPN profile option");
        getCancelAccountPage().clickOnEspnProfile();
        log.info("Switch to Log in - Iframe");
        getLogInIframePage().switchToIframeLogIn();
        sleep(3000);
        //getCancelAccountPage().scrollToElementBottom();
        log.info("Click on ESPN Delete Account option");
        getCancelAccountPage().clickOnCancelAccount();
        log.info("Click on confirm button to delete the account");
        getCancelAccountPage().clickOnConfirmButton();
    }
}
