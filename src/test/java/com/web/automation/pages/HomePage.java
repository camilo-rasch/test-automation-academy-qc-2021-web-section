package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "a[data-testid=\"loginButton\"]")
    private WebElement loginButton;
    
    @FindBy(css = "a[data-testid=\"signupButton\"]")
    private WebElement signUpButton;

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
