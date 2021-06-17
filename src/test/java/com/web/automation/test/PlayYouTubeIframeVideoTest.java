package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.YouTubeIframe;

public class PlayYouTubeIframeVideoTest extends BaseTest {
	
	HomePage homePage;
	YouTubeIframe youtubeIframe;
	
	@Test(description = "Test to play YouTube Iframe Video")
	public void test1() {
		
		log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Switch to YouTube video Iframe");
        YouTubeIframe youtubeIframe = homePage.playsVideoYouTubeIframe();
        log.info("Play youtube Video");
        youtubeIframe.clickOnPlayYouTubeButton();
      //Sleep added just to slow test in order to obtain a video execution time greater than zero
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Get play video seconds");
        String videoProgress = youtubeIframe.getProgressBarAttributes();
       	Assert.assertTrue((!videoProgress.equals("0")));
       	youtubeIframe.switchToDefaultContent();
	}

}
