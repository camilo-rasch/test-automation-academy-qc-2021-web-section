package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement email_label;

    @FindBy(css = "#pass")
    private WebElement password_label;

    @FindBy(css = "#u_0_h_1w")
    private WebElement login_button;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public LogInPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
}
