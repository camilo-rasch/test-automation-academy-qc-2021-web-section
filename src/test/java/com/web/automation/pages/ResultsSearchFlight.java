package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ResultsSearchFlight extends BasePage{

    @FindBy(id = "stops-0")
    private WebElement nonStopCheckbox;

    @FindBy(id = "stops-1")
    private WebElement oneStopCheckbox;
    private String oneStopCheckboxSelector = "stops-1";

    @FindBy(css = "div[data-test-id=\"intersection-observer\"]")
    private List<WebElement> flightsOfferingsList;
    private String flightsOfferingsListSelector = "div[data-test-id=\"intersection-observer\"]";

    @FindBy(css = "div[data-test-id=\"flight-summary\"] h3>span")
    private WebElement flightSummaryDepartureTime;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    //Hotel search Pop UP selectors
    @FindBy(css = "a[data-test-id='forcedChoiceNoThanks']")
    private WebElement noThanksLink;

    @FindBy(id = "listings-sort")
    private WebElement sortBy;

    private String airlineInfoSelector = "div[data-test-id='airline-info']";
    private String departureTimeSelector = "span[data-test-id='departure-time']";
    private String flightTime = "";
    private String searchFlightsPageHandle ="";

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultsSearchFlight(WebDriver pDriver) {
        super(pDriver);
    }

    public void clickOnOneStopCheckBox(){
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(this.oneStopCheckboxSelector)));
        this.oneStopCheckbox.click();
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

    public boolean isSortByPresent(){
        waitElementVisibility(this.sortBy);
        return this.sortBy.isDisplayed();
    }
    Select myDropDown;
    public ResultsSearchFlight selectDropdownValue(String value) {
        this.myDropDown = new Select(getDriver().findElement(By.id("listings-sort")));
        this.myDropDown.selectByValue(value);
        return new ResultsSearchFlight(getDriver());

    }
}