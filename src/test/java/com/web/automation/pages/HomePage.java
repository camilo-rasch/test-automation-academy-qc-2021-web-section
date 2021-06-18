package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "[href='#youtube']")
    private WebElement youtubeLink;

    @FindBy(css = "button.ytp-large-play-button.ytp-button")
    private WebElement youtubeVideo;

    @FindBy(css = "[href='#vimeo']")
    private WebElement vimeoLink;

    /*@FindBy(css = "[src*='1378']")
    private WebElement vimeoVideo;*/
    @FindBy(css = "div.play-icon")
    private WebElement vimeoVideo;

    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     *
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnYoutubeLink() {
        clickOnElement(youtubeLink);
        return new HomePage(getDriver());
    }
    public HomePage clickOnYoutubeVideo() {
        clickOnElement(youtubeVideo);
        return new HomePage(getDriver());
    }
    public HomePage clickOnVimeoLink() {
        clickOnElement(vimeoLink);
        return new HomePage(getDriver());
    }
    public HomePage clickOnVimeoVideo() {
        clickOnElement(vimeoVideo);
        return new HomePage(getDriver());
    }
   public HomePage switchIframe() {
        getDriver().switchTo().frame(0);
        return new HomePage(getDriver());
    }

    public HomePage switchMain() {
        getDriver().switchTo().defaultContent();
        return new HomePage(getDriver());
    }

    public HomePage switchIframe1() {
        getDriver().switchTo().frame(1);
        return new HomePage(getDriver());
    }
}
