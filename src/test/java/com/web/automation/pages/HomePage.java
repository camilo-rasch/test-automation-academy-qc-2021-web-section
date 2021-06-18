package com.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    //Home page
    @FindBy(css = "[href='#youtube']")
    private WebElement youtubeLink;

    @FindBy(css = "[href='#vimeo']")
    private WebElement vimeoLink;

    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     *
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Methods Home page
    public HomePage clickOnYoutubeLink() {
        clickOnElement(youtubeLink);
        return new HomePage(getDriver());
    }

    public HomePage clickOnVimeoLink() {
        clickOnElement(vimeoLink);
        return new HomePage(getDriver());
    }

    public HomePage switchToMain() {
        getDriver().switchTo().defaultContent();
        return new HomePage(getDriver());
    }
}
