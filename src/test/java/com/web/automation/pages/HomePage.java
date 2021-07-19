package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class for interact with the home page.
 * @author
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-origin-result-item\"]")
    private List<WebElement> depaturesResultsList;

    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInput;

    @FindBy(css = "li[data-stid=\"location-field-leg1-destination-result-item\"]")
    private List<WebElement> destinationResultsList;

    @FindBy(id = "d1-btn")
    private WebElement departingCalendarButton;

    @FindBy(id = "d2-btn")
    private WebElement returningCalendarButton;

    @FindBy(css = "[class=\"uitk-calendar\"] div:nth-child(1) button:nth-child(2)")
    private WebElement datePagingButton;

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

    @FindBy(css = "a[data-testid='travelers-field']")
    private WebElement travelerLink;

    @FindBy(css = "div[class*=\"step-input-controls\"] button:nth-child(3)")
    private WebElement increaseAdultButton;

    @FindBy(css = "[data-testid='guests-done-button']")
    private WebElement travelersDoneButton;

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
     * Search a round trip flight with two travelers
     * @param origin
     * @param destination
     * @param daysFromNextMonths days from today to choose
     * @return ResultDeparturePage
     */
    public ResultDeparturePage searchFlight(String origin, String destination, int daysFromNextMonths){
        clickOnElement(this.flightsButton);

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


        clickOnElement(this.departingCalendarButton);
        for(int i = 0; i < 2; i++) {
            clickOnElement(datePagingButton);
        }

        int i = 0;
        boolean selectedDayFlag = false;
        int daysCalendarSize = this.calendarDayLists.size();

        while (i < daysCalendarSize && !selectedDayFlag){
                this.calendarDayLists.get(i + daysFromNextMonths).click();
                selectedDayFlag = true;
            }
            i++;

        clickOnElement(this.calendarDoneButton);



        clickOnElement(this.returningCalendarButton);
        daysCalendarSize = this.calendarDayLists.size();
        int j = 0;
        selectedDayFlag = false;

        while (j < daysCalendarSize && !selectedDayFlag){
            if(this.calendarDayLists.get(j).getAttribute("class").contains(this.focusDayCalendar)){
                this.calendarDayLists.get(j + daysFromNextMonths).click();
                selectedDayFlag = true;
            }
            j++;
        }
        clickOnElement(this.calendarDoneButton);

        clickOnElement(this.travelerLink);
        clickOnElement(this.increaseAdultButton);
        clickOnElement(this.travelersDoneButton);

        clickOnElement(this.submitButton);


        return new ResultDeparturePage(getDriver());
    }
}
