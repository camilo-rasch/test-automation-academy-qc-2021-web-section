package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.pages.AccountManagementIframe;
import com.web.automation.pages.ConfirmDeleteAccountIframe;
import com.web.automation.pages.CreateAccountIframe;
import com.web.automation.pages.DeleteMessageConfirmation;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LogInSignUpIframe;
import com.web.automation.pages.UserPopUpOptions;

public class TestSuite extends BaseTest{

	HomePage homePage;
	UserPopUpOptions userPopUp;
	LogInSignUpIframe logInSignUpIframe;
	CreateAccountIframe createAccountIframe;
	String deleteMessage = "Your account has been deleted.";
	String email;
	String password;
	String firstName;
	
	@BeforeMethod(description="Create an ESPN account")
	public void createEspnAccount(Object[] data) {
		
		User user = new User();
		log.info("Opening ESPN homePage");
    	homePage = getHomePage();
        log.info("Click on global User button - top right navigation bar");
        homePage.clickGlobalUserButton();
        log.info("Switch to User option pop-ups ");
        UserPopUpOptions userPopUp = homePage.switchToUserPopUpOptions();
        log.info("Click on Login option");
        userPopUp.clickLogInOption();
        log.info("Switch to main Window Home Page");
        userPopUp.switchToMainWindow();
        log.info("Switch to account iframe, log In - Sign Up");
        LogInSignUpIframe logInSignUpIframe = homePage.switchToLogInSignUpIframe();
        log.info("Click on Sign Up Button");
        logInSignUpIframe.clickOnSignUpButton();
        log.info("Return Driver to default content");
        logInSignUpIframe.switchToDefaultContent();
        log.info("Switch to create account iframe - Sign Up");
        CreateAccountIframe createAccountIframe = homePage.switchToCreateAccountIframe();
        log.info("Fill create account fields: name, last name, email, password");
        createAccountIframe.clickOnfirstNameField();
        firstName = user.getFirstName();
        createAccountIframe.sendKeysfirstNameField(firstName);
        createAccountIframe.clickOnlastNameField();
        createAccountIframe.sendKeyslastNameField(user.getLastName());
        createAccountIframe.clickOnEmailField();
        email = user.getEmail();
        createAccountIframe.sendKeysEmailField(email);
        createAccountIframe.clickOnPasswordField();
        password = user.getPassword();
        createAccountIframe.sendKeysPasswordField(password);
        log.info("Click on Sign Up button to create the new account");
        createAccountIframe.clickOnSignUpButton();
        log.info("Return Driver to default content");
        createAccountIframe.switchToDefaultContent();
        log.info("Click on global User button - top right navigation bar");
        //Sleep added just to obtain Global User Button
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.waitGloberUserButton();
        homePage.clickGlobalUserButton();
        log.info("Switch to User option pop-ups ");
        userPopUp = homePage.switchToUserPopUpOptions();
        log.info("Get the created user name");
        String userName = userPopUp.getUserProfileName();
        log.info(userName);
        userPopUp.clickLogOutOption();
        log.info("Switch to default window");
        userPopUp.switchToMainWindow();
      //Sleep added just to obtain Global User Button
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   
	}
	
