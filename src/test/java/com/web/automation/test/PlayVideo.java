package com.web.automation.test;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.VideoIFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlayVideo extends BaseTest {
    HomePage homePage;
    @Test(description = "Test to switch to a iFrame")
    public void test1(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on the banner");
        VideoIFrame firstIframe = homePage.playYoutubeVideo();
        log.info("Go into the iframe");
        getDriver().getDriver().switchTo().frame(0);
        log.info("Click to play the video");
        VideoIFrame video1 = homePage.clickOnYoutubeVideo();
        log.info("Initialize assert value");
        WebElement youtubeAssert = homePage.youtubeAssert();
        log.info("Final Assert");
        Assert.assertEquals(true, youtubeAssert.isDisplayed());
        getDriver().getDriver().switchTo().defaultContent();

    }

    @Test(description = "Test to switch to a iFrame")
    public void test2() {
        log.info("Click on the banner 'Vimeo'");
        VideoIFrame banner2 = homePage.playVideoVimeo();
        log.info("Go into the Vimeo iframe");
        getDriver().getDriver().switchTo().frame(1);
        log.info("Click to play the second video");
        VideoIFrame video1 = homePage.clickOnVideoVimeo();
        log.info("Initialize assert value");
        WebElement videoAssert = homePage.vimeoAssert();
        log.info("Final Assert");
        Assert.assertEquals(true, videoAssert.isDisplayed());

    }
}
