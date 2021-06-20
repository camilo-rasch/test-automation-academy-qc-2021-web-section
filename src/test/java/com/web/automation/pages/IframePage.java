package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IframePage extends BasePage{

    @FindBy(css = "button[aria-label='Pause (k)']")
    private WebElement playingYoutubeVideo;

    @FindBy(css = ".vp-controls-wrapper button[class='play rounded-box state-playing']")
    private WebElement playingVimeoVideo;

    @FindBy(css = ".vp-controls-wrapper button[class='play rounded-box state-paused']")
    private WebElement pausedVimeoVideo;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public IframePage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if the Youtube video is playing
     * @return boolean
     */
    public boolean isTheYoutubeVideoPlaying(){
        boolean isPlaying = false;
        log.info("The Youtube video is playing");
        if(playingYoutubeVideo.isDisplayed()){
                isPlaying = true;
        }else{
            isPlaying = false;
        }
        return isPlaying;
    }

    /**
     * Verify if the Vimeo video is playing
     * @return boolean
     */
    public boolean isTheVimeoVideoPlaying(){
        boolean isPlaying = false;
        log.info("The Vimeo video is playing");
        if(playingVimeoVideo.isDisplayed()){
            isPlaying = true;
        }else{
            isPlaying = false;
        }
        return isPlaying;
    }

    /**
     * Switch to parent window
     * @param
     */
    public void switchToMainPage(){
        getDriver().switchTo().defaultContent();
    }
}
