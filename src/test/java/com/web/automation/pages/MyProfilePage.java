package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage {

    @FindBy(css = ".soycq5t1 div a[href='https://www.facebook.com/hebarroso/friends']")
    private WebElement friendButton;

    @FindBy(css = "[data-pagelet='ProfileActions'] div div div:nth-child(3) div:nth-child(1)[role='button']")
    private WebElement sendMessageButton;


    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public MyProfilePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

}
