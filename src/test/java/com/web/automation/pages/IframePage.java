package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for iframe Page.
 * @author alejandro.giraldo
 */

public class IframePage extends BasePage {

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public IframePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "button.ytp-large-play-button.ytp-button")//Selects Youtube play Video Button
    private WebElement playTubeButton;

    @FindBy(className= "play-icon")//Selects Vimeo play Video Button
    private WebElement playVimeoButton;

    @FindBy(className = "ytp-time-current") //Selects Current  YouTube played Time label
    private WebElement labelCurrentTime;

    @FindBy(css = "button[class^=ytp-play-button]")//Selects YouTube pause Video Button
    private WebElement pauseTubeVideoButton;

    @FindBy(css = "button[class^='play']")//Selects Vimeo pause Video Button
    private WebElement pauseVimeoButton;

    @FindBy(css = "div[class^=focus]")//Selects Vimeo Time Bar Line
    private WebElement vimeoTimeLineBar;

    /**
     * Plays YouTube Video.
     */
    public void playYouTubeVideo(){
        waitImplicit(2);
        playTubeButton.click();
        //clickOnElementClickeable(playTubeButton);
    }

    /**
     * Pauses YouTube Video.
     */
    public void pauseYoutubeVideo(){
        //waitImplicit(3);
        //pauseTubeVideoButton.click();
        clickOnElementClickeable(playTubeButton);
    }

    /**
     * Gets YouTube Time Played.
     */
    public Boolean getYouTubeTimePlayed(){

        String played = labelCurrentTime.getText();
        if (played!="0:00"){
            return true;
        }
        else return false;
    }

    /**
     * Plays Vimeo Video.
     */
    public void playVimeoVideo(){
        clickOnElementClickeable(playVimeoButton);
    }

    /**
     * Pauses Vimeo Video.
     */
    public void pauseVimeoVideo(){
        clickOnElementClickeable(pauseVimeoButton);
    }


    /**
     * Gets Vimeo Time Played.
     */
    public Boolean getVimeoTimePlayed(){
        String played = vimeoTimeLineBar.getAttribute("aria-valuenow");
        if (played!="00:00"){
            return true;
        }
        else return false;
    }

}
