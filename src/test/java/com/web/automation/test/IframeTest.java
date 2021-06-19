package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.VimeoIframePage;
import com.web.automation.pages.YouTubeIframePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest{

    HomePage homePage;
    YouTubeIframePage youTubeIframePage;
    VimeoIframePage vimeoIframePage;


    @Test(description = "Test to play the YouTube video")
    public void aTestYouTubeVideo(){
        log.info("Opening the HomePage url");
        homePage = getHomePage();
        log.info("Switch to YouTube iframe");
        youTubeIframePage = homePage.switchToYouTubeIframePage();
        log.info("Click on the button play");
        youTubeIframePage.playYouTubeVideo();
        log.info("The spherical control is displayed");
        Assert.assertTrue(youTubeIframePage.isSphericalControlDisplayed());
        youTubeIframePage.switchDefaultContent();

    }

    @Test(description = "Test to play the Vimeo video")
    public void bTestVimeoVideo(){
        log.info("Opening the HomePage url");
        homePage = getHomePage();
        log.info("Click on the link Vimeo iframe");
        homePage.clickLinkVimeo();
        log.info("Switch to Vimeo iframe");
        vimeoIframePage = homePage.switchToVimeoframePage();
        log.info("Click on the button play");
        vimeoIframePage.playVimeoVideo();
        log.info("The play button is displayed");
        Assert.assertFalse(vimeoIframePage.isPlayButtonDisplayed());
        vimeoIframePage.switchDefaultContent();

    }

}
