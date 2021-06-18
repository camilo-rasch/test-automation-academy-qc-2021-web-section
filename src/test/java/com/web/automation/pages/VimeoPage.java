package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class VimeoPage extends BasePage{

    @FindBy(css = "div.play-icon")
    private WebElement vimeoVideo;

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
    public VimeoPage clickOnVimeoVideo() {
        clickOnElement(vimeoVideo);
        return new VimeoPage(getDriver());
    }
    public VimeoPage switchToIframe1() {
        getDriver().switchTo().frame(1);
        return new VimeoPage(getDriver());
    }
}
