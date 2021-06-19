package com.web.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YouTubeIframePage extends BasePage {

    @FindBy(css = "[id='movie_player'] div:nth-child(5) [aria-label='Play']")
    private WebElement playYouTubeButton;

    @FindBy(css = "[class='ytp-webgl-spherical-control']")
    private WebElement sphericalControl;


    /**
     * Constructor.
     *
     * @param driver WebDriver
     */
    public YouTubeIframePage(WebDriver driver) {
        super(driver);

    }

    public void playYouTubeVideo() {
        waitElementVisibility(playYouTubeButton);
        playYouTubeButton.click();
    }

    public boolean isSphericalControlDisplayed(){
       waitElementVisibility(sphericalControl);
       return sphericalControl.isDisplayed();
    }

    public void switchDefaultContent(){
        getDriver().switchTo().defaultContent();
    }

}
