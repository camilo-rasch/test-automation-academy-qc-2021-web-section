package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author hernan.barroso
 */
public class HomePage extends BasePage {

    @FindBy(css = "div[id='scrollspy'] ul li:nth-child(3) [href='#vimeo']")
    private WebElement linkVimeoIframe;


    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void clickLinkVimeo(){
        waitElementVisibility(linkVimeoIframe);
        linkVimeoIframe.click();
    }

    public YouTubeIframePage switchToYouTubeIframePage() {
        getDriver().switchTo().frame(0);
        return new YouTubeIframePage(getDriver());
    }

    public VimeoIframePage switchToVimeoframePage(){
        getDriver().switchTo().frame(1);
        return new VimeoIframePage(getDriver());
    }

}
