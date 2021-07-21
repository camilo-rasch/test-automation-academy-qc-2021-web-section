package com.web.automation.pages;

import org.apache.commons.exec.util.StringUtils;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.openqa.selenium.support.ui.Select;

public class ResultsSearchFlight extends BasePage {

    /**
     * locators
     */
    @FindBy(css = "div[data-test-id=\"intersection-observer\"]")
    private List<WebElement> flightsOfferingsList;
    private String flightsOfferingsListSelector = "div[data-test-id=\"intersection-observer\"]";

    @FindBy(css = "select#listings-sort")
    private WebElement sortDropdown;
    private String filterDropdown = "listings-sort";

    @FindBy(css = "div[data-test-id=\"flight-summary\"] h3>span")
    private WebElement flightSummaryDepartureTime;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "a [class=\"uitk-text uitk-type-200\"]")
    private WebElement changeFlightLink;

    //Hotel search Pop UP selectors
    @FindBy(css = "a[data-test-id='forcedChoiceNoThanks']")
    private WebElement noThanksLink;

    @FindBy(css = "div[data-test-id=\"includes-flight-message\"]")
    private WebElement searchForCarsCardPopup;

    /**
     * String locators
     */
    private String airlineInfoSelector = "div[data-test-id='flight-operated']";
    private String departureTimeSelector = "span[data-test-id='departure-time']";
    private String priceInfoSelector = "span.uitk-lockup-price";
    private String durationInfoSelector = "div[data-test-id=\"journey-duration\"]";
    private String routeInfoSelector = "div [data-test-id=\"arrival-departure\"]";
    private String flightTime = "";
    private String flightPriceText = "";
    private String flightDurationText = "";
    private String flightAirlineText = "";
    private String flightRouteText = "";
    private String searchFlightsPageHandle = "";

    /**
     * Declare the attribute as Select to instantiate the dropdown
     */
    Select dropdownOptions;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultsSearchFlight(WebDriver pDriver) {
        super(pDriver);
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("select#listings-sort")));
        this.dropdownOptions = new Select(getDriver().findElement(By.id(this.filterDropdown)));
    }

    /**
     * Verify a dropdown to sort the flights is displayed
     * @return boolean
     */
    public boolean sortDropdownIsDisplayed() {
        waitElementVisibility(this.sortDropdown);
        return this.sortDropdown.isDisplayed();
    }

    /**
     * Scroll the dropdown options list to get the text value
     * @return sortOptions
     */
    public List<WebElement> optionsToSortDropdown() {
        List<WebElement> sortOptions = dropdownOptions.getOptions();
        for (WebElement sortOption : sortOptions) {
            log.info(sortOption.getText());
        }
        return sortOptions;
    }


    /**
     * Get the flight prices on every flight of the list
     * @return boolean
     */
    public boolean flightPriceIsPresentOnEveryResult() {
        int id = 1;
        waitElementsVisibility(this.flightsOfferingsList);
        List<WebElement> offeringsList = this.flightsOfferingsList;
        log.info("Total of results on screen: " + offeringsList.size());
        for (int i = 0; i < offeringsList.size(); i++) {
            WebElement flight = offeringsList.get(i);
            this.flightPriceText = flight.findElement(By.cssSelector(this.priceInfoSelector)).getText();
            this.flightTime = flight.findElement(By.cssSelector(this.departureTimeSelector)).getText();
            log.info("Flight " + id + ". " + this.flightTime + ": " + this.flightPriceText);
            id = id + 1;
            if (flightPriceText.equals("")) {
                return false;
            }
        }
        return true;
    }


    /**
     * Get the flight duration on every flight of the list
     * @return boolean
     */
    public boolean flightDurationIsPresentOnEveryResult() {
        int id = 1;
        waitElementsVisibility(this.flightsOfferingsList);
        List<WebElement> offeringsList = this.flightsOfferingsList;
        log.info("Total of results on screen: " + offeringsList.size());
        for (int i = 0; i < offeringsList.size(); i++) {
            WebElement flight = offeringsList.get(i);
            this.flightDurationText = flight.findElement(By.cssSelector(this.durationInfoSelector)).getText();
            this.flightTime = flight.findElement(By.cssSelector(this.departureTimeSelector)).getText();
            log.info("Flight " + id + ". " + this.flightTime + ": " + this.flightDurationText);
            id = id + 1;
            if (flightDurationText.equals("")) {
                return false;
            }
        }
        return true;
    }


    /**
     * Get the airline and route on every flight of the list
     * @return boolean
     */
    public boolean airlineAndRouteArePresentOnEveryResult() {
        int id = 1;
        waitElementsVisibility(this.flightsOfferingsList);
        List<WebElement> offeringsList = this.flightsOfferingsList;
        log.info("Total of results on screen: " + offeringsList.size());
        for (int i = 0; i < offeringsList.size(); i++) {
            WebElement flight = offeringsList.get(i);
            this.flightAirlineText = flight.findElement(By.cssSelector(this.airlineInfoSelector)).getText();
            this.flightRouteText = flight.findElement(By.cssSelector(this.routeInfoSelector)).getText();
            this.flightTime = flight.findElement(By.cssSelector(this.departureTimeSelector)).getText();
            log.info("Flight " + id + ". " + this.flightTime + " - " +
                    "Airline: " + this.flightAirlineText + "; \nOrigin-Destination: " + this.flightRouteText);
            id = id + 1;
            if (flightAirlineText.equals("") || flightRouteText.equals("")) {
                return false;
            }
        }
        return true;
    }


    /**
     * Verify the flight’s result list was correctly sorted
     * @return boolean
     */
    public boolean flightResultsListIsSortedByDurationShortest(int index) {
        this.dropdownOptions.selectByIndex(index);
        log.info("The flights list is sorted by: " + dropdownOptions.getFirstSelectedOption().getText());
        int id = 1;
        waitElementsVisibility(this.flightsOfferingsList);
        List<WebElement> offeringsList = this.flightsOfferingsList;
        int previousTotalTimeDuration = 0;
        log.info("Total of results on screen: " + offeringsList.size());
        for (int i = 0; i < offeringsList.size(); i++) {
            WebElement flight = offeringsList.get(i);
            this.flightDurationText = flight.findElement(By.cssSelector(this.durationInfoSelector)).getText();
            String splitDuration[] = StringUtils.split(flightDurationText, " ");
            String hoursText = splitDuration[0].replaceAll("[^\\d]", "");
            int hoursVal = Integer.parseInt(hoursText) * 60;
            String minutesText = splitDuration[1].replaceAll("[^\\d]", "");
            int minutesVal = Integer.parseInt(minutesText);
            int totalTimeDuration = hoursVal + minutesVal;
            this.flightTime = flight.findElement(By.cssSelector(this.departureTimeSelector)).getText();
            log.info("Flight " + id + ". " + this.flightTime + " - Duration: " + totalTimeDuration + " minutes");
            id = id + 1;
            if (totalTimeDuration < previousTotalTimeDuration) {
                return false;
            }
            previousTotalTimeDuration = totalTimeDuration;
        }
        return true;
    }


    /**
     * Select a flight from the offering list
     * @param index int
     * @return boolean
     */
    public boolean selectAFlightByIndex(int index) {
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));
        List<WebElement> offeringsList = this.flightsOfferingsList;
        int id = 1;
        log.info("Total of results on screen: " + offeringsList.size());
        for (int i = 0; i <= offeringsList.size() - 1; i++) {
            if (index == i) {
                WebElement flight = offeringsList.get(i);
                this.flightTime = flight.findElement(By.cssSelector(this.departureTimeSelector)).getText();
                log.info("Selected flight: Flight " + id + ". " + this.flightTime);
                clickOnElement(flight);
                return true;
            }
            id = id + 1;
        }
        return false;
    }


    /**
     * The flight time is equal in the offering list and in the summary displayed when is selected
     * @return boolean
     */
    public boolean departureTimeMatchesFromSelectedFlight(){
        waitElementVisibility(this.flightSummaryDepartureTime);
        String confirmationFlightTime = this.flightSummaryDepartureTime.getText();
        log.info("Departure time from sidebar flight review: " + confirmationFlightTime);
        return confirmationFlightTime.equalsIgnoreCase(this.flightTime);
    }


    /**
     * A "Change flight" link to change the departure flight is displayed after select it
     * @return boolean
     */
    public boolean selectedDepartureFlightIsDisplayed(){
        waitElementVisibility(this.changeFlightLink);
        return this.changeFlightLink.isDisplayed();
    }


    /**
     * A "Search for cars" offer popup is displayed after select the returning flight
     * @return boolean
     */
    public boolean selectedReturningFlightIsDisplayed(){
        waitElementVisibility(this.searchForCarsCardPopup);
        return this.searchForCarsCardPopup.isDisplayed();
    }


    /**
     * click on Continue Button to confirm the selected flight
     */
    public void clickOnContinueButton () {
        this.searchFlightsPageHandle = getDriver().getWindowHandle();
        clickOnElement(this.continueButton);
    }


    /**
     * Method to click on "No, thanks" button in the popup card
     * @return driver
     */
    public FlightConfirmationPage clickOnNoThanksLink () {
        clickOnElement(this.noThanksLink);
        Set<String> windowsHandlesAfterClick = getDriver().getWindowHandles();
        Iterator<String> iterator2 = windowsHandlesAfterClick.iterator();

        while (iterator2.hasNext()) {
        String childWindow = iterator2.next();
            if (!this.searchFlightsPageHandle.equals(childWindow)) {
            getDriver().switchTo().window(childWindow);
            }
        }
        return new FlightConfirmationPage(getDriver());
    }
}

