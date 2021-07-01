package com.web.automation.steps;

import com.web.automation.data.User;
import com.web.automation.pages.*;
import com.web.automation.test.BaseTest;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Parent of the other classes of test.
 * @author juandaniel.castano
 */

public class Step {

    private final Logger log = Logger.getLogger(BaseTest.class);

    /**
     * Step by step to signUp in webPage
     * @param homePage To handle the WebElements
     * @param user To get values of the User object's variables
     */

    public void signUpProcess(HomePage homePage, User user) {

        Assert.assertTrue(homePage.expectedWePageIsDisplayed(), "ESPN Web-Page is opened.");
        log.info("Clicking on 'SignUp' button");
        SignUp signUp = homePage.clickOnSignUpButton();
        Assert.assertTrue(homePage.closeButtonIsDisplayed(), "SignUp Window is displayed");
        log.info("Enter the Required data");
        signUp.sendData(user.getFirstUserName(), user.getLastUserName(), user.getEmailUser(), user.getPasswordUser());
        Assert.assertTrue(signUp.dataEnteredValidation(), "Data is entered");
        log.info("Data Entered");
        log.info("Clicking on 'SignUp' button");
        signUp.clickOnSignUpButton();
        log.info("Account has been created");


    }

    /**
     * Step by step to signIn into webPage
     * @param homePage To handle the WebElements
     * @param user To get values of the User object's variables
     */

    public void signInProcess(HomePage homePage, User user){

        log.info("Click On Account Button");
        homePage.clickOnAccountButton();
        Assert.assertTrue(homePage.favoriteListIsDisplayed(), "Account section is displayed");
        log.info("Clicking on SigIn button");
        SignIn signIn = homePage.clickOnSignInButton();
        Assert.assertTrue(signIn.signInWindowIsDisplayed(), "SignIn window is displayed");
        log.info("Enter the required data");
        signIn.sendData(user.getEmailUser(), user.getPasswordUser());
        Assert.assertTrue(signIn.dataEnteredValidation(), "Data is entered");
        log.info("Data Entered");
        signIn.clickOnSignInButton();
        log.info("LogIn To the webpage");

    }

    /**
     * Step by step to signOut from webPage
     * @param homePage To handle the WebElements
     */

    public void signOutProcess(HomePage homePage){

        log.info("Click On Account Button");
        homePage.clickOnAccountButton();
        Assert.assertTrue(homePage.favoriteListIsDisplayed(), "Account section is displayed");
        log.info("Click On LogOut Button");
        homePage.clickOnLogOutButton();
        log.info("LogOut From ESPN Webpage");

    }

    /**
     * Step by step to delete the account
     * @param homePage To handle the WebElements
     */

    public void deleteESPNAccountProcess(HomePage homePage){

        log.info("Click On Account Button");
        homePage.clickOnAccountButton();
        Assert.assertTrue(homePage.favoriteListIsDisplayed(), "Account section is displayed");
        log.info("Click On ESPN profile Button");
        Profile profile = homePage.clickOnESPNProfileButton();
        Assert.assertTrue(profile.profileWindowIsDisplayed(), "Profile window is displayed");
        log.info("ESPN profile iFrame is displayed");
        profile.clickOnCancelAccountLink();
        Assert.assertTrue(profile.confirmCancelAccountButtonIsDisplayed(), "Confirm cancel account window is displayed");
        log.info("Confirm button is displayed");
        profile.clickOnConfirmCancelAccountButton();
        log.info("Account is deleted");
        log.info(profile.getConfirmAccountCanceledText());

    }

}
