package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Class for interact with the page to choose returning flight.
 * @author norma.losada
 */

public class ChooseReturningFlightPage extends BasePage {

    @FindBy(css = "div[data-test-id=\"intersection-observer\"]")
    private List<WebElement> flightsOfferingsList;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "a[data-test-id=\"forcedChoiceNoThanks\"]")
    private WebElement noThanksOption;

    @FindBy(css = "li[aria-label=\"Step 2 of 3. Choose returning flight. Current page\"]")
    private WebElement chooseReturningPage;

    @FindBy(css = "span[data-test-id=\"departure-time\"]")
    private List<WebElement> estimatedDepartureAndArrivalTimeSelectedFlight;

    @FindBy(css = "div[data-test-id=\"flight-summary\"] h3>span")
    private WebElement estimatedDepartureAndArrivalTimeSideBar;


    private String selectFlightsPageHandle ="";

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ChooseReturningFlightPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if choose returning flight page is displayed
     * @return boolean
     */
    public boolean isChooseReturningPageDisplayed(){
        waitElementVisibility(this.chooseReturningPage);
        return this.chooseReturningPage.isDisplayed();
    }

    /**
     * Click on third option to choose returning flight
     */
    public void clickOnThirdFlightOption(){
        int thirdIndex = 2;
        waitElementsVisibility(flightsOfferingsList);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(flightsOfferingsList.get(thirdIndex));
        waitElementVisibility(flightsOfferingsList.get(thirdIndex));
        actions.perform();
        explicitWait(flightsOfferingsList.get(thirdIndex), 40);
        clickOnElement(flightsOfferingsList.get(thirdIndex));
    }

    /**
     *Verify if the Departure and Arrival time from selected flight match with the side panel
     * @param index, int
     *@return boolean
     */
    public boolean verifyDepartureAndArrivalTimeMatch(int index) {
        waitElementsVisibility(estimatedDepartureAndArrivalTimeSelectedFlight);
        waitElementVisibility(estimatedDepartureAndArrivalTimeSideBar);
        String deparAndArriTimeSelectedFlightText = estimatedDepartureAndArrivalTimeSelectedFlight.get(index).getText();
        String deparAndArriTimeSideBarText = estimatedDepartureAndArrivalTimeSideBar.getText();
        System.out.println(deparAndArriTimeSelectedFlightText);
        System.out.println(deparAndArriTimeSideBarText);
        return deparAndArriTimeSelectedFlightText.equals(deparAndArriTimeSideBarText);
    }

    /**
     * Click on Continue button
     */
    public void clickOnContinueButton(){
        waitElementVisibility(continueButton);
        clickOnElement(continueButton);
    }

    /**
     * Click on No Thanks option
     * @return FlightConfirmationPage page
     */

    public FlightConfirmationPage clickOnNoThanksOption(){
        clickOnElement(this.noThanksOption);

        Set<String> windowsHandlesAfterClick = getDriver().getWindowHandles();
        Iterator<String> iterator2 = windowsHandlesAfterClick.iterator();

        while(iterator2.hasNext()){
            String childWindow = iterator2.next();
            if(!this.selectFlightsPageHandle.equals(childWindow)){
                getDriver().switchTo().window(childWindow);
            }
        }
        return new FlightConfirmationPage(getDriver());
    }
}
