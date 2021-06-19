package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;
/**
 * Class with the tests.
 * @author jonathan.triana
 */
public class IframeTest extends BaseTest {


    @Test(description = "open mdbootstrap page and play the Youtube video in the iframes")
    public void youtube_test() throws InterruptedException {
        log.info("Click on Youtube link");
        homePage.clickOnYoutubeLink();
        log.info("Switch to Youtube Iframe");
        youtubePage.switchToIframe0();
        log.info("Play Youtube video");
        youtubePage.clickOnYoutubeVideo();
        log.info("With this sleep the video can progress and change the initial status");
        sleep(6000);
        log.info("Assert to compare the progress of the video");
        Assert.assertTrue((youtubePage.getProgressBarValue().equals("Pause (k)")));
        log.info("Switch to main Iframe");
        homePage.switchToMain();
    }
    @Test(description = "play the Vimeo video in the iframes")
    public void vimeo_test() throws InterruptedException {
        log.info("Click on Vimeo link");
        homePage.clickOnVimeoLink();
        log.info("Switch to vimeo Iframe");
        vimeoPage.switchToIframe1();
        log.info("Play Youtube video");
        vimeoPage.clickOnVimeoVideo();
        log.info("With this sleep the video can progress and change the initial value");
        sleep(6000);
        log.info("Assert to compare the progress of the video");
        Assert.assertTrue((!vimeoPage.getProgressBarValue().equals("0")));
        log.info("Switch to main Iframe");
        homePage.switchToMain();
    }
}