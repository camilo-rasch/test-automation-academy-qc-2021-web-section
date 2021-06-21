package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to play Vimeo IFrame video
 * @author Harvey.Yepes
 */
public class VimeoIFrame extends BasePage {

    /**
     * Locators
     */
    @FindBy(id = "player")
    private WebElement buttonPlayVimeo;

    @FindBy(css = "div .vp-progress div[aria-valuetext]")
    private WebElement timeCurrent;


    /**
     * Constructor.
     *
     * @param driver
     */
    public VimeoIFrame(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to play the Vimeo IFrame video
     */
    public void playVimeoVideo() {
        /**
         * switch to the Iframe
         */
        getDriver().switchTo().frame(1);
        this.buttonPlayVimeo.click();
    }


    /**
     * Method to validate that the Vimeo IFrame video is played
     */
    public String validateVimeoVideoPlayback() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.buttonPlayVimeo.click();
        log.info("Validation" + this.timeCurrent.getText());
        return this.timeCurrent.getText();


    }

    public void returnToTheMainPage(){
        getDriver().switchTo().defaultContent();
        //return new IFramesPage(getDriver());
    }
}