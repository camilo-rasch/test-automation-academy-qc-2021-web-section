package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SelectingFlights extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public SelectingFlights(WebDriver pDriver) {
        super(pDriver);
    }

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
     * @param index
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

    public boolean departureReturnInfo(){
        return (this.departureFullInfo.isDisplayed() && this.returnFullInfo.isDisplayed());
    }

    public boolean priceText(){
        return this.titlePrice.get(2).isDisplayed();
    }

    public boolean fareEconomy() {
        List<WebElement> firstAndSecondFare = this.fareEconomy;
        String firstInTheList = firstAndSecondFare.get(0).getText();
        String secondInTheList = firstAndSecondFare.get(1).getText();
        return (firstAndSecondFare.contains("Fare: Economy") || secondInTheList.contains("Fare: Economy"));
    }

    public SecureBooking continueBooking(){
        clickOnElement(this.continueBooking);
        return new SecureBooking(getDriver());
    }

}