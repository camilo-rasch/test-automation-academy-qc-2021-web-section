package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

/**
 * Class for interact with the Result departure page.
 *
 */
public class ResultDeparturePage extends BasePage {


    @FindBy(css = "select[data-test-id=\"sortDropdown\"]")
    private WebElement sortButton;

    @FindBy(css = "button[data-test-id=\"select-link\"]")
    private List<WebElement> departureResultList;

    @FindBy(css = "[data-test-id=\"journey-duration\"]")
    private List<WebElement> journeysDurationList;

    @FindBy(css = "div[data-test-id=\"price-column\"]")
    private List<WebElement> flightPricesList;

    @FindBy(css = "div[data-test-id=\"flight-operated\"]")
    private List<WebElement> flightAirlineList;

    @FindBy(css = "div[data-test-id=\"arrival-departure\"]")
    private List<WebElement> flightRouteList;

    @FindBy(css = "span[data-test-id='departure-time']")
    private List<WebElement> departureArrivalTime;

    @FindBy(css = "div[data-test-id=\"flight-summary\"] h3 span")
    private WebElement departureArrivalTimeDetail;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    private Select sortByDropDown;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultDeparturePage(WebDriver pDriver) {
        super(pDriver);

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[data-test-id=\"sortDropdown\"]")));
        this.sortByDropDown = new Select(getDriver().findElement(By.cssSelector("select[data-test-id=\"sortDropdown\"]")));
    }


    /**
     * Sort the list from lowest to highest
     *
     */
    public void sortByDuration() {
        this.sortByDropDown.selectByValue("DURATION_INCREASING");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Verify if sort button is displayed
     *
     */
    public boolean isSortButtonDisplayed() {
        waitElementVisibility(sortButton);
        return sortButton.isDisplayed();
    }


    /**
     * Verify if flight price is displayed
     *
     */
    public boolean isFlightPriceDisplayed() {

        for (int i = 0; i < flightPricesList.size(); i++) {
            boolean isPriceDisplayed = flightPricesList.get(i).getAttribute("data-test-id").contains("price-column");
            if (!isPriceDisplayed)
                return false;
        }
        return true;
    }


    /**
     * Verify if flight duration is displayed
     *
     */
    public boolean isFlightDurationDisplayed() {

        for (int i = 0; i < journeysDurationList.size(); i++) {
            boolean isDurationDisplayed = journeysDurationList.get(i).isDisplayed();
            if (!isDurationDisplayed)
                return false;
        }
        return true;
    }


    /**
     * Verify if flight airline is displayed
     *
     */
    public boolean isFlightAirlineDisplayed() {

        for (int i = 0; i < flightAirlineList.size(); i++) {
            boolean isAirlineDisplayed = flightAirlineList.get(i).isDisplayed();
            if (!isAirlineDisplayed)
                return false;
        }
        return true;
    }


    /**
     * Verify if flight route is displayed
     *
     */
    public boolean isFlightRouteDisplayed() {

        for (int i = 0; i < flightRouteList.size(); i++) {
            boolean isAirlineDisplayed = flightRouteList.get(i).isDisplayed();
            if (!isAirlineDisplayed)
                return false;
        }
        return true;
    }


    /**
     * Add integer values(duration times) to a list
     * @return timesList
     */
    public List<Integer> addTimesList() {
        String durationTime;
        int hoursToMinutes = 0;
        List<Integer> timesList = new ArrayList<>();

        for (int i = 0; i < journeysDurationList.size(); i++) {
            durationTime = journeysDurationList.get(i).getText();
            if (durationTime.contains("h")) {
                hoursToMinutes = Integer.parseInt(durationTime.substring(durationTime.indexOf("h") - 1, durationTime.indexOf("h")).trim()) * 60;
            }

            timesList.add(Integer.parseInt((durationTime.substring(durationTime.indexOf("m") - 2, durationTime.indexOf("m"))).trim()) + hoursToMinutes);
            hoursToMinutes = 0;
        }
        return timesList;
    }


    /**
     * Verify if the list with integer values is sorted
     *
     */
    public boolean isSortedList() {
        List<Integer> durations;
        durations = addTimesList();

        for (int i = 0; i < durations.size() - 1; i++) {
            if (durations.get(i) > durations.get(i + 1))
                return false;
        }
        return true;
    }


    /**
     * Verify if departure and arrival time matches in sidebar flight review
     * @return compareTimeText
     */
    public boolean timeMatchesWithTimeDetail(){
        waitElementsVisibility(this.departureArrivalTime);
        String timeText = this.departureArrivalTime.get(0).getText();
        waitElementVisibility(this.departureArrivalTimeDetail);
        String timeDetailText = this.departureArrivalTimeDetail.getText();

        boolean compareTimeText = timeText.equalsIgnoreCase(timeDetailText);

        return compareTimeText;
    }


    /**
     * Click on the first flight result
     *
     */
    public void clickOnFirstResultList() {
        int i = 0;
        boolean firstResultFlag = false;

        while (i < departureResultList.size() && !firstResultFlag) {
            clickOnElement(departureResultList.get(i));
            firstResultFlag = true;
        }

    }

    /**
     * Click on the continue button
     * @return ResultReturnPage
     */
    public ResultReturnPage clickOnContinueButton() {
        clickOnElement(continueButton);
        return new ResultReturnPage(getDriver());
    }

}

