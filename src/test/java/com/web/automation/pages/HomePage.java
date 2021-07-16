package com.web.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon / fabio.alarcon
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"flight\"]")
    private WebElement flightsButton;

    @FindBy(css = "#uitk-tabs-button-container a[href*=\"round\"]")
    private WebElement roundTripButton;

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

    @FindBy(css = "button[class=\"uitk-date-picker-day uitk-new-date-picker-day selected edge\"]")
    private WebElement selectDayDefault;

    @FindBy(css = "button[data-stid=\"date-picker-paging\"]:last-child")
    private WebElement nextMonthButton;

    @FindBy(css = "div[class=\"uitk-experimental-adaptive\"]")
    private WebElement selectorTravelers;

    @FindBy(css = "svg[class=\"uitk-icon uitk-step-input-icon uitk-icon-medium\"]")
    private List<WebElement> addAdults;

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
     * Method to select two travelers
     */
    public void selectionTwoTravelers() {

        clickOnElement(this.flightsButton);
        clickOnElement(this.selectorTravelers);
        List<WebElement> addingAdults = addAdults;
        addingAdults.get(1).click();
        clickOnElement(this.selectorTravelers);
    }

    /**
     * Method to type the origin destination
     * @param origin String origin
     */
    public void searchFlightOrigin(String origin) {

        clickOnElement(this.roundTripButton);
        waitElementVisibility(this.inputDepatureWrapper);
        clickOnElement(this.inputDepatureWrapper);
        this.departureInput.click();
        this.departureInput.sendKeys(origin);
        for (WebElement element : this.depaturesResultsList) {
            if (element.getText().contains(origin)) {
                element.click();
            }
        }
    }

    /**
     * Method to type the final destination
     * @param destination String destination
     */
    public void searchFlightDeparture(String destination) {

        waitElementVisibility(this.inputDestinationWrapper);
        clickOnElement(this.inputDestinationWrapper);
        clickOnElement(this.destinationInput);
        this.destinationInput.sendKeys(destination);
        for (WebElement element : this.destinationResultsList) {
                String elementText = element.getText();
                if (elementText.contains(destination)) {
                    element.click();
                }
            }
    }

    /**
     * Method to select dates - two months
     * @return driver
     */
    public ResultsSearchFlight searchFlightDates() {

        clickOnElement(this.calendarButton);
        clickOnElement(this.selectDayDefault);
        int daySelected = Integer.parseInt(selectDayDefault.getAttribute("data-day"));
        String daySelectedS = selectDayDefault.getAttribute("data-day");
        log.info(daySelected);
        clickOnElement(this.nextMonthButton);
        clickOnElement(this.nextMonthButton);
        this.calendarDayLists.get(daySelected-1).click();
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);

        return new ResultsSearchFlight(getDriver());
    }
}
