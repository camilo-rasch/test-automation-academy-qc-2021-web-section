package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#passContainer")
    private WebElement password;

    @FindBy(css = "#u_0_h_GO")
    private WebElement loginButton;


    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public LoginPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

}
