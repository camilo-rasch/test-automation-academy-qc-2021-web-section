package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class EspnUserAccountTest extends BaseTest{

    /**
     * Mehtod that access to the dataproviders parameters to create random users
     * @param data
     */
    @BeforeMethod(alwaysRun = true)
    public void createAccount(Object[] data) {
        Object[] result = (Object[]) data[0];
        User user = (User) result[0];
        log.info("Open Home Page");
        HomePage homePage = getHomePage();
        log.info("Create users account");
        homePage.createAccount(user);
        log.info("Click to sign Out");
        homePage.signOut();
    }

    @Test(description="Test user login", priority =1, dataProviderClass = Data.class, dataProvider = "user")
    public void testCaseLogin(Object[] data){
        User user = (User) data[0];
        log.info("Open Home Page");
        HomePage homePage = getHomePage();
        log.info("Enter user data to sign in");
        homePage.signIn(user);
        log.info("The user is correctly signed in");
        Assert.assertTrue(homePage.verifySignInAccount(),user.getFirstName());
        log.info("Click to sign Out");
        homePage.signOut();
    }

    @Test(description="Test user logout", priority =2, dataProviderClass = Data.class, dataProvider = "user")
    public void testCaseLogOut(Object[] data){
        User user = (User) data[0];
        log.info("Open Home Page");
        HomePage homePage = getHomePage();
        log.info("Click to sign In");
        homePage.signIn(user);
        log.info("Click to sign out");
        homePage.signOut();
        log.info("The user is correctly sign out");
        Assert.assertTrue(getHomePage().verifyLogOutAccount());
    }

   @Test(description="Test the cancellation of an account", priority =3, dataProviderClass = Data.class, dataProvider = "user")
   public void testCaseCancellation(Object[] data){
       User user = (User) data[0];
       log.info("Open Home Page");
       HomePage homePage = getHomePage();
       log.info("Click to sign In");
       homePage.signIn(user);
       log.info("Click to user's profile menu");
       homePage.openUserProfileMenu();
       log.info("Click to delete account link");
       homePage.cancelUserAccount();
       log.info("the account is being successfully deleted");
       Assert.assertEquals(homePage.verifyMessageAccountState(),"Your account has been deleted.");
    }





}
