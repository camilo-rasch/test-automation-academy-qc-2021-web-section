package com.web.automation.pages;

import com.web.automation.pojo.Flight;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author juandaniel.castano@globant.cm
 */

public class HomePage extends BasePage {

    /**
     * WebElements are defined
     */

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"roundtrip\"]")
    private WebElement roundTripButton;

    @FindBy(css = "[data-testid=\"travelers-field\"]")
    private WebElement travelersButton;

    @FindBy(css = "[data-testid=\"room-1\"] div:first-child button:last-child")
    private WebElement increaseTravelerNumberButton;

    @FindBy(css = "[data-testid=\"guests-done-button\"]")
    private WebElement guestDoneButton;

    @FindBy(css = "div[data-testid='location-field-leg1-origin-container']")
    private WebElement inputDepartureSelector;

    @FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInputField;

    @FindBy(css = "li[data-stid=\"location-field-leg1-origin-result-item\"]")
    private List<WebElement> departuresResultList;

    @FindBy(css = "div[data-testid=\"location-field-leg1-destination-container\"]")
    private WebElement inputDestinationSelector;

    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInputField;

    @FindBy(css = "li[data-stid=\"location-field-leg1-destination-result-item\"]")
    private List<WebElement> destinationsResultList;

    @FindBy(id = "d1-btn")
    private WebElement departingCalendarButton;

    @FindBy(css = "button[data-stid=\"date-picker-paging\"]:last-child")
    private WebElement forwardMonthButton;

    @FindBy(css = "td button.uitk-date-picker-day")
    private List<WebElement> calendarDaysList;

    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    @FindBy(id = "d2-btn")
    private WebElement returningCalendarButton;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement searchButton;

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
     * Click On action in specific WebElement
     */

    public void clickOnFlightButton(){
        clickOnElement(flightsButton);
    }

    /**
     * Click On action in specific WebElement
     */

    public void clickOnRoundTripButton(){
        clickOnElement(roundTripButton);
    }

    /**
     * Click On action in specific WebElement
     */

    public void clickOnTravelerNumberButton(){
        clickOnElement(travelersButton);
        clickOnElement(increaseTravelerNumberButton);
        clickOnElement(guestDoneButton);
    }

    /**
     * Send keys and click on specific WebElement
     */

    public void selectDepartureAirport(Flight flight){
        clickOnElement(inputDepartureSelector);
        clickOnElement(departureInputField);
        sendKeysOnElement(departureInputField, flight.getDeparture());
        for (WebElement element: this.departuresResultList) {
            if(element.getText().contains(flight.getDeparture())){
                element.click();
            }
        }
    }

    /**
     * Send keys and click on specific WebElement
     */

    public void selectDestinationAirport(Flight flight){
        clickOnElement(inputDestinationSelector);
        clickOnElement(destinationInputField);
        sendKeysOnElement(destinationInputField, flight.getDestination());
        for (WebElement element : this.destinationsResultList) {
            if(element.getText().contains(flight.getDestination())){
                element.click();
            }
        }
    }

    /**
     * Click On action in specific WebElement
     */

    public void pickOnDateOfDepartingCalendar(){
        clickOnElement(this.departingCalendarButton);
        int counter = 0;
        while(counter < 2) {
            clickOnElement(this.forwardMonthButton);
            counter++;
        }
        for (WebElement element : this.calendarDaysList) {
            if (element.getAttribute("data-day").contains("31")) {
                clickOnElement(element);
            }
        }
        clickOnElement(this.calendarDoneButton);
    }

    /**
     * Click On action in specific WebElement
     */

    public void pickOnDateOfDestinationCalendar(){
        clickOnElement(this.returningCalendarButton);
        clickOnElement(this.forwardMonthButton);
        for (WebElement element : this.calendarDaysList) {
            if (element.getAttribute("data-day").contains("31")) {
                clickOnElement(element);
            }
        }
        clickOnElement(this.calendarDoneButton);
    }

    /**
     *
     * @return DepartingFlightPage object
     */

    public DepartingFlightPage clickOnSearchButton(){
        clickOnElement(this.searchButton);
        return new DepartingFlightPage(getDriver());
    }

}
