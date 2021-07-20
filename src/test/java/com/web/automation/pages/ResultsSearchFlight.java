package com.web.automation.pages;

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

public class ResultsSearchFlight extends BasePage{

    /**
     * locators
     */
    @FindBy(css = "div[data-test-id=\"intersection-observer\"]")
    private List<WebElement> flightsOfferingsList;
    private String flightsOfferingsListSelector = "div[data-test-id=\"intersection-observer\"]";

    @FindBy(css = "select#listings-sort")
    private WebElement sortDropdown;

    @FindBy(css = "div[data-test-id=\"flight-summary\"] h3>span")
    private WebElement flightSummaryDepartureTime;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    //Hotel search Pop UP selectors
    @FindBy(css = "a[data-test-id='forcedChoiceNoThanks']")
    private WebElement noThanksLink;

    private String airlineInfoSelector = "div[data-test-id='airline-info']";
    private String departureTimeSelector = "span[data-test-id='departure-time']";
    private String priceInfoSelector = "span.uitk-lockup-price";
    private String durationInfoSelector = "div[data-test-id=\"journey-duration\"]";
    private String routeInfoSelector = "div [data-test-id=\"arrival-departure\"]";
    private String flightTime = "";
    private String flightPriceText;
    private String flightDurationText;
    private String flightAirlineText;
    private String flightRouteText;
    private String searchFlightsPageHandle ="";






    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultsSearchFlight(WebDriver pDriver) {
        super(pDriver);

    }

    public boolean sortDropdownIsDisplayed(){
        waitElementVisibility(this.sortDropdown);
        return this.sortDropdown.isDisplayed();
    }

    /**
     * Scroll the dropdown options list to get the text value
     * @return sortOptions
     */
    public List<WebElement> optionsToSortDropdown(){
        Select dropdownOptions = new Select(getDriver().findElement(By.cssSelector("select#listings-sort")));
        List<WebElement> sortOptions = dropdownOptions.getOptions();
        for (WebElement sortOption : sortOptions) {
            log.info(sortOption.getText());
        }
        return sortOptions;
    }


    /**
     * Get the flight prices on every result of the list
     * @return prices
     */
    public boolean flightPriceIsPresentOnEveryResult(){
        int id = 1;
        //getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));
        getWait().until(ExpectedConditions.visibilityOfAllElements(this.flightsOfferingsList));
        List<WebElement> offeringsList = this.flightsOfferingsList;
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
     * Get the flight duration on every result of the list
     * @return prices
     */
    public boolean flightDurationIsPresentOnEveryResult(){
        int id = 1;
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));
        List<WebElement> offeringsList = this.flightsOfferingsList;
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
     * Get the flight duration on every result of the list
     * @return prices
     */
    public boolean airlineAndRouteArePresentOnEveryResult(){
        int id = 1;
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));
        List<WebElement> offeringsList = this.flightsOfferingsList;
        for (int i = 0; i < offeringsList.size(); i++) {
            WebElement flight = offeringsList.get(i);
            this.flightAirlineText = flight.findElement(By.cssSelector(this.airlineInfoSelector)).getText();
            this.flightRouteText = flight.findElement(By.cssSelector(this.routeInfoSelector)).getText();
            this.flightTime = flight.findElement(By.cssSelector(this.departureTimeSelector)).getText();
            log.info("Flight " + id + ". " + this.flightTime + " - " +
                    "Airline: " + this.flightAirlineText + "Origin-Destination: " + this.flightRouteText);
            id = id + 1;
            if (flightAirlineText.equals("") || flightRouteText.equals("")) {
                return false;
            }
        }
        return true;
    }

    

    public void selectAFlightByAirline(String airlineToSelect){

        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));

        for(WebElement flight: this.flightsOfferingsList){
            WebElement airline = flight.findElement(By.cssSelector(this.airlineInfoSelector));
            String airlineText = airline.getText();
            if(airlineText.contains(airlineToSelect)){
                this.flightTime = flight.findElement(By.cssSelector(this.departureTimeSelector)).getText();
                flight.click();
                break; //MALA PRACTICA USAR WHILE
            }
        }
    }

    public void selectAFlightByAirlineLambda(String airlineToSelect){
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));

        WebElement flightResult = this.flightsOfferingsList.stream().filter(
                flight -> flight.getText().contains(airlineToSelect)).findFirst().orElse(null);

        if(flightResult != null){
            this.flightTime = flightResult.findElement(By.cssSelector(this.departureTimeSelector)).getText();
            log.info("Departure time from selected flight to store: " + this.flightTime);
            flightResult.click();
        }


    }
    public boolean departureTimeMatchesFromSelectedFlight(){
        waitElementVisibility(this.flightSummaryDepartureTime);
        String confirmationFlightTime = this.flightSummaryDepartureTime.getText();
        log.info("Departure time from element: " + confirmationFlightTime);
        return confirmationFlightTime.equalsIgnoreCase(this.flightTime);
    }

    public void clickOnContinueButton(){
        this.searchFlightsPageHandle = getDriver().getWindowHandle();
        clickOnElement(this.continueButton);
    }

    public FlightConfirmationPage clickOnNoThanksLink(){
        clickOnElement(this.noThanksLink);

        Set<String> windowsHandlesAfterClick = getDriver().getWindowHandles();
        Iterator<String> iterator2 = windowsHandlesAfterClick.iterator();

        while(iterator2.hasNext()){
            String childWindow = iterator2.next();
            if(!this.searchFlightsPageHandle.equals(childWindow)){
                getDriver().switchTo().window(childWindow);
            }
        }
        return new FlightConfirmationPage(getDriver());
    }
}
