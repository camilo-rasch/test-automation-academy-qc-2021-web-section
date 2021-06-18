package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "a[href*='#youtube']")
    private WebElement youtubeMenuOption;

    @FindBy(css = "a[href*='#vimeo']")
    private WebElement vimeoMenuOption;

    @FindBy(css = "#movie_player > div.ytp-cued-thumbnail-overlay > button")
    private WebElement playYoutubeButton;

    @FindBy(css = "#player > div.vp-controls-wrapper > div.vp-controls > button")
    private WebElement playVimeoButton;

    @FindBy(css = "#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > button")
    private WebElement ytProgressBar;

    //@FindBy(css = "#player > div.vp-controls-wrapper > div.vp-controls > button > div.pause-icon")
    //private WebElement vimeoPauseIcon;


    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * wait element to be visible
     * @param element WebElement
     */
    public void waitElementVisibility(WebElement element){getWait().until(ExpectedConditions.visibilityOf(element));}

    /**
     * click on element
     * @param element
     */
    public void clickOnElement(WebElement element){
        waitElementVisibility(element);
        element.click();
    }

    /**
     * play a youTube video
     */
    public void playYouTubeVideo(){
        clickOnElement(this.youtubeMenuOption);
        driver.switchTo().frame(0);
        clickOnElement(this.playYoutubeButton);
        Assert.assertTrue((ytProgressBar).isDisplayed());
        driver.switchTo().defaultContent();

    }

    /**
     * play a vimeo video
     */
    public void playVimeoVideo(){
        clickOnElement(this.vimeoMenuOption);
        driver.switchTo().frame(1);
        clickOnElement(this.playVimeoButton);
        Assert.assertEquals((playVimeoButton).getAttribute("class"), "play rounded-box state-playing");
        driver.switchTo().defaultContent();

    }


}
