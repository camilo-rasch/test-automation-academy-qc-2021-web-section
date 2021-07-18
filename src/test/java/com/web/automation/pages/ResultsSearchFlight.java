package com.web.automation.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ResultsSearchFlight extends BasePage {

	@FindBy(css = "div[data-test-id=\"intersection-observer\"]")
	private List<WebElement> flightsOfferingsList;
	private String flightsOfferingsListSelector = "div[data-test-id=\"intersection-observer\"]";
	
	@FindBy(css = "div[data-test-id=\"price-column\"]")
	private List<WebElement> flightPrice;
	
	@FindBy(css = "div[data-test-id=\"journey-duration\"]")
	private List<WebElement> flightDuration;
	
	@FindBy(css = "div[data-test-id=\"airline-info\"]")
	private List<WebElement> flightAirLineInfo;
	
	@FindBy(css = "div[data-test-id=\"arrival-departure\"]")
	private List<WebElement> flightRoute;
	
	@FindBy(css = "div[data-test-id=\"arrival-time\"]")
	private List<WebElement> flightArrivalTime;
	
	@FindBy(css = "div[data-test-id=\"flight-summary\"] h3>span")
    private WebElement flightSummaryDepartureTime;
	
	@FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;
	
	@FindBy(css = "a[data-test-id='forcedChoiceNoThanks']")
    private WebElement noThanksLink;
	
	private String sortBySelector = "listings-sort";
    Select sortDropDownSelector; 
	
	private String searchFlightsPageHandle ="";
	private String flightEstimatedTime = "";
	
	/**
	 * Constructor Page
	 * @param pDriver
	 */
	public ResultsSearchFlight(WebDriver pDriver) {
		super(pDriver);		
	}
	
	/**
	 * Select shorter duration option by Index
	 * @param index
	 */
	public void selectOptionShorterDurationByIndex(int index){
		this.sortDropDownSelector = new Select(getDriver().findElement(By.id(this.sortBySelector)));
        this.sortDropDownSelector.selectByIndex(index);
        log.info("Selected option: " + this.sortDropDownSelector.getFirstSelectedOption().getText());
    }
	
	 /**
	  * Verify if Flight list result information is present
	  * @return
	  */
	public boolean isFlightListInformationPresent() {		
		getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));
		boolean exist = true;
		for (int i=0 ; i < flightsOfferingsList.size(); i++) {			
			if (!this.flightsOfferingsList.get(i).isDisplayed()) {
				exist = false;
			}		
		}
		return exist;
	}
	
	/**
	 * Verify if Flight Air Line information is present for every result
	 * @return
	 */
	public boolean isFlightAirLineInfoPresent() {
		boolean exist = true;	
		for (int i=0 ; i < flightAirLineInfo.size(); i++) {
			if (!this.flightAirLineInfo.get(i).isDisplayed()){
				exist = false;
			}
		}
		return exist;
	}
	
	/**
	 * Verify is flight duration is present for every result
	 * @return
	 */
	public boolean isFlightDurationInfoPresent() {
		boolean exist = true;
		for (int i=0 ; i < flightDuration.size(); i++) {
			if (!this.flightDuration.get(i).isDisplayed()) {
				exist = false;
			}								
		}
		return exist;
	}
	
	/**
	 * Verify is Flight price information is present for every result
	 * @return
	 */
	public boolean isFlightPriceInfoPresent() {
		boolean exist = true;
		for (int i=0 ; i < flightPrice.size(); i++) {					
				if(!this.flightPrice.get(i).isDisplayed()) {
					exist = false;
				}
			}
		return exist;
	}
	
	/**
	 * Verify if Flight route information is present for every result
	 * @return
	 */
    public boolean isFlightRouteInfoPresent() {
		boolean exist = true;
		for (int i=0 ; i < flightPrice.size(); i++) {
			if(!this.flightRoute.get(i).isDisplayed()) {
				exist = false;
			}							
		}
		return exist;
	}
    
    /**
     * Select departure result by index
     * @param result
     */
    public void selectDepartureFlight(int result) {
    	
    	getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));

    	WebElement departureFlight = flightsOfferingsList.get(result);
    	this.flightEstimatedTime = flightArrivalTime.get(result).getText();
    	departureFlight.click();        
    }
    
    /**
     * Verify is departure time sidebar matches with selected flight
     * @return
     */
    public boolean departureTimeMatchesFromSelectedFlight(){
        waitElementVisibility(this.flightSummaryDepartureTime);
        String confirmationFlightTime = this.flightSummaryDepartureTime.getText();
        log.info("Departure time from element: " + confirmationFlightTime);
        return confirmationFlightTime.equalsIgnoreCase(this.flightEstimatedTime);
    }
    
    /**
     * Verify if continue button is present on page
     * @return
     */
    public boolean isContinueButtonPresent() {
    	this.searchFlightsPageHandle = getDriver().getWindowHandle();
    	return continueButton.isDisplayed();
    }
	
    /**
     * Click on Continue button
     */
    public void clickOnContinueButton(){
        this.searchFlightsPageHandle = getDriver().getWindowHandle();
        clickOnElement(this.continueButton);
    }
    
    /**
     * Select departure or arrival flight by index for booking process
     * @param departureArrival
     */
    public void selectDepartureArrivalFlight(int departureArrival) {
    	log.info("Select a departure flight result");
        selectDepartureFlight(departureArrival);
        log.info("is continue button present?");
        isContinueButtonPresent();
        log.info("Click on continue button");
        clickOnContinueButton();
    }
    
    /**
     * Click on "No thanks" link pop up
     * @return
     */
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
    
    /**
     * Verify order flight list by shorter duration
     * @return
     */
    public boolean orderListShorterDuration() {
    	waitElementsVisibility(flightsOfferingsList);
    	int minutes = 0;
    	boolean shorter = true;
    	for(int i=0; i<this.flightDuration.size(); i++) {
    		String flightDuration = this.flightDuration.get(i).getText();
    		int temporalMinutes = getDurationInMinutes(flightDuration);
    		if(minutes <= temporalMinutes) {
    			minutes = temporalMinutes;    			
    		}else {
    			shorter = false;
    		}    		   		
    	}
    	return shorter;
    }
    
    /**
     * Get flight duration time in minutes
     * @param flightDuration
     * @return
     */
    public int getDurationInMinutes(String flightDuration) {
    	int minutes = 0;
    	String[] fDurationSplit = flightDuration.split(" ");
    	for(int i=0; i<fDurationSplit.length; i++) {
    		String durationPosition = fDurationSplit[i];
    		if(durationPosition.endsWith("h")) {
    			String hour = durationPosition.substring(0, durationPosition.length() - 1);
    			minutes = minutes + (Integer.parseInt(hour)*60);
    		}
    		if(durationPosition.endsWith("m")) {
    			String minute = durationPosition.substring(0, durationPosition.length() - 1);
    			minutes = minutes + Integer.parseInt(minute);
    		}
    	}
    	return minutes;
    }
}
