package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Class for interact with the home page.
 * @author juancarlos.ortiz
 */
public class HomePage extends BasePage {

    @FindBy(id = "select-demo']")
    private WebElement selectDropDown;

    @FindBy(css = "p.selected-value")
    private WebElement selectedValue;

    /**
     * getter for webelement selectDropDown
     * @return
     */
    public WebElement getSelectDropDown() {
        return selectDropDown;
    }

    public WebElement getSelectedValue() {
        return selectedValue;
    }

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Method to instantiate the dropdown element
     * @param dropDownOption for the value to select in the dropdown
     */
    public void getDropdownValue(String dropDownOption) {
        Select myDropDown = new Select(getDriver().findElement(By.id("select-demo")));
        myDropDown.selectByValue(dropDownOption);

    }











}
