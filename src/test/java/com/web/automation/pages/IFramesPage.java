package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Class to play the IFrames
 * @author Harvey.Yepes
 */
public class IFramesPage extends BasePage{

    /**
     * Locators to interact with the frames
     */
    @FindBy(css = "a[href=\"#youtube\"]")
    private WebElement youTubeIframeLink;
    @FindBy(css = "a[href=\"#vimeo\"]")
    private WebElement vimeoIframeLink;


    /**
     * Constructor.
     *
     * @param driver
     * //@param url
     */
    public IFramesPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Page Constructor
     *
     * @param driver to execute
     */
 /*   public IFramesPage(WebDriver driver) {
        super(driver);
    }*/


    /**
     * Method to select the YouTube IFrame video
     */
    public YouTubeIFrame goToYouTubeIFrame(){
        waitElementVisibility(youTubeIframeLink);
        clickOnElement(youTubeIframeLink);
        return new YouTubeIFrame(getDriver());
    }

    /**
     * Method to select the YouTube IFrame video
     */
    public VimeoIFrame goToVimeoIFrame(){
        waitElementVisibility(vimeoIframeLink);
        clickOnElement(vimeoIframeLink);
        return new VimeoIFrame(getDriver());
    }


    /**
     * Method to switch to the Default Content
     */
    public void returnToTheMainPage(){
        getDriver().switchTo().defaultContent();
    }
}
