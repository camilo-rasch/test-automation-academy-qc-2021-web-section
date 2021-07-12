package com.web.automation.pages;

import com.web.automation.pojo.Flight;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"roundtrip\"]")
    private WebElement roundTripButton;

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

    public void clickOnFlightButton(){
        clickOnElement(flightsButton);
    }

    public void clickONRoundTripButton(){
        clickOnElement(roundTripButton);
    }

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

    public void pickOnDateOfDepartingCalendar(){
        clickOnElement(this.departingCalendarButton);
        clickOnElement(this.forwardMonthButton);
        for (WebElement element : this.calendarDaysList) {
            if (element.getAttribute("data-day").contains("31")) {
                clickOnElement(element);
            }
        }
        clickOnElement(this.calendarDoneButton);
    }

    /*public void pickOnDateOfDestinationCalendar(){
        clickOnElement(this.returningCalendarButton);
        for (WebElement element : this.calendarDaysList) {
            if (element.getAttribute("data-day").contains("29")) {
                clickOnElement(element);
            }
        }
        clickOnElement(this.calendarDoneButton);
    }*/

    public DepartingFlightPage clickOnSearchButton(){
        clickOnElement(this.searchButton);
        return new DepartingFlightPage(getDriver());
    }

}
