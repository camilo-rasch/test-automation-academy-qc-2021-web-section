package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.NewTabSample;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class openNewTabTest extends BaseTest{
    HomePage homePage;

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

    @Test(description = "Test to switch to a different page")
    public void test1(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on open new Window button");
        NewTabSample newTabSample = homePage.clickOnOpenNewPageButton();
        String parentHandle = homePage.getMainPageHandle();
        Assert.assertTrue(newTabSample.is_zen_container_present(), "Verify Zen container is present");
        newTabSample.switchToMainPage(parentHandle);
    }

    @Test(description = "Test to switch to a different tab")
    public void test2(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on open new Window button");
        String parentHandle = homePage.getMainPageHandle();
        NewTabSample newTabSample = homePage.clickOnOpenNewTabButton();
        Assert.assertTrue(newTabSample.is_zen_container_present(), "Verify Zen container is present");
        newTabSample.switchToMainPage(parentHandle);
    }
}
