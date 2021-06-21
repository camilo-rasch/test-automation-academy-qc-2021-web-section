package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VimeoIframePage extends BasePage{

    @FindBy (css = ".player-md.player-cardsCorner div:nth-child(7) [class='play-icon']")
    private WebElement playVimeoButton;

    /**
     * Constructor.
     * @param driver WebDriver
     */
    public VimeoIframePage(WebDriver driver) {
        super(driver);

    }

    /**
     * Click on the Vimeo play button.
     * @return
     */
    public void playVimeoVideo(){
        waitElementVisibility(playVimeoButton);
        this.playVimeoButton.click();
    }

    /**
     * Verify if the play button is displayed.
     * @return boolean
     */
    public boolean isPlayButtonDisplayed(){
        return playVimeoButton.isDisplayed();
    }

    /**
     * Doing switch to default content.
     * @return
     */
    public void switchDefaultContent(){
        getDriver().switchTo().defaultContent();
    }

}
