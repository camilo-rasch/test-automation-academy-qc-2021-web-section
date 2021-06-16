package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //FacebookLogOut
    @FindBy(css = "div[role='button'] > img")
    private WebElement actionList;
    @FindBy(xpath = "//span[contains(text(), 'Cerrar sesión')]")
    private WebElement logOutLabelButton;


    //goProfilePage
    @FindBy(css = "[data-pagelet] .buofh1pr:nth-of-type(1) > ul:nth-of-type(1) .stjgntxs")
    private WebElement profileLabelButton;





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
