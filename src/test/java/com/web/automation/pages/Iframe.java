package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Iframe extends BasePage{

    @FindBy(id = "zen_cs_desc_with_promo_dynamic")
    private WebElement timeDurationVideo;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public Iframe(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Method to verify if the video is been playing
     * @return boolean
     */

    public boolean videoPlayingVerification() {
        waitElementsVisibility((List<WebElement>) this.timeDurationVideo);
        return this.timeDurationVideo.isDisplayed();
    }


}
