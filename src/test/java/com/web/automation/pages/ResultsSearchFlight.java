package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.regex.Pattern;

import java.util.*;

/**
 * Class for interact with the result flights page.
 * @author norma.losada
 */

public class ResultsSearchFlight extends BasePage{

    @FindBy(css = "select[data-test-id=\"sortDropdown\"]")
    private WebElement sortFlightsResultBox;

    @FindBy(css = "option[data-test-id=\"sortDropdown-option\"][value=\"DURATION_INCREASING\"]")
    private WebElement sortByShortestDurationOption;

    @FindBy(css = "li[data-test-id=\"offer-listing\"] button")
    private List<WebElement> flightsResultSelectButton;

    @FindBy(css = "span[data-stid]")
    private List<WebElement> flightPriceList;

    @FindBy(css = "div[data-test-id=\"journey-duration\"]")
    private List<WebElement> journeyDurationList;

    @FindBy(css = "div[data-test-id=\"arrival-departure\"]")
    private List<WebElement> departureAndDestinationList;

    @FindBy(css = "div[data-test-id=\"airline-logo-queued\"]")
    private List<WebElement> airlineIconList;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "div[data-test-id=\"intersection-observer\"]")
    private List<WebElement> flightsOfferingsList;

    @FindBy(css = "span[data-test-id=\"departure-time\"]")
    private List<WebElement> estimatedDepartureAndArrivalTimeSelectedFlight;

    @FindBy(css = "div[data-test-id=\"flight-summary\"] h3>span")
    private WebElement estimatedDepartureAndArrivalTimeSideBar;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultsSearchFlight(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if Sort by box is displayed in the page
     * @return boolean
     */
    public boolean isTheSortBoxFlightsDisplayed(){
        try {
            Thread.sleep(3000);
            waitElementVisibility(this.sortFlightsResultBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.sortFlightsResultBox.isDisplayed();
    }

    /**
     * Verify if flight price is displayed in every result
     * @return boolean
     */
    public boolean isTheFlightPriceDisplayed() {
        waitElementsVisibility(flightsOfferingsList);
        int flightList = flightPriceList.size();
        boolean isPresent = false;
        int count = 0;
        for (int i = 0; i < flightList; i++) {
                waitElementsVisibility(flightsOfferingsList);
                waitElementVisibility(this.flightPriceList.get(i));
                count++;
            } if (count == flightList) {
                isPresent = true;
            }else{
            isPresent = false;
        }
        return isPresent;
    }

    /**
     * Verify if flight duration is displayed in every result
     * @return boolean
     */
    public boolean isTheFlightDurationDisplayed() {
        waitElementsVisibility(flightsOfferingsList);
        int flightList = journeyDurationList.size();
        boolean isPresent = false;
        int count = 0;
        for (int i = 0; i < flightList; i++) {
            waitElementVisibility(this.journeyDurationList.get(i));
            count++;
        } if (count == flightList) {
            isPresent = true;
        }else{
            isPresent = false;
        }
        return isPresent;
    }

    /**
     * Verify if flight airline and route is displayed in every result
     * @return boolean
     */
    public boolean isTheAirlineAndRouteDisplayed() {
        waitElementsVisibility(flightsOfferingsList);
        int flightList = departureAndDestinationList.size();
        boolean isPresent = false;
        int count = 0;
        for (int i = 0; i < flightList; i++) {
            waitElementVisibility(this.departureAndDestinationList.get(i));
            waitElementVisibility(this.airlineIconList.get(i));
            WebElement departure = departureAndDestinationList.get(i);
            WebElement airline = airlineIconList.get(i);
            if(departure.isDisplayed() && airline.isDisplayed()){
                count++;
            }
        } if (count == flightList) {
            isPresent = true;
        }else{
            isPresent = false;
        }
        return isPresent;
    }

    /**
     * Click on Duration(Shortest) option in Sort By dropdown
     */
    public void clickOnShortestDurationSortBy(){
         waitElementVisibility(sortByShortestDurationOption);
            clickOnElement(sortByShortestDurationOption);
            waitElementsVisibility(flightsOfferingsList);
    }

    /**
     *Verify if the list of flights is sorted by shortest duration correctly
     *@return boolean
     */
  public boolean verifyFlightListWasSortedByShortestDuration() {
      waitElementsVisibility(flightsOfferingsList);
      int flightList = flightsResultSelectButton.size();
      for (int i = 0; i < flightList -1; i++) {
          Integer previous = splitDurationText(journeyDurationList.get(i).getText());
          Integer next = splitDurationText(journeyDurationList.get(i+1).getText());
          if (previous <= next){
          } else {
              return false;
          }
      }
     return true;
  }

    /**
     * Method to split the journeyDuration text and get the time in minutes
     * @param journey, String
     * @return boolean
     */
  public Integer splitDurationText(String journey){
          String[] output = journey.split("\\(");
          String duration = output[0];
          String[] time = duration.split(" ");
          String hour = "";
          String minutes = "";
      if(time.length <= 1){
              minutes = time[0].replace("m", "");
          return Integer.parseInt(minutes) ;
          }else {
              hour =  time[0].replace("h", "");
              minutes = time[1].replace("m", "");
          return Integer.parseInt(hour) * 60 + Integer.parseInt(minutes) ;
          }
  }

    /**
     * Click on first option from flights list departure to Los Angeles
     */
    public void clickOnFirstFlightOption(){
        int firstIndex = 0;
        waitElementsVisibility(flightsOfferingsList);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(flightsOfferingsList.get(firstIndex));
        waitElementVisibility(flightsOfferingsList.get(firstIndex));
        actions.perform();
        explicitWait(flightsOfferingsList.get(firstIndex), 20);
        clickOnElement(flightsOfferingsList.get(firstIndex));
    }

    /**
     *Verify if the Departure and Arrival time from selected flight match with the side panel
     * @param index, int
     *@return boolean
     */
    public boolean verifyDepartureAndArrivalTimeMatch(int index) {
        waitElementsVisibility(estimatedDepartureAndArrivalTimeSelectedFlight);
        waitElementVisibility(estimatedDepartureAndArrivalTimeSideBar);
        String deparAndArriTimeSelectedFlightText = estimatedDepartureAndArrivalTimeSelectedFlight.get(index).getText();
        String deparAndArriTimeSideBarText = estimatedDepartureAndArrivalTimeSideBar.getText();
        return deparAndArriTimeSelectedFlightText.equals(deparAndArriTimeSideBarText);
    }

    /**
     * Click on Continue button
     * @return ChooseReturningFlightPage
     */
    public ChooseReturningFlightPage clickOnContinueButton(){
        waitElementVisibility(continueButton);
        clickOnElement(continueButton);
        return new ChooseReturningFlightPage(getDriver());
    }
}
