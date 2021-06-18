package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author fabio.alarcon
 */
public class HomePage extends BasePage {

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    @FindBy(css = "select[class=\"form-control\"]")
    private WebElement principalList;

    @FindBy(css = "option[value=\"Tuesday\"]")
    private WebElement selectingAnElement;


    /**
     * Click on Dropdown
     */
    public void clickDropDown(){
        String currentWindowHandle = getDriver().getWindowHandle();
        clickOnElement(this.principalList);
    }

    /**
     * Select an option
     */
    public void selectAnOption(){
        String currentWindowHandle = getDriver().getWindowHandle();
        clickOnElement(this.selectingAnElement);
    }

    /**
     * Verify if "Tuesday" option is visible for the user
     * @return boolean
     */
    public boolean isTuesdayVisible(){
        waitElementVisibility(this.selectingAnElement);
        return this.selectingAnElement.isDisplayed();
    }

}
