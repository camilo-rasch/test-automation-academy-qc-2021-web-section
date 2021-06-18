package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.VimeoPage;
import com.web.automation.pages.YoutubePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class IframeTest extends BaseTest {


    @Test(description = "open mdbootstrap page and play the Youtube video in the iframes")
    public void youtube_test() throws InterruptedException {
        log.info("Click on Youtube link");
        HomePage homePage1 = homePage.clickOnYoutubeLink();
        log.info("Switch to Youtube Iframe");
        YoutubePage switchIframe = youtubePage.switchToIframe0();
        log.info("Play Youtube video");
        YoutubePage youtubeClick = youtubePage.clickOnYoutubeVideo();
        log.info("-----------------------Assert");
        log.info("Switch to main Iframe");
        HomePage switchMain = homePage.switchToMain();
        sleep(3000);
    }
    @Test(description = "play the Vimeo video in the iframes")
    public void vimeo_test() throws InterruptedException {
        log.info("Click on Vimeo link");
        HomePage homePage3 = homePage.clickOnVimeoLink();
        log.info("-----------------------Assert");
        log.info("Switch to vimeo Iframe");
        VimeoPage switchIframe1 = vimeoPage.switchToIframe1();
        log.info("Play Youtube video");
        VimeoPage homePage4 = vimeoPage.clickOnVimeoVideo();
        log.info("Switch to main Iframe");
        HomePage switchMain1 = homePage.switchToMain();
        sleep(3000);

    }
}