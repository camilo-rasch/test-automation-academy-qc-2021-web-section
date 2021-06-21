package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    /**
     * Declare the object dropDown to instantiate
     */
    Select dropDown;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public DropdownPage(WebDriver pDriver) {
        super(pDriver);
        this.dropDown = new Select(getDriver().findElement(By.id("select-demo")));
    }

    /**
     * Selecting a value from the dropdown by index
     */
    public void mondayOptionByIndex(){
        dropDown.selectByIndex(1);
    }

    /**
     * Selecting a value from the dropdown by value
     */
    public void saturdayOptionByValue(){
        dropDown.selectByValue("Saturday");
    }

    /**
     * Selecting a value from the dropdown by visible text (not recommended)
     */
    public void wednesdayOptionByVisibleText(){
        dropDown.selectByVisibleText("wednesday");
    }
}
