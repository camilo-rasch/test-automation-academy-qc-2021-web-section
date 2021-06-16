package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".bp9cbjyn a[href='/me/']")
    private WebElement profileButton;

    @FindBy(css = "[role='navigation'] > span div div:nth-child(1)")
    private WebElement accountButton;

    @FindBy(css = ".ecm0bbzt div:nth-child(4)")
    private WebElement logoutButton;


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
