package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    private HomePage homePage;

    @Test(description = "Reproduce videos on the website iframes")
    public void reproduceVideosIframes() {
        homePage = getHomePage();
        homePage.reproduceVideos();
    }
}
