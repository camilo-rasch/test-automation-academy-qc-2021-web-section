package com.web.automation.pages;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
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

}
