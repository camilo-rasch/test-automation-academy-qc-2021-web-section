package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.DeleteAccountModal;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginModal;
import com.web.automation.pages.CreateAccountModal;
import org.testng.Assert;
import org.testng.annotations.*;

public class EspnAccountTest extends BaseTest {

    HomePage homePage;
    LoginModal loginModal;
    DeleteAccountModal deleteAccountModal;


    @BeforeMethod()
    public void createAccount(Object[] data) {
        User user = (User) data[0];

        homePage = getHomePage();
        log.info("Select the user button");
        homePage.selectUserButton();
        log.info("Click on the login button");
        homePage.clickOnLoginButton();
        log.info("Doing switch to the login modal");
        loginModal = homePage.switchToLoginModal();
        log.info("Click on Sign up button");
        createAccountModal = loginModal.clickOnSignUpButton();
        log.info("Input data for the create account");
        createAccountModal.createAccount(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        log.info("Select the user button");
        homePage.selectUserButton();
        log.info("Logout account");
        homePage.logoutAccount();

    }



    @AfterMethod()
    @Parameters({"url"})
    public void reloadPage(String url){

        homePage.reload(url);
    }


    @Test(description = "login Account", dataProviderClass = Data.class, dataProvider = "userAccount")
    public void aTestLogin(User user) {

        log.info("Open the user button");
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isAddFavoritesButtonDisplayed(),"Add favorites button is not displayed");
        log.info("Click on the login button");
        homePage.clickOnLoginButton();
        log.info("Doing switch to the login modal");
        loginModal = homePage.switchToLoginModal();
        log.info("Input data and login");
        loginModal.loginAccount(user.getEmail(), user.getPassword());
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isEspnProfileButtonDisplayed(),"ESPN profile button is not displayed");
        log.info("Logout account");
        homePage.logoutAccount();
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isLoginButtonDisplayed(),"log in button is not displayed");

    }


    @Test(description = "logout Account", dataProviderClass = Data.class, dataProvider = "userAccount")
    public void bTestLogout(User user) {

        log.info("Open the user button");
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isAddFavoritesButtonDisplayed(),"Add favorites button is not displayed");
        log.info("Click on the login button");
        homePage.clickOnLoginButton();
        loginModal = homePage.switchToLoginModal();
        log.info("Input data and login");
        loginModal.loginAccount(user.getEmail(), user.getPassword());
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isEspnProfileButtonDisplayed(),"ESPN profile button is not displayed");
        log.info("Logout account");
        homePage.logoutAccount();
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isLoginButtonDisplayed(),"log in button is not displayed");
    }



    @Test(description = "Cancel Account", dataProviderClass = Data.class, dataProvider = "userAccount")
    public void cTestCancelAccount(User user) {

        log.info("Open the user button");
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isAddFavoritesButtonDisplayed(),"Add favorites button is not displayed");
        log.info("Click on the login button");
        homePage.clickOnLoginButton();
        log.info("Doing switch to the login modal");
        loginModal = homePage.switchToLoginModal();
        log.info("Input data and login");
        loginModal.loginAccount(user.getEmail(), user.getPassword());
        homePage.selectUserButton();
        Assert.assertTrue(homePage.isEspnProfileButtonDisplayed(),"ESPN profile button is not displayed");
        log.info("Click on the ESPN profile button");
        homePage.clickOnEspnProfButton();
        log.info("Doing switch to the Delete Account modal");
        deleteAccountModal = homePage.switchToDeleteAccountModal();
        log.info("Cancel Account");
        deleteAccountModal.cancelAccount();
        Assert.assertTrue(deleteAccountModal.isDeletedOKButtonDisplayed(),"Deleted OK button is not displayed");
    }

}
