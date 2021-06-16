package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutFacebook extends BasePage {

    @FindBy (css = "By.css(div[aria-label] > span > div[class] div[aria-label])" )
    private WebElement arrowDropdownMenu;

    @FindBy (css = "By.css(div.knvmm38d div[aria-label='Cuenta'] div[data-nocookies] div[role='button'])" )
    private WebElement optionLogout;



    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LogOutFacebook(WebDriver pDriver) {
        super(pDriver);
    }
}
