package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test(description = "open mdbootstrap page and play the videos in the iframes")
    public void login_test() {
        log.info("Opening mdbootstrap Page");
        HomePage homePage = getHomePage();
    }
}