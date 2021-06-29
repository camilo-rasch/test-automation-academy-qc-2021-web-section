package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginPage;
import com.web.automation.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test cases for the final exam
 * @author harvey.yepes
 */
public class EspnAccountTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void createAccount(Object[] data){
        User user = (User) data[0];

    }

    /*@AfterMethod()
    @Parameters({"url"})
    public void reloadPage(String url){

        //Sleep added just to slow test flux in order to be more visible
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.reload(url);
    }*/
/*
    @Test(description = "Log in (after the test finish you have to log out)")
    public void loginUser() {
        homePage = getHomePage();
        log.info("Opening homePage");
        LoginPage loginPage = homePage.loginUser();
        log.info("Click on login button");
        loginPage.loginUser();
        log.info("Input the data and log in the user");
        loginPage.switchToDefaultContent();
        log.info("The user is redirected to the home page");
        Assert.assertTrue(homePage.validateUserLogin(),"Validating the user login successful");
        //Assert.assertEquals(homePage.validateUserLogin(),username, "Validating the user login successful");
        homePage.logoutUser();
        log.info("The user logout is successful");
        Assert.assertTrue(homePage.validateUserLogout(),"Validating the user logout successful");
        log.info("Test completed");
    }*/

    /* @Test(description = "Sign up user to create account")
     public void logoutUser(){
         homePage = getHomePage();
         log.info("Opening homePage");
         LoginPage loginPage = homePage.loginUser();
         log.info("Click on login button");
         //loginPage.signupUser();
         SignupPage signupPage = loginPage.signupUser();
         signupPage.signupUser();
         log.info("The user clicks on the Sign Up button and creates the account");
         signupPage.switchToDefaultContent();
         log.info("The user is redirected to the home page");
         Assert.assertTrue(homePage.validateUserLogin(), "Validating the account is successfully created");

     }*/
    @Test(dataProviderClass = Data.class, dataProvider = "user")
    public void testInputUsers(Object[] data){
        //log.info(user.toString());
        homePage = getHomePage();
        log.info("Opening homePage");
        LoginPage loginPage = homePage.loginUser();
        log.info("Click on login button");
        //loginPage.signupUser();
        SignupPage signupPage = loginPage.signupUser();
        //signupPage.signupUser(user);
        Assert.assertTrue(homePage.validateUserLogin(), "Validating the account is successfully created");
        log.info("The user is created");

    }

    /*@Test(description = "Cancel account")
    Crear el test con el metodo creado en su clase

    y los data provider

    public void logoutUser() {
        log.info("Opening homePage");
        homePage = getHomePage();
        Assert.assertTrue(newTabSample.is_zen_container_present(), "Verify Zen container is present");
    }*/
}



