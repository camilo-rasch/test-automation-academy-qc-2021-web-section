package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class with the methods and locators of Vimeo page.
 * @author jonathan.triana
 */
public class VimeoPage extends BasePage{

    //Locator to play the video
    @FindBy(css = "div.play-icon")
    private WebElement vimeoVideo;

    //Locator with the time of the progress
    @FindBy(css = "[aria-label='Progress Bar']")
    private WebElement progressBar;
    /**
     * Page Constructor with url
     * @param driver to execute
     * @param url    to get
     */
    public VimeoPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public VimeoPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to play the Vimeo video
     */
    public VimeoPage clickOnVimeoVideo() {
        clickOnElement(vimeoVideo);
        return new VimeoPage(getDriver());
    }
    /**
     * Method to switch to vimeo Iframe
     */
    public VimeoPage switchToIframe1() {
        getDriver().switchTo().frame(1);
        return new VimeoPage(getDriver());
    }
    /**
     * Method check the progress of the video
     * @return the the value of the attribute aria label (time)
     */
    public String getProgressBarValue() {
        waitElementVisibility(progressBar);
        String timeVideo = progressBar.getAttribute("aria-valuenow").toString();
        return timeVideo;
    }
}
