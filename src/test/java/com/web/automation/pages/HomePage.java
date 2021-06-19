package com.web.automation.pages;

import com.web.automation.driver.Driver;
import org.openqa.selenium.WebDriver;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 * @modifyed by alejandro.giraldo
 */
public class HomePage extends BasePage {

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
     * Change to YouTube Iframe Focus.
     */
    public WebDriver changeYoutubeFrameFocus() {
        return getDriver().switchTo().frame(0);
    }

    /**
     * Change to Vimeo Iframe Focus.
     */
    public WebDriver changeVimeoFrameFocus() {
        return getDriver().switchTo().frame(1);
    }

    /**
     * Change to default Content.
     */
    public WebDriver changeDefaultContent() {
        return getDriver().switchTo().defaultContent();
    }

    /**
     * Return homePageDriver
     */
    public WebDriver getHomePage(){
        return this.getDriver();
    }
}
