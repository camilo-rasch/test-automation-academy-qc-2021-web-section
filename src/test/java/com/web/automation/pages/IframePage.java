package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage{

    @FindBy(id = "zen_cs_desc_with_promo_dynamic")
    private WebElement timeDurationYoutubeElement;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public IframePage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if the video is playing
     * @return boolean
     */
    public boolean IsTheVideoPlaying(){
        waitElementVisibility(this.timeDurationYoutubeElement);
        return this.timeDurationYoutubeElement.isDisplayed();
    }

    /**
     * Switch to parent window
     * @param handle
     */
    public void switchToMainPage(String handle){
        getDriver().switchTo().defaultContent();
        getDriver().close();
    }
}
