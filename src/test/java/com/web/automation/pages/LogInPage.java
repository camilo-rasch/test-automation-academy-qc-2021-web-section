package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the Log In page.
 * @author jonathan.triana
 */
public class LogInPage extends BasePage{

    //Email field
    @FindBy(css = "#email")
    private WebElement email_field;

    //Password field
    @FindBy(css = "#pass")
    private WebElement password_field;

    //Log in button
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
