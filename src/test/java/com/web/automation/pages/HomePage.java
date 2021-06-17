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
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

   @FindBy(css = "p[class='selected-value']")
    private WebElement valueDropdown;

   private Select dropdown;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        dropdown = new Select(getDriver().findElement(By.cssSelector(".form-control")));
    }

    /**
     * Click on Dropdown
     * @return
     */

    public void selectDropdownOption(){
        dropdown.selectByValue("Saturday");
        log.info("This is the Dropdown");
    }

    /**
     * Verify if the option selected is displayed correctly
     * @return String
     */
    public String isTheCorrectOptionSelected(){
        waitElementVisibility(this.valueDropdown);
        log.info("This is the text" + " " + valueDropdown.getText());
        return this.valueDropdown.getText();
    }
}
