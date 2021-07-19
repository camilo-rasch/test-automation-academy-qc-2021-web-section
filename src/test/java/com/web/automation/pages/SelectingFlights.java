package com.web.automation.pages;

import com.google.common.base.CharMatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * selecting flights methods and some assert
 * @author fabio.alarcon
 */
public class SelectingFlights extends BasePage{


    @FindBy(css = "[data-test-id=\"journey-duration\"]")
    private List<WebElement> flightDuration;

    @FindBy(css = "span[data-test-id=\"departure-time\"]")
    private List<WebElement> departureTimeAndArrivalMainPage;

    @FindBy(css = "div[data-test-id=\"flight-summary\"] span[aria-hidden=\"true\"]")
    private WebElement departureTimeAndArrivalSideBar;

    @FindBy(css = "button[data-test-id=\"select-link\"]")
    private List<WebElement> selectButton;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "span[class=\"uitk-text uitk-type-500 uitk-type-bold uitk-text-emphasis-theme\"]")
    private WebElement totalPrice;

    @FindBy(css = "div[data-test-id=\"flight-review-0\"]")
    private WebElement departureFullInfo;

    @FindBy(css = "div[data-test-id=\"flight-review-1\"]")
    private WebElement returnFullInfo;

    @FindBy(css = "h2[class=\"uitk-heading-4\"]")
    private List<WebElement> titlePrice;

    @FindBy(css = "div[data-test-id=\"fare-summary\"] h3[class=\"uitk-heading-7\"]")
    private List<WebElement> fareEconomy;

    @FindBy(css = "button[data-test-id=\"goto-checkout-button\"]")
    private WebElement continueBooking;

    private String tripFinalDetails ="";

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public SelectingFlights(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Confirm that the flight duration was sorted from lower time
     * @return boolean
     */
    public boolean afterSort(){
        getDriver().navigate().refresh();
        waitElementsVisibility(this.flightDuration);

        boolean result = true;
        char letterAmongNumbers = 'h';
        String journeyLast;
        double numbers;
        List<Double> onlyNumbers = new ArrayList<>();

        for (WebElement turningNumber : flightDuration){
            char letterConfirm = turningNumber.getText().charAt(1);
            journeyLast = CharMatcher.inRange('0','9').retainFrom(turningNumber.getText());
            if (letterConfirm != letterAmongNumbers){
                numbers = Double.parseDouble(journeyLast) * 0.01;
            }else {
                numbers = Double.parseDouble(journeyLast);
            }
            onlyNumbers.add(numbers);
        }

        for (int i = 0; i < onlyNumbers.size()-1; i++){
            if (onlyNumbers.get(i+1) < onlyNumbers.get(i)){
                result = false;
            }
        }
        return result;
    }

    /**
     *Select a flight
     * @param index integer
     */
    public void clickToSelectAFlight(int index){
        getDriver().navigate().refresh();
        waitElementsVisibility(this.departureTimeAndArrivalMainPage);
        String initialFlightTimeInformation = this.departureTimeAndArrivalMainPage.get(index-1).getText();
        List<WebElement> flightsOrder = selectButton;
        flightsOrder.get(index-1).click();

        waitElementVisibility(this.departureTimeAndArrivalSideBar);
        String sideBarText = this.departureTimeAndArrivalSideBar.getText();

        if (initialFlightTimeInformation.matches(sideBarText)){
            clickOnElement(this.continueButton);
        }
    }

    /**
     * Confirm if 'total price' is displayed
     * @return boolean
     */
    public boolean totalPrice(){
        Set<String> windowsHandles = getDriver().getWindowHandles();
        Iterator<String> iterator2 = windowsHandles.iterator();

        while(iterator2.hasNext()){
            String childWindow = iterator2.next();
            if(!this.tripFinalDetails.equals(childWindow)){
                getDriver().switchTo().window(childWindow);
            }
        }
        waitElementVisibility(totalPrice);
        return this.totalPrice.isDisplayed();
    }

    /**
     * Confirm if departure time and return tiem is displayed
     * @return
     */
    public boolean departureReturnInfo(){
        return (this.departureFullInfo.isDisplayed() && this.returnFullInfo.isDisplayed());
    }

    /**
     * Confirm if the price is displayed
     * @return boolean
     */
    public boolean priceText(){
        return this.titlePrice.get(2).isDisplayed();
    }

    /**
     * Confirm the trip is economy fare
     * @return boolean
     */
    public boolean fareEconomy() {
        List<WebElement> firstAndSecondFare = this.fareEconomy;
        String firstInTheList = firstAndSecondFare.get(0).getText();
        String secondInTheList = firstAndSecondFare.get(1).getText();
        return (firstInTheList.contains("Fare: Economy") || secondInTheList.contains("Fare: Economy"));
    }

    /**
     * Click to next booking step
     * @return driver
     */
    public SecureBooking continueBooking(){
        clickOnElement(this.continueBooking);
        return new SecureBooking(getDriver());
    }

}