package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.DeleteAccount;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginPage;
import com.web.automation.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test cases for the final exam
 * @author harvey.yepes
 */
public class EspnAccountTest extends BaseTest {
    HomePage homePage;
    String username;
    String deleteConfirmation = "Your account has been deleted.";

    /**
     * Method to create the accounts with data provider
     * @param data
     */
    @BeforeMethod(alwaysRun = true)
    public void createAccount(Object[] data){
        //Object[] input = (Object[]) data[0];
        User user = (User) data[0];
        homePage = getHomePage();
        log.info("Opening homePage");
        LoginPage loginPage = homePage.loginUser();
        log.info("Click on login button and then on signup button");
        SignupPage signupPage = loginPage.signupUser();
        log.info("The user is on the form to create the account");
        signupPage.signupUser(user);
        username = user.getFirstName();
        log.info("The user input the data to create the account");
        Assert.assertTrue(homePage.validateUserLogin(), "The account is created and the user is logged in to the home page");
        log.info("The user " +  username + " was created");
        homePage.logoutUser();
        Assert.assertTrue(homePage.validateUserLogout(),"User logout");
        log.info("User logout");
    }

    /**
     * Method to reload the page after each method
     * @param url
     */
    @AfterMethod()
    @Parameters({"url"})
    public void reloadPage(String url){

        //Sleep added just to slow test flux in order to be more visible
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.reload(url);
    }


    @Test(description = "Log in (after the test finish you have to log out)", dataProviderClass = Data.class, dataProvider = "user", priority = 0)
    public void loginUser(User user) {
        homePage = getHomePage();
        log.info("Opening homePage");
        LoginPage loginPage = homePage.loginUser();
        log.info("Click on login button");
        loginPage.loginUser(user);
        log.info("The user input the data to log in");
        loginPage.switchToDefaultContent();
        log.info("The user " +  username + " was redirected to the home page");
        Assert.assertTrue(homePage.validateUserLogin(),"The user login successfully");
        log.info("Log in account successfully");
        //Assert.assertEquals(homePage.validateUserLogin(),username, "The user login successfully");
        homePage.logoutUser();
        log.info("Log out account successfully");
        Assert.assertTrue(homePage.validateUserLogout(),"The user log out the page successfully");
        log.info("User login/logout test completed");
    }


    @Test(description = "Cancel account", dataProviderClass = Data.class, dataProvider = "user", priority = 1)
    public void deleteAccount(User user) {
        homePage = getHomePage();
        log.info("Opening homePage");
        LoginPage loginPage = homePage.loginUser();
        log.info("Click on login button");
        loginPage.loginUser(user);
        log.info("The user input the data to log in");
        DeleteAccount deleteAccount = homePage.deleteAccount();
        log.info("Click on ESPN profile button");
        deleteAccount.deleteAccount();
        log.info("The user goes to the popup to delete the account");
        Assert.assertEquals(deleteAccount.validateDeletedAccount(), deleteConfirmation,  "The account is deleted successfully");
        log.info("Account deleted");
        loginPage.switchToDefaultContent();
    }
}
