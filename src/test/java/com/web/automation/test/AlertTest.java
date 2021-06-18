package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    HomePage homePage;

    @Test(description = "Test to open the page and fill data")
    public void test1(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Fill data");
        homePage.fillData();
        //  Assert.assertTrue(iFrame.IsTheVideoPlaying(), "Verify the video is playing");
    }

    @Test(description = "Test to get the first alert")
    public void test2(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("This is the first alert");
        homePage.getFirstAlert();
    }

    @Test(description = "Test to get the second alert")
    public void test3(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("This is the second alert");
        homePage.getSecondAlert();
        Assert.assertTrue(homePage.isThisTheMainPage(), "Verify this is the Main page");

    }
}
