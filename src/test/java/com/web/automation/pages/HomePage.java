package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"one\"]")
    private WebElement oneWayButton;

    @FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-origin-result-item\"]")
    private List<WebElement> depaturesResultsList;

    @FindBy(css = "section #location-field-leg1-destination-input")
    private WebElement destinationInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-origin-result-item\"]")
    private List<WebElement> destinationResultsList;

    @FindBy(id = "d1-btn")
    private WebElement calendarButton;

    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement submitButton;

    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    private String focusDayCalendar = "edge";
    private String inputDepatureSelector = "div[data-testid='location-field-leg1-origin-container']";
    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void searchFlight(String origin, String destination, int daysFromToday){
        clickOnElement(this.flightsButton);
        clickOnElement(this.oneWayButton);

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputDepatureSelector)));
        WebElement divPrueba = getDriver().findElement(By.cssSelector(this.inputDepatureSelector));
        divPrueba.click();
        this.departureInput.click();
        this.departureInput.sendKeys(origin);
        for(WebElement element: this.depaturesResultsList){
           if(element.getText().contains(origin)){
               element.click();
           }
        }

        clickOnElement(this.destinationInput);
        this.destinationInput.sendKeys(destination);
        for(WebElement element: this.destinationResultsList){
            if(element.getText().contains(destination)){
                element.click();
            }
        }

        clickOnElement(this.calendarButton);
        int daysCalendarSize = this.calendarDayLists.size();
        for(int i=0; i<daysCalendarSize-1;i++){
            if(this.calendarDayLists.get(i).getAttribute("class").contains(this.focusDayCalendar)){
                this.calendarDayLists.get(i+daysFromToday).click();
            }
        }
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);
    }
}
