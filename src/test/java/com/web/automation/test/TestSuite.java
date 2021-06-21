package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    private HomePage homePage;

    @Test(description = "Reproduce videos on the website iframes")
    public void playVideoYouTube() {
        log.info("Open the home on the website");
        homePage = getHomePage();
        log.info("Clicking the button to play the youtube video");
        homePage.playVideoYoutube();
        log.info("return to the main context of the website");
        homePage.labelTimeVideoDisplayed();
        homePage.backToDefaultContent();
    }

    @Test(description = "Reproduce videos on the website iframes")
    public void playVideoZVimeo() {
        log.info("Open the home on the website");
        homePage = getHomePage();
        homePage.scrollToTable();
        log.info("Clicking the button to play the vimeo video");
        homePage.playVideoVimeo();
        log.info("return to the main context of the website");
        homePage.backToDefaultContent();
    }
}
