package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "#movie_player div.ytp-cued-thumbnail-overlay > button")
    private WebElement buttonPlayVideoYoutube;

    @FindBy(className = "ytp-time-current")
    private WebElement labelCurrentTime;

    @FindBy(css = ".player-md.player-cardsCorner div:nth-child(7) [class='play-icon']")
    private WebElement buttonPlayVideoVimeo;

    @FindBy(id = "zen_cs_desc_with_promo_dynamic")
    private WebElement timeDurationVideo;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void backToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public IframeYoutube playVideoYoutube() {
        getDriver().switchTo().frame(0);
        waitElementVisibility(this.buttonPlayVideoYoutube);
        clickOnElement(this.buttonPlayVideoYoutube);
        return new IframeYoutube(getDriver());
    }

    public IframeYoutube playVideoVimeo() {
        getDriver().switchTo().frame(1);
        waitElementVisibility(this.buttonPlayVideoVimeo);
        clickOnElement(this.buttonPlayVideoVimeo);
        return new IframeYoutube(getDriver());
    }

    public boolean labelTimeVideoDisplayed() {
        waitElementVisibility(this.labelCurrentTime);
        this.labelCurrentTime.getText();
        log.info(this.labelCurrentTime.getText());
        if(labelCurrentTime.isDisplayed() && this.labelCurrentTime.getText() != "0:00") {
            return true;
        } else {
            return false;
        }
    }
}
