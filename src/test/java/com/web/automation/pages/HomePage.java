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

    private Select pickUpOption;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    @FindBy(css = "select[id=\"select-demo\"]")
    private WebElement selectDropDown;

    @FindBy(css = "option[value=\"Thursday\"]")
    private WebElement dropDownAssertion;

    /**
     * Declare DropDown element
     * @return
     */
    public Select pickUpOption(){
        return new Select(selectDropDown);
    }

    /**
     * Return WebElement to do the assertion validation
     * @return
     */
    public WebElement dropDownAssert(){
        return this.dropDownAssertion;
    }

}
