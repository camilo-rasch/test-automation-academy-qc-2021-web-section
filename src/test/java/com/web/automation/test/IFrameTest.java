package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.IFramesPage;
import com.web.automation.pages.VimeoIFrame;
import com.web.automation.pages.YouTubeIFrame;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Create a test that plays the video from the YouTube iFrame.
 * @author Harvey.Yepes
 */
public class IFrameTest extends BaseTest{

    private IFramesPage iFramesPage;
    private YouTubeIFrame youTubeIFrame;
    private VimeoIFrame vimeoIFrame;


@Test(description = "Play YouTube IFrame Video")
    public void playYouTubeIFrame() {
    iFramesPage = getIFramesPage();
    log.info("Page is open");
    YouTubeIFrame youTubeIFrame = iFramesPage.goToYouTubeIFrame();
    log.info("Switch to the YouTube IFrame");
    youTubeIFrame.playYoutubeVideo();
    log.info("The YouTube video starts to play");
    log.info("Checking the progress of the YouTube video");
    String timeElapsed = youTubeIFrame.validateYouTubeVideoPlayback();
    log.info("The video is paused at: " + timeElapsed);
    Assert.assertNotEquals(timeElapsed, "0:00");
    log.info("YouTube frame plays sucessfully");
}

@Test(description = "Play Vimeo IFrame Video")
    public void playVimeoIFrame(){
    iFramesPage = getIFramesPage();
    log.info("Page is open");
    VimeoIFrame vimeoIFrame = iFramesPage.goToVimeoIFrame();
    log.info("Switch to the Vimeo IFrame");
    vimeoIFrame.playVimeoVideo();
    log.info("The Vimeo video starts to play");
    log.info("Checking the progress of the Vimeo video");
    String timeElapsed = vimeoIFrame.validateVimeoVideoPlayback();
    log.info("The video is paused at: " + timeElapsed);
    Assert.assertEquals(timeElapsed, "00:00 of 04:03");
    log.info("The Vimeo IFrame is played");
    }
}

