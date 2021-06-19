package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author camilo.mogollon
 * @modified by Alejandro.Giraldo
 */

public class HomePage extends BasePage{

    @FindBy(css="select#select-demo option")//Selects All DropDownList Elements
    private List<WebElement> daysList;


    @FindBy(css="p.selected-value")//Selects Label that shows Option Selected
    private WebElement labelDayPicked;

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
     * selects option form list
     *
     * @param day String
     */
    public WebElement selectOptionList(String day){
        WebElement elementOptionPicked = null;

        for(WebElement element: this.daysList){
            String elementText = element.getText();
            if(elementText.contains(day)){
                elementOptionPicked= element;
                element.click();
            }
        }
        return elementOptionPicked;
    }

    /**
     * Assert to verify option selected vs option sent
     *
     * @param optionPicked WebElement
     */
    public boolean isDayPicked(WebElement optionPicked, String day){

        if (optionPicked.getText().contains(day)==labelDayPicked.getText().contains(day)){
            return true;
        }else return false;
    }
}