package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.IframePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test Class for Vimeo Video iframe.
 * @author alejandro.giraldo
 */

public class VimeoVideoTest extends BaseTest {

    IframePage iframePage;
    HomePage homePage;

    @BeforeMethod(description = "Change iFrameFocus")
    public void changeFocus(){
        homePage= getHomePage();
        WebDriver frameDriver= homePage.changeVimeoFrameFocus();
        iframePage=new IframePage(frameDriver);
    }

    @AfterMethod(description = "Change to DefaultContent")
    public void changeDefaultContent(){
        homePage.changeDefaultContent();
    }

    @Test(description = "Test to verify if an Iframe Vimeo Video is Played")
    public void youVimeoTest(){
        log.info("play Vimeo Video");
        iframePage.playVimeoVideo();
        log.info("Pause Vimeo Video");
        iframePage.pauseVimeoVideo();
        log.info("Vimeo Video Played?");
        Assert.assertTrue(iframePage.getVimeoTimePlayed(), "Verify if Video has been played");
    }

}

