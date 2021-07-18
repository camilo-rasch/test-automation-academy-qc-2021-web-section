package com.web.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import static java.lang.Thread.sleep;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    //Locator to find the flights button
    @FindBy(css = "#uitk-tabs-button-container a[href*='flight']")
    private WebElement flightsButton;

    //Locator to find the round trip button
    @FindBy(css = "#uitk-tabs-button-container a[href*='roundtrip']")
    private WebElement roundTripButton;

    //Locator to find the number of travelers option
    @FindBy(css = "[data-testid*='travelers']")
    private WebElement numberOfTravelers;

    //Locator to find the option to increase adult traveler
    @FindBy(css = "[aria-labelledby*='increase-adults']")
    private WebElement increaseAdultTraveler;

    //Locator to find the done button
    @FindBy(css = "[data-testid*='done-button']")
    private WebElement doneButton;

    //Locator to find departure flight input
    @FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInput;

    //Locator to find the result list of the departures
    @FindBy(css = "li[data-stid*='origin-result-item']")
    private List<WebElement> departuresResultsList;

    //Locator to find the destination input
    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInput;

    //Locator to find the result list of the destination
    @FindBy(css = "li[data-stid='location-field-leg1-destination-result-item']")
    private List<WebElement> destinationResultsList;

    //Locator to find the input of the departure wrapper
    @FindBy(css = "div[data-testid='location-field-leg1-origin-container']")
    private WebElement inputDepartureWrapper;

    //Locator to find the input of the destination wrapper
    @FindBy(css = "div[data-testid='location-field-leg1-destination-container']")
    private WebElement inputDestinationWrapper;

    //Locator to find the calendar button
    @FindBy(id = "d1-btn")
    private WebElement calendarButton;

    //Locator to find the button to advance to the next month
    @FindBy(css = ".uitk-calendar>div>button~button")
    private WebElement nextMonthButton;

    //Locator to find the submit button
    @FindBy(css = "button[data-testid='submit-button']")
    private WebElement submitButton;

    //Locator to find the calendar done button
    @FindBy(css = "button[data-stid='apply-date-picker']")
    private WebElement calendarDoneButton;

    //Locator to find the day that I want choose
    private By dayToSelect = By.cssSelector("[data-day='25']");

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
     * Search a round trip flight for 2 adult and select a day in the calendar
     * @param origin origin
     * @param destination destination
     * @return
     */
    public ResultsSearchFlight searchFlight(String origin, String destination) {
        clickOnElement(this.flightsButton);
        clickOnElement(this.roundTripButton);
        increaseTravelers();
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
        calendarChooseDayInTheFuture();
        return new ResultsSearchFlight(getDriver());

    }
    /**
     * Select the number of travelers option,
     * and select 2 adult for the travel and click done button
     *
     */
    public void increaseTravelers(){
        clickOnElement(this.numberOfTravelers);
        clickOnElement(this.increaseAdultTraveler);
        clickOnElement(this.doneButton);
    }
    /**
     * Select the calendar option after that move 2 months in the future,
     * and select the day 25 of the second month displayed
     *
     */
    public void calendarChooseDayInTheFuture() {
        clickOnElement(this.calendarButton);
        clickOnElement(this.nextMonthButton);
        clickOnElement(this.nextMonthButton);
        List<WebElement> myElements = getDriver().findElements(dayToSelect);
        clickOnElement(myElements.get(1));
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);
    }
}