	@Test(description="Espn user Log In and log out", priority = 1)
	public void userLogInEspn() {
		
		log.info("Opening ESPN homePage");
    	homePage = getHomePage();
        log.info("Click on global User button - top right navigation bar");
        homePage.clickGlobalUserButton();
        log.info("Switch to User option pop-ups ");
        UserPopUpOptions userPopUp = homePage.switchToUserPopUpOptions();
        log.info("Click on Login option");
        userPopUp.clickLogInOption();
        log.info("Switch to main Window Home Page");
        userPopUp.switchToMainWindow();
        log.info("Switch to account iframe, log In - Sign Up");
        LogInSignUpIframe logInSignUpIframe = homePage.switchToLogInSignUpIframe();
        log.info("Fill email and password field");
        logInSignUpIframe.clickOnEmailField();
        logInSignUpIframe.sendKeysEmailField(email);
        logInSignUpIframe.clickOnPasswordField();
        logInSignUpIframe.sendKeysPasswordField(password);
        log.info("Click on Log In button");
        logInSignUpIframe.clickOnLogInButton();
        log.info("Return Driver to default content");
        logInSignUpIframe.switchToDefaultContent();
        log.info("Click on global User button - top right navigation bar");
        //Sleep added just to obtain Global User Button
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.waitGloberUserButton();
        homePage.clickGlobalUserButton();
        log.info("Switch to User option pop-ups ");
        userPopUp = homePage.switchToUserPopUpOptions();
        log.info("Validate the created user - name is displayed!");
        String userName = userPopUp.getUserProfileName();
        Assert.assertEquals((userName), firstName+"!"); 
        log.info("Click on Log Out option");
        userPopUp.clickLogOutOption();
        log.info("Switch to default window");
        userPopUp.switchToMainWindow();
      //Sleep added just to obtain Global User Button
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.waitGloberUserButton();
        homePage.clickGlobalUserButton();
        log.info("Switch to User option pop-ups ");
        userPopUp = homePage.switchToUserPopUpOptions();
        log.info("Validate if Log In option is displayed after log out");
        Assert.assertTrue(userPopUp.displayLogInButton()); 	
		
	}
		
	@Test(description="Espn - user cancel account", priority = 2)
	public void userCancelAccount() {
		
    	log.info("Opening ESPN homePage");
    	homePage = getHomePage();
        log.info("Click on global User button - top right navigation bar");
        homePage.clickGlobalUserButton();
        log.info("Switch to User option pop-ups ");
        UserPopUpOptions userPopUp = homePage.switchToUserPopUpOptions();
        log.info("Click on Login option");
        userPopUp.clickLogInOption();
        log.info("Switch to main Window Home Page");
        userPopUp.switchToMainWindow();
        log.info("Switch to account iframe, log In - Sign Up");
        LogInSignUpIframe logInSignUpIframe = homePage.switchToLogInSignUpIframe();
        log.info("Fill email and password field");
        logInSignUpIframe.clickOnEmailField();
        logInSignUpIframe.sendKeysEmailField(email);
        logInSignUpIframe.clickOnPasswordField();
        logInSignUpIframe.sendKeysPasswordField(password);
        log.info("Click on Log In button");
        logInSignUpIframe.clickOnLogInButton();
        log.info("Return Driver to default content");
        logInSignUpIframe.switchToDefaultContent();
        log.info("Click on global User button - top right navigation bar");
        //Sleep added just to obtain Global User Button
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.waitGloberUserButton();
        homePage.clickGlobalUserButton();
        log.info("Switch to User option pop-ups ");
        userPopUp = homePage.switchToUserPopUpOptions();
        userPopUp.clickEspnProfileOption();
        log.info("Switch to account management iframe");
        AccountManagementIframe accountManagementIframe = homePage.switchToAccountManagementIframe();
        log.info("Scroll To Bottom iframe");
        accountManagementIframe.scrollToBottomIframe();
      //Sleep added just to obtain the bottom page
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Click on Delete account");
        accountManagementIframe.clickOnDeleteAccountOption();
        log.info("Return Driver to default content");
        accountManagementIframe.switchToDefaultContent();
        ConfirmDeleteAccountIframe confirmDeleteAccountIframe = homePage.switchToConfirmDeleteAccountIframe();
        log.info("Click on confirm Delete account");
        confirmDeleteAccountIframe.clickOnConfirmDeleteAccount();
        log.info("Return Driver to default content");
        confirmDeleteAccountIframe.switchToDefaultContent();
        log.info("Switch to delete message confirmation iframe");
        DeleteMessageConfirmation deleteMessageConfirmation = homePage.switchToDeleteMessageConfirmationIframe();
        log.info("Assert delete confirmation message");
        Assert.assertEquals(deleteMessageConfirmation.getDeleteMessage(), deleteMessage);
        
	}
}
