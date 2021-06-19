package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "div[style*='v64KOxKVLVg'] + button")
    private WebElement playYoutubeVideo;

    @FindBy(css = "button.play.rounded-box.state-paused")
    private WebElement playVimeoVideo;

    @FindBy(css = "section#vimeo")
    private WebElement vimeoSection;

    @FindBy(css = "div#startModal .close")
    private WebElement modalCloseButton;

    private String mainPageHandle = "";


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
     * Click on play button in iFrame (Youtube) and switch to it
     * @return IframePage
     */

    public IframePage clickPlayYoutubeVideo(){
        getDriver().switchTo().frame(0);
        clickOnElement(this.playYoutubeVideo);
        log.info("This is the Youtube Video");
        return new IframePage(getDriver());
        //getDriver().switchTo().defaultContent();
    }

    /**
     * Click on play button in iFrame (Vimeo) and switch to it
     * @return IframePage
     */
    public IframePage clickPlayVimeoVideo()  {
        log.info("This is the scroll to go Vimeo video");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(vimeoSection);
        actions.perform();
        explicitWait(modalCloseButton, 30);
        clickOnElement(modalCloseButton);
        explicitWait(vimeoSection, 30);
        getDriver().switchTo().frame(1);
        log.info("This is the Video Vimeo");
        clickOnElement(playVimeoVideo);
        return new IframePage(getDriver());
    }


    /**
     * Gets the Main page Handle.
     *
     * @return the main page.
     */
    public String getMainPageHandle() {
        return mainPageHandle;
    }

    /**
     * Sets the Main page Handle.
     *
     * @return
     */

    public void setMainPageHandle(String mainPageHandle) {
        this.mainPageHandle = mainPageHandle;
    }

}
