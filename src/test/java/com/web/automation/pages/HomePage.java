package com.web.automation.pages;

import com.web.automation.test.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "#movie_player div.ytp-cued-thumbnail-overlay > button")
    private WebElement buttonPlayVideoYoutube;

    @FindBy(css = "div[aria-valuetext*=\"5 Minutes\"]")
    private WebElement buttonPlayVideoVimeo;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public Iframe playVideoYoutube() {
        getDriver().switchTo().frame(1);
        clickOnElement(this.buttonPlayVideoYoutube);
        getDriver().switchTo().defaultContent();
        return new Iframe(getDriver());
    }

    public Iframe playVideoVimeo() {
        getDriver().switchTo().frame(2);
        clickOnElement(this.buttonPlayVideoVimeo);
        getDriver().switchTo().defaultContent();
        return new Iframe(getDriver());
    }









}
