package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.IframePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test Class for YouTube Video iframe.
 * @author alejandro.giraldo
 */

public class YoutubeTest extends BaseTest {

    IframePage iframePage;
    HomePage homePage;

    @BeforeMethod(description = "Change iFrameFocus")
    public void changeFocus(){
        homePage= getHomePage();
        WebDriver frameDriver= homePage.changeYoutubeFrameFocus();
        iframePage=new IframePage(frameDriver);
    }

    @AfterMethod(description = "Change to DefaultContent")
    public void changeDefaultContent(){
        homePage.changeDefaultContent();
    }

    @Test(description = "Test to verify if an Iframe Youtube Video is Played")
    public void youTubeVideoTest(){
        log.info("play youtube video");
        iframePage.playYouTubeVideo();
        iframePage.waitImplicit(1);
        log.info("Pause YouTube Video");
        iframePage.pauseYoutubeVideo();
        log.info("YouTube Video Played?");
        Assert.assertTrue(iframePage.getYouTubeTimePlayed(), "Verify if Video has been played");
    }

}
