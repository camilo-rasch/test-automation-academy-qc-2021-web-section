package com.web.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.lang.Thread.sleep;

public class ResultsSearchFlight extends BasePage {

    //Locator to find the continue button
    @FindBy(css = "button[data-test-id='select-button']")
    private WebElement continueButton;

    //Locator to find the no thanks button in the pop-up
    @FindBy(css = "a[data-test-id='forcedChoiceNoThanks']")
    private WebElement noThanksButton;

    //Locator to find the sort by list
    @FindBy(css = "#listings-sort")
    private WebElement sortByList;

    //Locator to find the price of the flight
    @FindBy(css = "[data-test-id*='footer']>div>section")
    private WebElement priceOfTheFlight;

    //Locator to find the flight duration
    @FindBy(css = "[data-test-id='flight-summary']")
    private WebElement flightDuration;

    //Locator to find close option after to select a flight option
    @FindBy(css = "[data-icon*='close']")
    private WebElement closeButton;

    //Locator to find the airline and route
    @FindBy(css = "[data-test-id*='review']>h2~div")
    private WebElement airlineAndRoute;

    //Locator to find the schedule flight
    @FindBy(css = "[data-test-id*='summary']>h3>span")
    private WebElement scheduleFlight;

    //Locator to find the flight duration time
    @FindBy(css = "[data-test-id*='summary']>h3~span")
    private WebElement flightDurationTime;

    //Locator to find each result
    private final By listOption = By.cssSelector("[data-test-id='select-link']");
    private String searchFlightsPageHandle = "";
    private int i;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultsSearchFlight(WebDriver pDriver) {
        super(pDriver);
    }
    /**
     * Method to click on continue button
     * @return new CustomerPaymentPage(getDriver()) CustomerPaymentPage
     */
    public void clickOnContinueButton() {
        this.searchFlightsPageHandle = getDriver().getWindowHandle();
        clickOnElement(this.continueButton);
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait and check if the element sortByList is displayed
     * @return existsElement(this.sortByList) boolean
     */
    public boolean isSortByPresent() {
        return existsElement(sortByList);
    }
    /**
     *
     *
     */
    public FlightConfirmationPage clickOnNoThanksLink() {
        try {
            waitElementVisibility(this.noThanksButton);
            clickOnElement(this.noThanksButton);
        } catch (NoSuchElementException | TimeoutException e) {
            log.info(">> The pop-up is not present");
        }
        Set<String> windowsHandlesAfterClick = getDriver().getWindowHandles();
        Iterator<String> iterator2 = windowsHandlesAfterClick.iterator();

        while (iterator2.hasNext()) {
            String childWindow = iterator2.next();
            if (!this.searchFlightsPageHandle.equals(childWindow)) {
                getDriver().switchTo().window(childWindow);
            }
        }
        return new FlightConfirmationPage(getDriver());
    }


    Select myDropDown;
    /**
     *
     *
     */
    public ResultsSearchFlight selectDropdownValue(String value) {
        isSortByPresent();
        this.myDropDown = new Select(getDriver().findElement(By.id("listings-sort")));
        this.myDropDown.selectByValue(value);
        return new ResultsSearchFlight(getDriver());
    }
    /**
     *
     *
     */
    public void validationsInEachResult() {
        List<WebElement> myElements = getDriver().findElements(this.listOption);
        waitElementsVisibility(myElements);
        for (WebElement optionList : myElements) {

            clickOnElement(optionList);

            waitElementVisibility(this.priceOfTheFlight);
            this.priceOfTheFlight.isDisplayed();

            waitElementVisibility(this.flightDuration);
            this.flightDuration.isDisplayed();

            waitElementVisibility(this.airlineAndRoute);
            this.airlineAndRoute.isDisplayed();

            waitElementVisibility(this.closeButton);
            clickOnElement(this.closeButton);
        }
    }
    /**
     *
     *
     */
    public boolean clickOnFlightAndValidateTheTime(int option){
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.listOption));
        List<WebElement> myElements = getDriver().findElements(this.listOption);
        WebElement element;
        for (this.i = 0; this.i < option; this.i++) {
            element = myElements.get(this.i);
            if (this.i == (option - 1)) {
                clickOnElement(element);
                waitElementVisibility(this.scheduleFlight);
                String scheduleFightText = element.getText();
                String scheduleFightText1 = this.scheduleFlight.getText();
                String[] time = scheduleFightText1.split("-");
                boolean verificationDepartureTime = scheduleFightText.contains(time[0]);
                boolean verificationArrivalTime = scheduleFightText.contains(time[1]);
                if (verificationDepartureTime == verificationArrivalTime) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     *
     *
     */
    public boolean validateTheListDurationShorter1() throws InterruptedException {
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.listOption));
        //For some reason without this sleep the execution sometimes failed
        sleep(2000);
        List<WebElement> myElements = getDriver().findElements(this.listOption);
        waitElementsVisibility(myElements);
        int size = myElements.size();
        int currentTime = 0;
        WebElement optionInTheList;
        for (i = 0; i < size; i++) {
            int previousTime = currentTime;
            optionInTheList = myElements.get(i);
            waitElementVisibility(optionInTheList);
            clickOnElement(optionInTheList);
            waitElementVisibility(this.flightDurationTime);
            String hourTotal = this.flightDurationTime.getText();
            if (hourTotal.contains("h ")) {
                String[] time = hourTotal.split("h ");
                int hourInMinutes = Integer.parseInt(time[0]) * 60;
                String time2 = time[1];
                String[] time3 = time2.split("m");
                int minutes = Integer.parseInt(time3[0]);
                currentTime = hourInMinutes + minutes;
            } else {
                String[] time3 = hourTotal.split("m");
                currentTime = Integer.parseInt(time3[0]);
            }
            if (currentTime < previousTime) {
                return false;
            }
            waitElementVisibility(this.closeButton);
            //For some reason without this sleep the execution sometimes failed
            sleep(100);
            clickOnElement(this.closeButton);
        }
        return true;
    }
}