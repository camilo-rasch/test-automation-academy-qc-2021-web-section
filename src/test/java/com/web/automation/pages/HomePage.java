package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 *
 * @author Silvana.Perez
 */
public class HomePage extends BasePage {

    @FindBy(css = "#uitk-tabs-button-container a[href*='flight']")
    private WebElement flightsButton;

    @FindBy(css="a[href='?flightType=roundtrip']")
    private WebElement roundTripButton;

    @FindBy(css="a[data-testid='travelers-field']")
    private WebElement travellersButton;

    @FindBy(css="button[data-testid='guests-done-button']")
    private WebElement doneButton;

    @FindBy(css = "div[data-testid*='leg1-origin-container']")
    private WebElement inputDepartureWrapper;

    @FindBy(css = "section #location-field-leg1-origin")
    private WebElement departureInput;

    @FindBy(css = "li[data-stid*='leg1-origin']")
    private List<WebElement> depaturesResultsList;

    @FindBy(css = "div[data-testid*='leg1-destination']")
    private WebElement inputDestinationWrapper;

    @FindBy(css = "section #location-field-leg1-destination")
    private WebElement destinationInput;

    @FindBy(css = "li[data-stid*='field-leg1-destination-result']")
    private List<WebElement> destinationResultsList;

    @FindBy(css=".uitk-calendar svg[aria-labelledby*='nextMonth']")
    private WebElement nextMonthButton;

    @FindBy(id = "d1-btn")
    private WebElement calendarButton;

    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;

    @FindBy(css = "button[data-stid='apply-date-picker']")
    private WebElement calendarDoneButton;

    @FindBy(css = "button[data-testid='submit-button']")
    private WebElement searchButton;

    /**
     * Constructor.
     *
     * @param driver WebDriver
     * @param url    String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }


    /**
     * Select flight type.
     */
    public void selectFlightType() {
        clickOnElement(this.flightsButton);
        clickOnElement(this.roundTripButton);
    }

    /**
     * Select travelers.
     */
    public void selectNumberOfTravelers(){
        clickOnElement(this.travellersButton);
        getDriver().switchTo().activeElement();
        String incrementButtonSelector = "//div[contains(@class,'adult')]//button[2]";
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(incrementButtonSelector)));
        getDriver().findElement(By.xpath(incrementButtonSelector)).click();
        clickOnElement(this.doneButton);
        getDriver().switchTo().defaultContent();
    }

    /**
     * Search a one way trip flight
     *
     * @param origin        origin
     * @param destination   destination
     * @param daysFromToday days from today to choose
     * @return result search flight page
     */
    public ResultSearchFlightPage searchFlight(String origin, String destination, int daysFromToday){

        waitElementVisibility(this.inputDepartureWrapper);
        clickOnElement(this.inputDepartureWrapper);
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
        Actions act = new Actions(getDriver());
        act.click(this.nextMonthButton).perform();
        this.calendarDayLists.get(3).click();

        int daysCalendarSize = this.calendarDayLists.size();
        int cont = 0;
        boolean selectedDayFlag = false;

        while (cont < daysCalendarSize-1 && !selectedDayFlag){
            String focusDayCalendar = "edge";
            if(this.calendarDayLists.get(cont).getAttribute("class").contains(focusDayCalendar)){
                this.calendarDayLists.get(cont+daysFromToday).click();
                selectedDayFlag = true;
            }
            cont++;
        }
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.searchButton);

        return new ResultSearchFlightPage(getDriver());
    }
}
