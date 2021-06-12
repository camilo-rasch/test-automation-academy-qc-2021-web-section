package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;

/**
 * Class for Facebook tests.
 * @author alejandro.giraldo
 */

public class Tests {

    public Logger log = Logger.getLogger(Tests.class);

    @BeforeTest()
    public void SetUpController() {
        log.info("Configure Chrome Driver");
        log.info("----Precondition No other Open Sessions------");
        log.info("Open Browser");
        log.info("Maximize Browser");
        log.info("Go to URL:Facebook.com");
        log.info("LogOut from previous Session");
        log.info("----All sessions Closed------");
    }


    @BeforeMethod()
    public void facebookLogin() {
        log.info("----FaceBook Login------");
        log.info("Change to login Page");
        log.info("Find userNameTextInput");
        log.info("Type User Name");
        log.info("Find userPasswordInput");
        log.info("Type Password");
        log.info("Find LoginButton");
        log.info("ClickOn LoginButton");
        log.info("---User LoggedIn------");
    }

    @Test(description = "Change Profile Picture")
    public void testCaseChangeProfilePicture() {
        log.info("----Change Profile Picture Test-----");
        log.info("Find profileButton");
        log.info("ClickOn profileButton");
        log.info("Find editProfileButton");
        log.info("ClickOn editProfileButton");
        log.info("Find EditProfilePictureLabel");
        log.info("ClickOn EditProfilePictureLabel");
        log.info("Change to EditProfilePicturePopUp");
        log.info("Find UpLoadPictureButton");
        log.info("Select Picture From Data Project");
        log.info("Open Picture From Data Project");
        log.info("Change to UpdateProfilePicturePopUp");
        log.info("Find SaveButton");
        log.info("ClickOn SaveButton");
        log.info("---- Profile Picture Changed-----");
    }

    @Test(description = "Eliminate FaceBook Friend")
    public void testCaseEliminateFriend() {
        log.info("----Eliminate FaceBook Friend Test-----");
        log.info("------Going to Friends---------");
        log.info("Find profileButton");
        log.info("ClickOn profileButton");
        log.info("Find AllFriendsButton");
        log.info("ClickOn AllFriendsButton");
        log.info("Find FirstFriendOptionsList");
        log.info("ClickOn FirstFriendOptionsList");
        log.info("Find EliminateFriendOptionList");
        log.info("ClickOn EliminateFriendOptionList");
        log.info("Change to EliminatePopUpWindow");
        log.info("Find ConfirmEliminateButton");
        log.info("ClickOn ConfirmEliminateButton");
        log.info("---- FaceBook Friend Eliminated-----");
    }

    @AfterMethod()
    public void facebookLogOut() {
        log.info("---User LogoutMethod----");
        log.info("Find userAccountLabel");
        log.info("ClickOn userAccountLabel");
        log.info("Find userLogoutButton");
        log.info("ClickOn userLogoutButton");
        log.info("---User LoggedOut----");
    }
}
