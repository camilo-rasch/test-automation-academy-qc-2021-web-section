package com.web.automation.test;

import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.NewIframe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayYoutubeVideo extends BaseTest {
    HomePage homePage;

    @Test(description = "Test to play the first youtube video")
    public void test1(){
        log.info("Opening homePage");
        homePage = getHomePage();
        log.info("Click on the banner");
        NewIframe banner = homePage.clickBanner1();
        log.info("Go into the iframe");
        getDriver().getDriver().switchTo().frame(0);
        log.info("Click to play the video");
        NewIframe video1 = homePage.clickOnVideo1();
        log.info("Assert");
        WebElement assert1 = homePage.assertFirstVideo();
        log.info("Final Assert");
        Assert.assertEquals(true, assert1.isDisplayed());
        getDriver().getDriver().switchTo().defaultContent();

}

    @Test(description = "Test to play the second youtube video")
    public void test2() {
        log.info("Click on the banner 'Vimeo'");
        NewIframe banner2 = homePage.clickBanner2();
        log.info("Go into the Vimeo iframe");
        getDriver().getDriver().switchTo().frame(1);
        log.info("Click to play the second video");
        NewIframe video1 = homePage.clickOnVideo2();
        //NewIframe newIframe = homePage.clickOnVideo2();
        log.info("Assert");
        WebElement assert2 = homePage.assertSecondVideo();
        log.info("Final Assert");
        Assert.assertEquals(true, assert2.isDisplayed());
    }

}
