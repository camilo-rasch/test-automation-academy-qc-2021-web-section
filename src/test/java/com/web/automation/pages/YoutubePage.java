package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class YoutubePage extends BasePage {

    @FindBy(css = "button.ytp-large-play-button.ytp-button")
    private WebElement youtubeVideo;

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
    // Methods Youtube page
    public YoutubePage clickOnYoutubeVideo() {
        clickOnElement(youtubeVideo);
        return new YoutubePage(getDriver());
    }
    public YoutubePage switchToIframe0() {
        getDriver().switchTo().frame(0);
        return new YoutubePage(getDriver());
    }
}
