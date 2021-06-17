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
 * @author Jessica.cardona
 */
public class HomePage extends BasePage {
	
	@FindBy(id="select-demo")
	private WebElement select;
		
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
     * Select Dropdown day
     * @param day
     */
    public void selectDropDownDay(String day) {
    
    	Select dayDropDown = new Select(getDriver().findElement(By.id("select-demo")));
     	dayDropDown.selectByValue(day);
    }
    
    /**
     * Get string from a selected day
     * @return
     */
    public String getDropdownSelectedDay() {
    	
    	Select dayDropDown = new Select(getDriver().findElement(By.id("select-demo")));
    	String selectedDay = dayDropDown.getFirstSelectedOption().getText();
    	return selectedDay;
    	
    }
}
