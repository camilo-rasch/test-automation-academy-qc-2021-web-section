package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.IframePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest{
    HomePage homePage;

   @Test(description = "Test to open the page and play Youtube video")
    public void test1(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on Youtube Video");
        IframePage iFrame = homePage.clickPlayYoutubeVideo();
       log.info("Is the Youtube video playing?");
        Assert.assertTrue(iFrame.isTheYoutubeVideoPlaying());
        iFrame.switchToMainPage();
    }

    @Test(description = "Test to open the page and play Vimeo video")
    public void test2() {
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on Vimeo Video");
        IframePage iFrame = homePage.clickPlayVimeoVideo();
        log.info("Is the Vimeo video playing?");
        Assert.assertTrue(iFrame.isTheVimeoVideoPlaying(), "Verify the video is playing");
    }
}
