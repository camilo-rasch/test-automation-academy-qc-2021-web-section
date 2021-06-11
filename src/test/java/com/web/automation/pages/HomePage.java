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

    @FindBy(className = "central-textlogo__image")
    private WebElement title;

    @FindBy(id = "searchInput")
    private WebElement searchField;

    @FindBy(className = "pure-button")
    private WebElement searchButton;

    @FindBy(css = ".link-box Strong")
    private List<WebElement> languages;

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
     * Get Text title
     * @return String text title
     */
    public String getTitle() {
        log.info("Get Text title");
        waitElementVisibility(title);
        return title.getText();
    }


}
