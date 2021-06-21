package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class to play YouTube IFrame video
 * @author Harvey.Yepes
 */
public class YouTubeIFrame extends BasePage {

    /**
     * Locators
     */
    @FindBy(id = "player")
    private WebElement buttonPlayYoutube;

    @FindBy(css = ".ytp-time-current")
    private WebElement timeCurrent;

    /**
     * Constructor.
     *
     * @param driver
     */
    public YouTubeIFrame(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to play the YouTube IFrame video
     */
    public void playYoutubeVideo(){
        /**
         * switch to the Iframe and interact with it
         */
        getDriver().switchTo().frame(0);
        this.buttonPlayYoutube.click();
    }


    /**
     * Method to validate that the YouTube IFrame video is played
     */
    public String validateYouTubeVideoPlayback() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.buttonPlayYoutube.click();
        return this.timeCurrent.getText();
    }




}