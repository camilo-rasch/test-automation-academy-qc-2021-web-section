package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy (css = "p[class=\"selected-value\"]")
    private WebElement optionSelected;

    Select dropDown;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */

    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        this.dropDown = new Select(getDriver().findElement(By.id("select-demo")));
    }

    public void selectOptionDropdown() {
        dropDown.selectByValue("Sunday");

    }

    public boolean isElementSelected() {
        waitElementVisibility((this.optionSelected));
        return optionSelected.isDisplayed();
    }
}
