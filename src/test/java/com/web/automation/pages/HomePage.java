package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author fabio.alarcon
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
    private WebElement youtubeBanner;

    @FindBy(css = "iframe[src*=\"v64K\"]")
    private WebElement firstVideo;

    @FindBy(css = "button[class=\"ytp-large-play-button ytp-button\"]")
    private WebElement youtubeButton;

    @FindBy(css = "a[href=\"#vimeo\"]")
    private WebElement secondBanner;

    @FindBy(css = "div[class=\"play-icon\"]")
    private WebElement secondVideo;

    @FindBy(css = "video[controlslist=\"nodownload\"]")
    private WebElement assertFirstVideo;

    @FindBy(css = "button[class=\"play rounded-box state-playing\"]")
    private WebElement assertSecondVideo;


    /**
     * Click on the banner to find the first youtube video
     * @return
     */
    public NewIframe clickBanner1(){
        String currentWindowHandle = getDriver().getWindowHandle();

        clickOnElement(this.youtubeBanner);
        return  new NewIframe(getDriver());
    }

    /**
     * Click on the first youtube video
     * @return
     */
    public NewIframe clickOnVideo1(){
        String currentWindowHandle = getDriver().getWindowHandle();

        clickOnElement(this.youtubeButton);
        return  new NewIframe(getDriver());
    }

    /**
     * Click on the banner to find the second youtube video
     * @return
     */
    public NewIframe clickBanner2(){
        String currentWindowHandle = getDriver().getWindowHandle();

        clickOnElement(this.secondBanner);
        return  new NewIframe(getDriver());
    }

    /**
     * Click on the second youtube video
     * @return
     */
    public NewIframe clickOnVideo2(){
        String currentWindowHandle = getDriver().getWindowHandle();

        clickOnElement(this.secondVideo);
        return  new NewIframe(getDriver());
    }


    /**
     * Check the play of the first youtube video
     * @return
     */
    public WebElement assertFirstVideo(){
        return this.assertFirstVideo;

    }

    /**
     * Check the play of the second youtube video
     * @return
     */
    public WebElement assertSecondVideo(){
        return this.assertSecondVideo;

    }
}
