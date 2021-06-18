package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class IframeTest extends BaseTest {


    @Test(description = "open mdbootstrap page and play the videos in the iframes")

    public void login_test() throws InterruptedException {
        log.info("Opening mdbootstrap Page");
        HomePage homePage = getHomePage();
        HomePage homePage1 = homePage.clickOnYoutubeLink();
        HomePage homePage2 = homePage.clickOnYoutubeVideo();
        HomePage homePage3 = homePage.clickOnVimeoLink();
        sleep(3000);
        //HomePage switchIframe = homePage.switchIframe();
        HomePage homePage4 = homePage.clickOnVimeoVideo();








    }
}