package com.web.automation.test;

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
        homePage.playsVideoYouTubeIframe();
        youtubeIframe.clickOnPlayYouTubeButton();
	}

}
