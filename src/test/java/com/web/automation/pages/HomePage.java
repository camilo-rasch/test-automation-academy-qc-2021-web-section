package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author hernan.barroso
 */
public class HomePage extends BasePage {

    @FindBy (css = "p.selected-value")
    private WebElement selectedDay;

    private Select myDropDown;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        this.myDropDown = new Select(getDriver().findElement(By.id("select-demo")));
    }

    /**
     * Select "Friday" value in the dropdown
     * @return
     */
    public void selectOptionFromDropDown(){

        this.myDropDown.selectByValue("Friday");
    }

    /**
     * Verify if "selectDay" webelement is displayed
     * @return boolean
     */
    public boolean isSelectedDayDisplayed(){
        waitElementVisibility(selectedDay);
        return selectedDay.isDisplayed();
    }
}
