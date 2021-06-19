package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Class with the methods and locators of home page.
 * @author jonathan.triana
 */

public class HomePage extends BasePage {

    //Locator to find the Youtube link
    @FindBy(css = "[href='#youtube']")
    private WebElement youtubeLink;

    //Locator to find the Vimeo link
    @FindBy(css = "[href='#vimeo']")
    private WebElement vimeoLink;

    /**
     * Page Constructor with url
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }
    /**
     * Method to click on youtube link
     */
    public HomePage clickOnYoutubeLink() {
        clickOnElement(youtubeLink);
        return new HomePage(getDriver());
    }
    /**
     * Method to click on vimeo link
     */
    public HomePage clickOnVimeoLink() {
        clickOnElement(vimeoLink);
        return new HomePage(getDriver());
    }
    /**
     * Method to switch to main page
     */
    public HomePage switchToMain() {
        getDriver().switchTo().defaultContent();
        return new HomePage(getDriver());
    }
}
