package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.Iframe;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    private HomePage homePage;

    @Test(description = "Reproduce videos on the website iframes")
    public void test1() {
        log.info("Open the home on the website");
        homePage = getHomePage();
        log.info("Clicking the button to reproduce the youtube video");
        Iframe iframe = homePage.playVideoYoutube();
        iframe.videoPlayingVerification();
    }
}
