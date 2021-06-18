package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test(description = "Test that plays the video from the YouTube iFrame")
    public void testCaseIframeYouTube(){
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Play the YouTube Video");
        homePage.playYouTubeVideo();
    }

    @Test(description = "Test that plays the video from the Vimeo iFrame")
    public void testCaseIframeVimeo(){
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Play the Vimeo Video");
        homePage.playVimeoVideo();
    }
}
