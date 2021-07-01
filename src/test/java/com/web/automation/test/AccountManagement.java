package com.web.automation.test;

import com.web.automation.Workflow.Workflow;
import com.web.automation.data.Data;
import com.web.automation.data.UserInfo;
import com.web.automation.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests class.
 * @author fabio.alarcon
 */

public class AccountManagement extends BaseTest{

    private HomePage homePage;
    private Workflow workflow = new Workflow();


    @BeforeMethod(description = "Create a new account and logout", alwaysRun = true)
        public void creatingAnAccount(Object[] credentialsInfo){
        UserInfo userInfo = (UserInfo) credentialsInfo[0];
        log.info("Opening homePage");
        homePage = getHomePage();
        workflow.creatingOneAccount(homePage, userInfo);
        workflow.logOutMethod(homePage);
        }

    @Test(description = "Log In the session", dataProvider = "Credentials", dataProviderClass = Data.class)
    public void testLogIn(UserInfo userInfo){
        log.info("Opening homePage");
        homePage = getHomePage();
        workflow.logInMethod(homePage, userInfo);
        workflow.logOutMethod(homePage);
    }

    @Test(description = "Log Out the session", dataProvider = "Credentials", dataProviderClass = Data.class)
    public void testLogOut(UserInfo userInfo){
        log.info("Opening homePage");
        homePage = getHomePage();
        workflow.logInMethod(homePage, userInfo);
        workflow.logOutMethod(homePage);
    }

    @Test(description = "Cancel Account", dataProvider = "Credentials", dataProviderClass = Data.class)
    public void testZzCancelAccount(UserInfo userInfo) {
        log.info("Opening homePage");
        homePage = getHomePage();
        workflow.logInMethod(homePage, userInfo);
        workflow.cancelAccountMethod(homePage);
    }
}
