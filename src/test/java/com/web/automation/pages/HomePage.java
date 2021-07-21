package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"round\"]")
    private WebElement roundtripButton;

    @FindBy(css = "a[data-testid=\"travelers-field\"")
    private WebElement travelersSelector;

    @FindBy(css = "div[class*=\"adult\"] div button svg[aria-labelledby*='increase-adult']")
    private WebElement increaseAdultsTravelersButton;

    @FindBy(css = "div[class*=\"adult\"] input")
    private WebElement adultsTravelersSelectedLabel;

    @FindBy(css = "div[class*=\"adult\"] label")
    private WebElement adultsTextLabel;

    @FindBy(css = "button[data-testid=\"guests-done-button\"")
    private WebElement travelersDoneButton;

    @FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-origin-result-item\"]")
    private List<WebElement> depaturesResultsList;

    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-destination-result-item\"]")
    private List<WebElement> destinationResultsList;

    @FindBy(id = "d1-btn")
    private WebElement calendarButton;

    @FindBy(css = "div[class*=\"pagination\"] button:nth-child(2)")
    private WebElement nextMonthButton;

    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    protected WebElement submitButton;

    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    @FindBy(css = "div[data-testid='location-field-leg1-origin-container']")
    private WebElement inputDepatureWrapper;

    @FindBy(css = "div[data-testid='location-field-leg1-destination-container']")
    private WebElement inputDestinationWrapper;

    @FindBy(css = "a.header-logo")
    private WebElement homeLogo;

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
     * Search the locations for the roundtrip flight
     * @param origin origin
     * @param destination destination
     * @return
     */
    public void selectOriginDestinationAndTravelers(String origin, String destination, int travelers){
        clickOnElement(this.flightsButton);
        clickOnElement(this.roundtripButton);


        waitElementVisibility(this.inputDepatureWrapper);
        clickOnElement(this.inputDepatureWrapper);
        this.departureInput.click();
        this.departureInput.sendKeys(origin);
        for(WebElement element: this.depaturesResultsList){
            if(element.getText().contains(origin)){
                element.click();
                log.info("Origin: " + this.departureInput.getAttribute("value"));
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
                log.info("Destination: " + this.destinationInput.getAttribute("value"));
            }
        }
        this.addAdultTravelers(travelers);
    }

    /**
     * Select the number of travelers (adults, children or infants
     */
    public void addAdultTravelers(int travelers){
        clickOnElement(this.travelersSelector);
        for (int i = 0; i < (travelers-1); i++) {
            clickOnElement(this.increaseAdultsTravelersButton);
        }
        clickOnElement(this.travelersDoneButton);
    }

    /**
     * Confirm the number of travelers
     * @return adultsSelected String
     */
    public String confirmTravelersSelected(){
        waitElementVisibility(this.travelersSelector);
        clickOnElement(this.travelersSelector);
        String numberOfTravelersSelected = adultsTravelersSelectedLabel.getAttribute("value");
        String typeOfTravelerSelected = this.adultsTextLabel.getText();
        log.info("You have selected: " + numberOfTravelersSelected + " " +typeOfTravelerSelected + " travelers");
        clickOnElement(this.travelersDoneButton);
        return (numberOfTravelersSelected + " " + typeOfTravelerSelected + " travelers selected");
    }


    /**
     * Search a roundtrip flight
     * @param monthsToSelect int
     * @param daysForReturn int
     * @return driver
     */
    public ResultsSearchFlight searchFlight(int monthsToSelect, int daysForReturn){
        clickOnElement(this.calendarButton);
        int daysCalendarSize = this.calendarDayLists.size();
        int count = 0;
        boolean selectedDayFlag = false;

        while (count < daysCalendarSize-1 && !selectedDayFlag){
            if(this.calendarDayLists.get(count).getAttribute("class").contains(this.focusDayCalendar)){
                for (int i = 0; i < monthsToSelect; i++) {
                    this.nextMonthButton.click();
                }
                clickOnElement(calendarDayLists.get(count));
                clickOnElement(calendarDayLists.get(count+daysForReturn));
                log.info("The departing date is: " + this.calendarDayLists.get(count).getAttribute("aria-label"));
                log.info("The returning date is: " + this.calendarDayLists.get(count+daysForReturn).getAttribute("aria-label"));
                selectedDayFlag = true;
            }
            count++;

        }
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);

        return new ResultsSearchFlight(getDriver());
    }

    public ResultsSearchFlight reloadSearch(String origin, String destination, int travelers, int monthsToSelect, int daysForReturn){
        homeLogo.click();
        if(this.departureInput.getText() == null || destinationInput.getText() == null){
            selectOriginDestinationAndTravelers(origin, destination, travelers);
            searchFlight(monthsToSelect, daysForReturn);
        }
        clickOnElement(submitButton);
        return new ResultsSearchFlight(getDriver());
    }
}
