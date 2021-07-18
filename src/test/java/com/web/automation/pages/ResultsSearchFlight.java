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
import org.testng.Assert;

public class ResultsSearchFlight extends BasePage {


	@FindBy (id = "listings-sort")
	private WebElement sortByDropDown;
	
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
	
	private String searchFlightsPageHandle ="";
	private String flightEstimatedTime = "";
	
	/**
	 * Constructor Page
	 * @param pDriver
	 */
	public ResultsSearchFlight(WebDriver pDriver) {
		super(pDriver);
	}
	
	public boolean isSortByDropDownPresent() {
		
		getWait().until(ExpectedConditions.visibilityOf(sortByDropDown));
		return true;
	}
	
	public void isSortByDropDownValuesPresent() {
		Select sortByDropDown = new Select(getDriver().findElement(By.id("listings-sort")));
	}
	
	public boolean isFlightListInformationPresent() {
		
		getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));
		
		for (int i=0 ; i < flightsOfferingsList.size(); i++) {			
			this.flightsOfferingsList.get(i).isDisplayed();				
		}
		return true;
	}
		
	public boolean isFlightAirLineInfoPresent() {
			
		for (int i=0 ; i < flightAirLineInfo.size(); i++) {
			this.flightAirLineInfo.get(i).isDisplayed();					
		}
		return true;
	}
			
	public boolean isFlightDurationInfoPresent() {
				
		for (int i=0 ; i < flightDuration.size(); i++) {					
			this.flightDuration.get(i).isDisplayed();					
		}
		return true;
	}
	
	public boolean isFlightPriceInfoPresent() {
		
		for (int i=0 ; i < flightPrice.size(); i++) {					
				this.flightPrice.get(i).isDisplayed();				
			}
		return true;
	}
	
    public boolean isFlightRouteInfoPresent() {
		
		for (int i=0 ; i < flightPrice.size(); i++) {					
				this.flightRoute.get(i).isDisplayed();			
		}
		return true;
	}
    
    public void selectDepartureFlight(int result) {
    	
    	getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(this.flightsOfferingsListSelector)));

    	WebElement departureFlight = flightsOfferingsList.get(result);
    	this.flightEstimatedTime = flightArrivalTime.get(result).getText();
    	departureFlight.click();        
    }
    
    public boolean departureTimeMatchesFromSelectedFlight(){
        waitElementVisibility(this.flightSummaryDepartureTime);
        String confirmationFlightTime = this.flightSummaryDepartureTime.getText();
        log.info("Departure time from element: " + confirmationFlightTime);
        return confirmationFlightTime.equalsIgnoreCase(this.flightEstimatedTime);
    }
    
    public boolean isContinueButtonPresent() {
    	this.searchFlightsPageHandle = getDriver().getWindowHandle();
    	return continueButton.isDisplayed();
    }
	
    public void clickOnContinueButton(){
        this.searchFlightsPageHandle = getDriver().getWindowHandle();
        clickOnElement(this.continueButton);
    }
    
    public void selectDepartureArrivalFlight(int departureArrival) {
    	log.info("Select a departure flight result");
        selectDepartureFlight(departureArrival);
        log.info("is continue button present?");
        isContinueButtonPresent();
        log.info("Click on continue button");
        clickOnContinueButton();
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
