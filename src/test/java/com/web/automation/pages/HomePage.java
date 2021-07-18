package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon and norma.losada
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"roundtrip\"]")
    private WebElement roundTripButton;

    @FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-origin-result-item\"]")
    private List<WebElement> departuresResultsList;

    @FindBy(css = "div[data-testid='location-field-leg1-origin-container']")
    private WebElement inputDepartureWrapper;

    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-destination-result-item\"]")
    private List<WebElement> destinationResultsList;

    @FindBy(css = "div[data-testid='location-field-leg1-destination-container']")
    private WebElement inputDestinationWrapper;

    @FindBy(id = "d1-btn")
    private WebElement calendarButton;

    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;

    @FindBy(css = "button[data-stid=\"date-picker-paging\"]:not(.is-disabled)")
    private List<WebElement> nextMonthButton;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement searchButton;

    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    @FindBy(css="a[data-testid=\"travelers-field\"]")
    private WebElement travelersQuantity;

    @FindBy(css="div.adultStepInput svg[aria-labelledby*='increase']")
    private WebElement plusIcon;

    @FindBy(css="button[data-testid=\"guests-done-button\"]")
    private WebElement travelersDoneButton;

    @FindBy(xpath="//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button")
    private WebElement buttonSearch;

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
     * Search a one round trip flight
     * @param origin origin
     * @param destination destination
     * @param daysToDeparture days from the next month to departure
     * @param daysToReturn days from the next month to return
     * @return Result search flight page
     */
    public ResultsSearchFlight searchFlight(String origin, String destination, int daysToDeparture, int daysToReturn){
        clickOnElement(this.flightsButton);
        clickOnElement(this.roundTripButton);

        waitElementVisibility(this.inputDepartureWrapper);
        clickOnElement(this.inputDepartureWrapper);
        this.departureInput.click();
        this.departureInput.sendKeys(origin);
        for(WebElement element: this.departuresResultsList){
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

        clickOnElement(this.travelersQuantity);
        clickOnElement(this.plusIcon);
        clickOnElement(this.travelersDoneButton);

        clickOnElement(this.calendarButton);
        waitElementVisibility(this.nextMonthButton.get(1));
        clickOnElement(this.nextMonthButton.get(1));
        this.calendarDayLists.get(daysToDeparture).click();
        this.calendarDayLists.get(daysToReturn).click();
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.searchButton);
        return new ResultsSearchFlight(getDriver());
    }
}
