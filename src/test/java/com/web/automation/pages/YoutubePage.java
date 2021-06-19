package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class with the methods and locators of Youtube page.
 * @author jonathan.triana
 */
public class YoutubePage extends BasePage {

    //Locator to play the video
    @FindBy(css = "button.ytp-large-play-button.ytp-button")
    private WebElement youtubeVideo;

    //Locator with the state of the video
    @FindBy(css = ".ytp-play-button.ytp-button")
    private WebElement progressBar;

    /**
     * Page Constructor with url
     * @param driver to execute
     * @param url    to get
     */
    public YoutubePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public YoutubePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to play the Youtube video
     */
    public YoutubePage clickOnYoutubeVideo() {
        clickOnElement(youtubeVideo);
        return new YoutubePage(getDriver());
    }
    /**
     * Method to switch to Youtube Iframe
     */
    public YoutubePage switchToIframe0() {
        getDriver().switchTo().frame(0);
        return new YoutubePage(getDriver());
    }
    /**
     * Method check the state of the video (play or pause)
     * @return the the value og the aria label (Pause (k))
     */
    public String getProgressBarValue() {
        String stateVideo = progressBar.getAttribute("aria-label").toString();
        return stateVideo;
    }
}