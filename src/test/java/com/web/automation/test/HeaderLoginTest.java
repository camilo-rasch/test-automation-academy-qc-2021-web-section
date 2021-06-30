package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class HeaderLoginTest extends BaseTest{
    HomePage homePage;
    LoginIframePage login;
    HeaderPage header;

    @BeforeMethod(description = "Method to get Home page, and click on Login option", alwaysRun = true)
    public void startLoginProcess(Object[] data) {
        User user = (User) data[0];
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on User icon");
        header = homePage.clickOnUserIcon();
        Assert.assertTrue(header.isTheLoginPresentInContainer());
        log.info("Click on Login option");
        login = homePage.clickOnLoginOption();
    }

    @AfterMethod
    @Parameters({"url"})
    public void reloadPage(String url){
      homePage.reload(url);
    }

    @Test(description = "Test to Login process", dataProviderClass = Data.class, dataProvider = "User")
    public void Atest1(User user){
        Assert.assertTrue(login.isTheLogoPresent());
        log.info("Login in Espn page");
        login.loginEspnPage(user.getEmailStorage(), user.getPassword());
        Assert.assertTrue(login.isTheMainPageDisplayed());
    }

    @Test(description = "Test to Logout process", dataProviderClass = Data.class, dataProvider = "User")
    public void Btest2(User user){
        Assert.assertTrue(login.isTheLogoPresent());
        log.info("Login in Espn page");
        login.loginEspnPage(user.getEmailStorage(), user.getPassword());
        Assert.assertTrue(login.isTheMainPageDisplayed());
        login.iframeInvisible();
        homePage.clickOnUserIcon();
        log.info("Is the Logout option present in the container?");
        Assert.assertTrue(header.isTheLogoutPresentInContainer());
        homePage.clickOnLogoutOption();
        Assert.assertTrue(login.isTheMainPageDisplayed());
        login.iframeInvisible();
        homePage.clickOnUserIcon();
        Assert.assertEquals(header.loginOptionisDisplayedAfterLogout(), "Log In");
    }

    @Test(description = "Test to Delete Account", dataProviderClass = Data.class, dataProvider = "User")
    public void Ctest3 (User user){
        Assert.assertTrue(login.isTheLogoPresent());
        log.info("Sign Up container");
        SignUpPage signUpPage = login.clickOnSignUpButton();
        Assert.assertTrue(signUpPage.isTheSignUpDisplayed());
        signUpPage.signUpEspnPage(user.getFirstName(), user.getLastName(), user.getPassword());
        Assert.assertTrue(login.isTheMainPageDisplayed());
        login.iframeInvisible();
        homePage.clickOnUserIcon();
        log.info("Is the ESPN Profile option present in the container?");
        Assert.assertTrue(header.isTheESPNProfilePresentInContainer());
        EspnProfile espnProfile = homePage.clickOnESPNProfileOption();
        Assert.assertTrue(espnProfile.isTheESPNProfileDisplayed());
        espnProfile.clickOnDeleteAccount();
        Assert.assertTrue(espnProfile.isTheConfirmationToDeleteAccountDisplayed());
        espnProfile.clickOnDeleteThisAccountButton();
        Assert.assertEquals(espnProfile.messageAccountHasBeenDeleted(), "Your account has been deleted.");
    }
}
