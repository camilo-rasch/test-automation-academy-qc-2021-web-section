package com.web.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import static java.lang.Thread.sleep;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"roundtrip\"]")
    private WebElement roundTripButton;

    @FindBy(css = "[data-testid*='travelers']")
    private WebElement numberOfTravelers;

    @FindBy(css = "[aria-labelledby*='increase-adults']")
    private WebElement increaseAdultTraveler;

    @FindBy(css = "[data-testid*='done-button']")
    private WebElement doneButton;

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

    @FindBy(css = ".uitk-calendar>div>button~button")
    private WebElement nextMonth;


    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement submitButton;

    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    @FindBy(css = "div[data-testid='location-field-leg1-origin-container']")
    private WebElement inputDepatureWrapper;

    @FindBy(css = "div[data-testid='location-field-leg1-destination-container']")
    private WebElement inputDestinationWrapper;

    @FindBy(css = "[data-day='29'][aria-label='Oct 29, 2021']")
    private WebElement day;


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
     * Search a one way trip flight
     * @param origin origin
     * @param destination destination
     * @param daysFromToday days from today to choose
     * @return
     */
    public ResultsSearchFlight searchFlight(String origin, String destination, int daysFromToday) throws InterruptedException {
        clickOnElement(this.flightsButton);
        clickOnElement(this.roundTripButton);
        increaseTravelers();
        waitElementVisibility(this.inputDepatureWrapper);
        clickOnElement(this.inputDepatureWrapper);
        this.departureInput.click();
        this.departureInput.sendKeys(origin);
        for(WebElement element: this.depaturesResultsList){
            if(element.getText().contains(origin)){
                element.click();
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
            }
        }

        clickOnElement(this.calendarButton);
        clickOnElement(this.nextMonth);
        clickOnElement(this.nextMonth);
        int daysCalendarSize = this.calendarDayLists.size();
        int cont = 0;
        boolean selectedDayFlag = false;

        /*while (cont < daysCalendarSize-1 && !selectedDayFlag){
            if(this.calendarDayLists.get(cont).getAttribute("class").contains(this.focusDayCalendar)){
                this.calendarDayLists.get(daysFromToday).click();
                selectedDayFlag = true;
            }
            cont++;

        }*/
        LocalDate currentDate = LocalDate.now();
        String dayOfWeekPlus = currentDate.getMonth().name();
        log.info("----"+dayOfWeekPlus);
        clickOnElement(this.day);
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);

        return new ResultsSearchFlight(getDriver());
    }
    public void increaseTravelers(){
        clickOnElement(this.numberOfTravelers);
        clickOnElement(this.increaseAdultTraveler);
        clickOnElement(this.doneButton);
    }
}
