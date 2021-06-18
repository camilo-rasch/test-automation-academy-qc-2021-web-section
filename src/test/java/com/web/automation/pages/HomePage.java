package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
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

    /**
     * wait element to be visible
     * @param element WebElement
     */
    public void waitElementVisibility(WebElement element){getWait().until(ExpectedConditions.visibilityOf(element));}

    /**
     * Method to select an element from a dropdown
     */
    public void selectDropDown(){
        Select myDropDown = new Select(driver.findElement(By.id("select-demo")));
        myDropDown.selectByIndex(1);
        String dropDownText = myDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals("Sunday", dropDownText);
    }

}
