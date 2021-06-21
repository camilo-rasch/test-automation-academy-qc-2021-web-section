package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class DropdownPage extends BasePage {

    /**
     * Locators to assert the day selected
     */
    @FindBy(css = ".selected-value")
    WebElement daySelected;


    /**
     * Declare the attribute to instantiate the methods
     */
    Select dropdown;
    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public DropdownPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Constructor
     * @param pDriver
     */
    public DropdownPage(WebDriver pDriver) {
        super(pDriver);
        this.dropdown = new Select(pDriver.findElement(By.id("select-demo")));
    }

    /**
     * Method to select from a dropdown by index
     */
    public WebElement selectOptionByIndex(){
        this.dropdown.selectByIndex(1);
        return daySelected;
    }

    /**
     * Method to select from a dropdown by value
     */
    public WebElement selectOptionByValue(){
        this.dropdown.selectByValue("Saturday");
        return daySelected;
    }

    /**
     * Method to select from a dropdown by visible text (not recommended)
     */
    public WebElement selectOptionByVisibleText(){
        this.dropdown.selectByVisibleText("wednesday");
        return daySelected;
    }

}
