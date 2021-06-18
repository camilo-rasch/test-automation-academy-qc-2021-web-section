package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author juandaniel.castano
 */
public class HomePage extends BasePage {

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    @FindBy(css = "a[href=\"#youtube\"]")
    private WebElement youtubeLink;

    @FindBy(css = "iframe[src*=\"v64\"]")
    private WebElement youtubeIFrame;

    @FindBy(css = "button[class=\"ytp-large-play-button ytp-button\"]")
    private WebElement youtubeVideoPlayButton;

    @FindBy(css = "a[href=\"#vimeo\"]")
    private WebElement vimeoLink;

    @FindBy(css = "div[class=\"play-icon\"]")
    private WebElement vimeoVideoPlayButton;

    @FindBy(css = "video[controlslist=\"nodownload\"]")
    private WebElement youtubeVideoAssertion;

    @FindBy(css = "button[class=\"play rounded-box state-playing\"]")
    private WebElement vimeoVideoAssertion;

    /**
     * Click on 'Youtube' link to address to Youtube video
     * @return
     */
    public VideoIFrame playYoutubeVideo(){
        clickOnElement(this.youtubeLink);
        return  new VideoIFrame(getDriver());

    }

    /**
     * Click on the play button of Youtube video
     * @return
     */
    public VideoIFrame clickOnYoutubeVideo(){
        clickOnElement(this.youtubeVideoPlayButton);
        return  new VideoIFrame(getDriver());
    }

    /**
     * Click on 'Vimeo' link to address to Vimeo video
     * @return
     */
    public VideoIFrame playVideoVimeo(){
        clickOnElement(this.vimeoLink);
        return new VideoIFrame(getDriver());
    }
    /**
     * Click on the play button of Vimeo video
     * @return
     */
    public VideoIFrame clickOnVideoVimeo(){
        clickOnElement(this.vimeoVideoPlayButton);
        return new VideoIFrame(getDriver());
    }

    /**
     * Return WebElement value to assertion to youtube video
     * @return
     */
    public WebElement youtubeAssert(){
        return this.youtubeVideoAssertion;
    }

    /**
     * Return WebElement value to assertion to vimeo video
     * @return
     */
    public WebElement vimeoAssert(){
        return this.vimeoVideoAssertion;
    }

}
