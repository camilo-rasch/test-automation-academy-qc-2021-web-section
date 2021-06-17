package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "div[style*='v64KOxKVLVg'] + button")
    private WebElement playYoutubeVideo;

    @FindBy(css = "div[data-thumb*='533212504']")
    private WebElement playVimeoVideo;

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
     * @return
     */

    public IframePage clickPlayYoutubeVideo(){
        getDriver().switchTo().frame(0);
        clickOnElement(this.playYoutubeVideo);
        log.info("This is the Youtube Video");
        return new IframePage(getDriver());
       // getDriver().switchTo().defaultContent();
    }

    /**
     * Click on play button in iFrame (Youtube) and switch to it
     * @return
     */
    public IframePage clickPlayVimeoVideo(){
        getDriver().switchTo().frame(1);
        clickOnElement(this.playVimeoVideo);
        log.info("This is the Vineo Video");
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

    public void setMainPageHandle(String mainPageHandle) {
        this.mainPageHandle = mainPageHandle;
    }

}
