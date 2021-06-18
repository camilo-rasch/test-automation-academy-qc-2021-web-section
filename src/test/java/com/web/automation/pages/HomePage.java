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

    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-destination-result-item\"]")
    private List<WebElement> destinationResultsList;

    @FindBy(id = "d1-btn")
    private WebElement calendarButton;

    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement submitButton;

    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    @FindBy(css = "div[data-testid='location-field-leg1-origin-container']")
    private WebElement inputDepatureWrapper;

    @FindBy(css = "div[data-testid='location-field-leg1-destination-container']")
    private WebElement inputDestinationWrapper;

    private String focusDayCalendar = "edge";

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
     * Search a one way trip flight
     * @param origin
     * @param destination
     * @param daysFromToday
     * @return
     */
    public ResultsSearchFlight searchFlight(String origin, String destination, int daysFromToday){
        clickOnElement(this.flightsButton);
        clickOnElement(this.oneWayButton);

        waitElementVisibility(this.inputDepatureWrapper);
        clickOnElement(this.inputDepatureWrapper);
        this.departureInput.click();
        this.departureInput.sendKeys(origin);
        for(WebElement element: this.depaturesResultsList){
           if(element.getText().contains(origin)){
               element.click();
           }
        }

        waitElementVisibility(this.inputDestinationWrapper);
        clickOnElement(this.inputDestinationWrapper);
        clickOnElement(this.destinationInput);
        this.destinationInput.sendKeys(destination);
        for(WebElement element: this.destinationResultsList){
            String elementText = element.getText();
            if(elementText.contains(destination)){
                element.click();
            }
        }

        clickOnElement(this.calendarButton);
        int daysCalendarSize = this.calendarDayLists.size();
        int cont = 0;
        boolean selectedDayFlag = false;

        while (cont < daysCalendarSize-1 && !selectedDayFlag){
            if(this.calendarDayLists.get(cont).getAttribute("class").contains(this.focusDayCalendar)){
                this.calendarDayLists.get(cont+daysFromToday).click();
                selectedDayFlag = true;
            }
            cont++;
        }
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);

        return new ResultsSearchFlight(getDriver());
    }
}
