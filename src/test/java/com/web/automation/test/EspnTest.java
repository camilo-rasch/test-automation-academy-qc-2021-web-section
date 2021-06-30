package com.web.automation.test;

import com.web.automation.data.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class EspnTest extends BaseTest {

    @Test(description = "Log in and log out an user",dataProvider="data1",dataProviderClass= Data.class)
    public void login_user(String email,String password) throws InterruptedException {
        //As the exercise say that we need to implement a before method to create a user
        //So I had to log out the user created earlier to be able to do the log in
        log.info("Click on user option to log out");
        getHomePage().clickOnUserIcon();
        log.info("Click on log out option");
        getLogInPage().clickOnLogOut();
        //I should to include an sleep because the waitElementVisibility is not working well
        sleep(3000);

        //Log In user
        log.info("Click on the user option to log in");
        getHomePage().clickOnUserIcon();
        log.info("Click on the Log in option");
        getHomePage().clickOnLogIn();
        log.info("Switch to Log in - Iframe");
        getHomePage().switchToIframeLogIn();
        log.info("Click on the email field");
        getLogInPage().clickEmailField();
        log.info("Input the email in the email field");
        getLogInPage().inputEmail(email);
        log.info("Click on the password field");
        getLogInPage().clickPasswordField();
        log.info("Input the password in the password field");
        getLogInPage().inputPassword(password);
        log.info("Click on the Log in button");
        getLogInPage().clickSubmitButton();
        //I should to include an sleep because the waitElementVisibility is not working well
        sleep(5000);
        log.info("Click on the user option to checkout");
        getHomePage().clickOnUserIcon();
        log.info("Assert to verify that you are logged in");
        Assert.assertEquals(getHomePage().messageConfirmation(),"WelcomeJohn!");

        //Log out user
        log.info("Click on user option to log out");
        getHomePage().clickOnUserIcon();
        log.info("Click on log out option");
        getLogInPage().clickOnLogOut();
        //I should to include an sleep because the waitElementVisibility is not working well
        sleep(2000);
        log.info("Click on user option");
        getHomePage().clickOnUserIcon();
        log.info("Assert to verify that you are log out");
        Assert.assertEquals(getHomePage().messageConfirmation(),"Welcome!");
    }

    @Test(description = "Log out the user created")
    public void logout_user() throws InterruptedException {
        log.info("Click on the user option to log out");
        getHomePage().clickOnUserIcon();
        log.info("Assert to verify that I am logged in");
        Assert.assertEquals(getHomePage().messageConfirmation(),"WelcomeJonathan!");
        log.info("Click on the log out option");
        getLogInPage().clickOnLogOut();
        //I should to include an sleep because the waitElementVisibility is not working well
        sleep(2000);
        log.info("Click on the user option to log out");
        getHomePage().clickOnUserIcon();
        log.info("Assert to verify that I am logged out");
        Assert.assertEquals(getHomePage().messageConfirmation(),"Welcome!");
    }

    @Test(description = "Delete an account created")
    public void delete_account() throws InterruptedException {
        log.info("Click on the user option to log in");
        getHomePage().clickOnUserIcon();
        log.info("Click on the ESPN profile option");
        getCancelAccountPage().clickOnEspnProfile();
        log.info("Switch to Log in - Iframe");
        getHomePage().switchToIframeLogIn();
        log.info("Assert to verify that we are on the page to update your account");
        Assert.assertEquals(getCancelAccountPage().deleteConfirmation(),"Update Your Account");
        log.info("Click on the ESPN delete account option");
        getCancelAccountPage().clickOnCancelAccount();
        //I should to include an sleep because the waitElementVisibility(confirmText); is not working well
        sleep(1000);
        log.info("Assert to verify that we are on the confirmation popup");
        Assert.assertEquals(getCancelAccountPage().deleteConfirmation(),"Are you sure?");
        log.info("Click on the confirm button to delete the account");
        getCancelAccountPage().clickOnConfirmButton();
        //I should to include an sleep because the waitElementVisibility(confirmText); is not working well
        sleep(2000);
        log.info("Assert to verify that the account was deleted");
        Assert.assertEquals(getCancelAccountPage().deleteConfirmation(),"Your account has been deleted.");
    }
}