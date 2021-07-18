package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {
	
	@FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;
	
	@FindBy(css = "#uitk-tabs-button-container a[href*=\"round\"]")
	private WebElement roundtripButton;
	
	@FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-origin-result-item\"]")
    private List<WebElement> depaturesResultsList;

    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-destination-result-item\"]")
    private List<WebElement> destinationResultsList;
    
    @FindBy(css = "[data-testid = \"travelers-field\"]")
    private WebElement travelersLink;
    
    @FindBy(css = "div[data-testid = \"room-1\"] div:nth-child(2) > button:nth-child(3)")
    private WebElement addTraveler;
     
    @FindBy(id = "adult-input-0")
    private WebElement travelerQuantity;
    
    @FindBy(css = "button[data-testid = \"guests-done-button\"]")
    private WebElement doneTravelersButton;

    @FindBy(id = "d1-btn")
    private WebElement calendarButton;
    
    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;
    
    @FindBy(css = "button[data-stid = \"date-picker-paging\"]:nth-child(2)")
    private WebElement calendarNextMonth;
    
    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    @FindBy(css = "div[data-testid='location-field-leg1-origin-container']")
    private WebElement inputDepatureWrapper;

    @FindBy(css = "div[data-testid='location-field-leg1-destination-container']")
    private WebElement inputDestinationWrapper;
    
    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement submitButton;
    
    @FindBy(css = "a[href=\"/\"]")
    private WebElement travelocityHeaderButton;
    
    private String focusDayCalendar = "edge";
    

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
     * Search a flight in Travelocity
     * @param origin
     * @param destination
     * @param daysFromToday
     * @param stayDays
     * @return
     */
    public ResultsSearchFlight searchFlight(String origin, String destination, int daysFromToday, int stayDays){
        clickOnElement(this.flightsButton);
        clickOnElement(this.roundtripButton);
        
        waitElementVisibility(travelersLink);
        clickOnElement(travelersLink);
        travelerQuantity();
        //waitElementVisibility(addTraveler);
        //clickOnElement(addTraveler);
        clickOnElement(doneTravelersButton);

        waitElementVisibility(this.inputDepatureWrapper);
        clickOnElement(this.inputDepatureWrapper);
        clickOnElement(departureInput);
        cleanInputFields(departureInput);
        this.departureInput.sendKeys(origin);
        for(WebElement element: this.depaturesResultsList){
           if(element.getText().contains(origin)){
               element.click();
           }
        }

        waitElementVisibility(this.inputDestinationWrapper);
        clickOnElement(this.inputDestinationWrapper);
        clickOnElement(this.destinationInput);
        cleanInputFields(destinationInput);
        this.destinationInput.sendKeys(destination);
        for(WebElement element: this.destinationResultsList){
            String elementText = element.getText();
            if(elementText.contains(destination)){
                element.click();
            }
        }

        clickOnElement(this.calendarButton);
        int daysCalendarSize = this.calendarDayLists.size();
        int daysUntilReturn = daysFromToday+stayDays;
        
        if(daysCalendarSize <= daysFromToday) {
        	clickOnElement(calendarNextMonth); 
        	this.calendarDayLists.get(daysFromToday).click();
        }else {
        	this.calendarDayLists.get(daysFromToday).click();
        }
        daysCalendarSize = this.calendarDayLists.size();
        if(daysCalendarSize <= daysUntilReturn) {
        	clickOnElement(calendarNextMonth); 
        	this.calendarDayLists.get(daysUntilReturn).click();
        }else {
        	this.calendarDayLists.get(daysUntilReturn).click();
        }
        this.calendarDayLists.get(daysUntilReturn).click();
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);  
        
        return new ResultsSearchFlight(getDriver());
    }
    
    public void travelerQuantity() {
    	String Quantity = travelerQuantity.getAttribute("value");
    	
    	if (Quantity.equalsIgnoreCase("1")) {
    		waitElementVisibility(addTraveler);
            clickOnElement(addTraveler);
    	}
    }
    
    public boolean isSearchButtonPresent() {
    	getWait().until(ExpectedConditions.elementToBeClickable(submitButton));
    	return submitButton.isDisplayed();
    }
    
    public void clickOnTravelocityHeaderHomePage() {
    	clickOnElement(travelocityHeaderButton);
    }
    
    /**
     * Give control to Flights Result Page
     * @return
     */
    public ResultsSearchFlight giveControlToResultPage() {
    	
        return new ResultsSearchFlight(getDriver());
    }
}
