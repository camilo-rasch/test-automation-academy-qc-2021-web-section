package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "[href='#youtube']")
    private WebElement youtubeLink;

    @FindBy(css = "[src*='v64KOxKVLVg']")
    private WebElement youtubeVideo;

    @FindBy(css = "[href='#vimeo']")
    private WebElement vimeoLink;

    @FindBy(css = "[src*='1378']")
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
   /*public HomePage switchIframe() {
        getDriver().switchTo().frame(1);
        return new HomePage(getDriver());
    }*/
}
