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
        this.dropdown = new Select(getDriver().findElement(By.id("select-demo")));
    }

    /**
     * Constructor
     * @param pDriver
     */
    public DropdownPage(WebDriver pDriver) {
        super(pDriver);

    }

    /**
     * Method to select from a dropdown by index
     */
    public String selectOptionByIndex(){
        this.dropdown.selectByIndex(2);
        return this.dropdown.getFirstSelectedOption().getText();
    }


    /**
     * Method to select from a dropdown by value
     */
    public String selectOptionByValue(){
        this.dropdown.selectByValue("Saturday");
        return this.dropdown.getFirstSelectedOption().getText();
    }


    /**
     * Method to select from a dropdown by visible text (not recommended)
     */
    public String selectOptionByVisibleText(){
        this.dropdown.selectByVisibleText("Wednesday");
        return this.dropdown.getFirstSelectedOption().getText();
    }


    /**
     * Method to validate the day selected from the dropdown
     * @return
     */
    public String validateDaySelected(){
        waitElementVisibility(daySelected);
        return daySelected.getText();
    }
}
